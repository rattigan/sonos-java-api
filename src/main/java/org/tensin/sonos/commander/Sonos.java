package org.tensin.sonos.commander;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.teleal.cling.UpnpService;
import org.teleal.cling.UpnpServiceImpl;
import org.teleal.cling.model.message.header.UDAServiceTypeHeader;
import org.teleal.cling.model.meta.RemoteDevice;
import org.teleal.cling.model.types.UDAServiceType;
import org.teleal.cling.registry.DefaultRegistryListener;
import org.teleal.cling.registry.Registry;
import org.teleal.cling.registry.RegistryListener;
import org.tensin.sonos.SonosConstants;
import org.tensin.sonos.SonosException;
import org.tensin.sonos.control.ZonePlayer;
import org.tensin.sonos.gen.AVTransport;
import org.tensin.sonos.gen.AlarmClock;
import org.tensin.sonos.gen.AudioIn;
import org.tensin.sonos.gen.ConnectionManager;
import org.tensin.sonos.gen.ContentDirectory;
import org.tensin.sonos.gen.DeviceProperties;
import org.tensin.sonos.gen.GroupManagement;
import org.tensin.sonos.gen.GroupRenderingControl;
import org.tensin.sonos.gen.MusicServices;
import org.tensin.sonos.gen.MusicServices.ListAvailableServicesRequest;
import org.tensin.sonos.gen.MusicServices.ListAvailableServicesResponse;
import org.tensin.sonos.gen.QPlay;
import org.tensin.sonos.gen.Queue;
import org.tensin.sonos.gen.RenderingControl;
import org.tensin.sonos.gen.SystemProperties;
import org.tensin.sonos.gen.ZoneGroupTopology;
import org.tensin.sonos.helpers.EntryHelper;
import org.tensin.sonos.helpers.RemoteDeviceHelper;
import org.tensin.sonos.helpers.TimeUtilities;
import org.tensin.sonos.model.Entry;
import org.tensin.sonos.model.ZoneGroup;
import org.tensin.sonos.model.ZoneGroupState;
import org.tensin.sonos.model.musicService.MusicService;
import org.tensin.sonos.xml.ResultParser;
import org.xml.sax.SAXException;

import com.google.common.collect.Lists;

/**
 */
public class Sonos implements Closeable {
    private static final Logger log = LoggerFactory.getLogger(Sonos.class);

    private static final int DEFAULT_UDP_SEARCH_TIME = 120;
    public static final int MAX_TRIES = 10;

    // The maximum volume a speaker can be set to.
    public static final int MAX_VOLUME = 100;

    private List<ZonePlayer> zonePlayers = Lists.newArrayList();

    private UpnpService upnpService;

    private int udpSearchTime = DEFAULT_UDP_SEARCH_TIME;

    public Sonos(long disoveryMillis) {
        startDiscovery();
        TimeUtilities.waitMilliSeconds(disoveryMillis);
    }

    public Sonos() {
        this(SonosConstants.MAX_DISCOVER_TIME_IN_MILLISECONDS);
    }

    private ZonePlayer addZonePlayer(RemoteDevice dev) {
        synchronized (zonePlayers) {
            if (isZonePlayerAlreadyDefined(dev.getIdentity().getUdn().getIdentifierString())) {
                return null;
            }

            // Ignore zone bridges
            // TODO may need to implement cut down zone player for the zone
            // bridge
            // I believe the bridge only supports the following interfaces:
            // - DeviceProperties
            // - GroupManagement
            // - SystemProperties
            // - ZoneGroup
            Collection<String> ignoredDevicesModelName = new ArrayList<String>();
            // ignoredDevicesModelName.add("ZB100");
            // ignoredDevicesModelName.add("BR100");
            for (String ignoredDeviceModelName : ignoredDevicesModelName) {
                if (dev.getDetails().getModelDetails().getModelNumber().toUpperCase().contains(ignoredDeviceModelName))
                    return null;
            }

            log.info("Adding zone: " + getDeviceDescription(dev));

            try {
                ZonePlayer zone = new ZonePlayer(upnpService, dev);
                zonePlayers.add(zone);
                return zone;
            } catch (Exception e) {
                log.error("Couldn't add zone" + getDeviceDescription(dev), e);
            }

            return null;
        }
    }

    private String getDeviceDescription(RemoteDevice dev) {
        return dev.getType().getDisplayString() + " " + dev.getDetails().getModelDetails().getModelDescription() + " "
                + dev.getDetails().getModelDetails().getModelName() + " "
                + dev.getDetails().getModelDetails().getModelNumber();
    }

    public synchronized ZonePlayer getPlayer(String name) {
        name = name.toLowerCase();
        synchronized (zonePlayers) {
            for (ZonePlayer zp : zonePlayers) {
                if (getZoneName(zp).toLowerCase().equals(name))
                    return zp;
            }
            throw new RuntimeException("Invalid player id: [" + name + "]");
        }
    }

    private ZonePlayer getZonePlayerById(String id) {
        synchronized (zonePlayers) {
            for (ZonePlayer zp : zonePlayers) {
                if (zp.getId().equals(id))
                    return zp;
            }
            throw new RuntimeException("Invalid player id: [" + id + "]");
        }
    }

    private ZonePlayer getZonePlayerByUDN(String udn) {
        for (ZonePlayer zone : zonePlayers) {
            if (zone.getRootDevice().getIdentity().getUdn().getIdentifierString().equals(udn))
                return zone;
        }
        return null;
    }

    private boolean isZonePlayerAlreadyDefined(String udn) {
        return getZonePlayerByUDN(udn) != null;
    }

    private void removeZonePlayer(String udn) {
        synchronized (zonePlayers) {
            ZonePlayer zp = getZonePlayerByUDN(udn);
            if (zp != null) {
                log.info("Removing ZonePlayer " + udn + " "
                        + zp.getRootDevice().getDetails().getModelDetails().getModelDescription());
                zonePlayers.remove(zp);
                zp.dispose();
            }
        }
    }

    public synchronized void close() {
        log.info("Shutting down UPNP services and discovery");
        upnpService.shutdown();
        log.info("Cleaning up internal resources");
        synchronized (zonePlayers) {
            for (ZonePlayer zp : zonePlayers)
                zp.dispose();
        }
    }

    private void startDiscovery() {
        upnpService = new UpnpServiceImpl(listener);
        // Send a search message to all devices and services, they should
        // respond soon
        UDAServiceType udaType = new UDAServiceType(SonosConstants.AV_TRANSPORT);
        upnpService.getControlPoint().search(new UDAServiceTypeHeader(udaType), udpSearchTime);
    }

    private boolean isSonosDevice(RemoteDevice device) {
        return device.getDetails().getManufacturerDetails().getManufacturer().toUpperCase().contains("SONOS");
    }

    /**
     * The listener.
     */
    private RegistryListener listener = new DefaultRegistryListener() {
        @Override
        public void remoteDeviceAdded(Registry registry, RemoteDevice device) {
            if (isSonosDevice(device))
                addZonePlayer(device);
        }

        @Override
        public void remoteDeviceRemoved(Registry registry, RemoteDevice device) {
            if (isSonosDevice(device)) {
                String udn = device.getIdentity().getUdn().toString();
                removeZonePlayer(udn);
                log.info("Device [" + udn + "] disconnected");
            }
        }
    };

    private ZonePlayer getCoordinator(ZonePlayer zp) {
        if (zp == null)
            return null;

        ZoneGroupTopology.GetZoneGroupStateResponse response = getZoneGroupTopology(zp).getZoneGroupState().execute();
        ZoneGroupState state = ResultParser.getGroupStateFromResult(response.zoneGroupState());
        if (state == null)
            return zp;
        for (final ZoneGroup zg : state.getGroups()) {
            if (zg.getMembers().contains(zp.getId()))
                return getZonePlayerById(zg.getCoordinator());
        }
        return zp;
    }

    public synchronized List<String> getZoneNames() {
        List<String> zones = Lists.newArrayList();
        for (ZonePlayer player : zonePlayers)
            zones.add(getZoneName(player));
        return zones;
    }

    public synchronized String getInfo(ZonePlayer player) {
        return RemoteDeviceHelper.dumpRemoteDevice(player.getRootDevice());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Facade

    public synchronized AVTransport.AddURIToQueueResponse enqueue(ZonePlayer player, String url) {
        Entry entry = EntryHelper.createEntryForUrl(url);
        return getAvTransport(getCoordinator(player)).addURIToQueue().enqueuedURI(entry.getRes())
                .enqueuedURIMetaData(EntryHelper.compileMetadataString(entry)).enqueueAsNext(true).execute();
    }

    public synchronized Iterable<Entry> browse(final ZonePlayer player, String type) {
        // TODO paging support
        ContentDirectory.BrowseResponse response = getContentDirectory(player).browse().objectID(type).filter("*")// "dc:title,res,dc:creator,upnp:artist,upnp:album")
                .browseFlag(ContentDirectory.BrowseFlag.BrowseDirectChildren).requestedCount(Integer.MAX_VALUE)
                .execute();
        String xml = response.result();
        return ResultParser.getEntriesFromStringResult(xml);
    }

    public synchronized Iterable<Entry> browseArtists(final ZonePlayer player) {
        return browse(player, "A:ARTIST");
    }

    public synchronized void crossFade(ZonePlayer player, boolean crossfade) {
        getAvTransport(player).setCrossfadeMode().crossfadeMode(crossfade).execute();
    }

    private synchronized String getZoneName(ZonePlayer player) {
        return getDeviceProperties(player).getZoneAttributes().execute().currentZoneName();
    }

    public synchronized void lineIn(ZonePlayer player) {
        getAudioIn(player).selectAudio().objectID("urn:schemas-upnp-org:service:AudioIn:1");
    }

    public synchronized void moveTracks(ZonePlayer player, int startAt, int count, int insertBefore) {
        getAvTransport(player).reorderTracksInQueue().startingIndex(startAt).numberOfTracks(count)
                .insertBefore(insertBefore).execute();
    }

    public synchronized void mute(ZonePlayer player, boolean mute) {
        getRenderingControl(player).setMute().desiredMute(mute).execute();
    }

    public synchronized void next(ZonePlayer player) {
        getAvTransport(player).next().execute();
    }

    public synchronized void previous(ZonePlayer player) {
        getAvTransport(player).previous().execute();
    }

    public synchronized void pause(ZonePlayer player) {
        getAvTransport(player).pause().execute();
    }

    public synchronized void play(ZonePlayer player) {
        getAvTransport(player).play().speed(AVTransport.TransportPlaySpeed._1).execute();
    }

    public synchronized void play(ZonePlayer player, String url) {
        track(player, enqueue(player, url).firstTrackNumberEnqueued());
    }

    public synchronized void remove(ZonePlayer player, String url) {
        Entry entry = EntryHelper.createEntryForUrl(url);
        getAvTransport(player).removeTrackFromQueue().objectID(entry.getId()).execute();
    }

    public synchronized void clearQueue(ZonePlayer player) {
        getAvTransport(player).removeAllTracksFromQueue().execute();
    }

    public synchronized void saveQueue(ZonePlayer player, String title) {
        getAvTransport(player).saveQueue().title(title).execute();
    }

    public synchronized void saveQueue(ZonePlayer player, String title, String playlistId) {
        getAvTransport(player).saveQueue().title(title).objectID(playlistId);
    }

    public synchronized void shuffle(ZonePlayer player, boolean shuffle) {
        getAvTransport(player).setPlayMode()
                .newPlayMode(
                        shuffle ? AVTransport.CurrentPlayMode.SHUFFLE_NOREPEAT : AVTransport.CurrentPlayMode.NORMAL)
                .execute();
    }

    public synchronized void track(ZonePlayer player, int track) {
        getAvTransport(player).seek().unit(AVTransport.SeekMode.TRACK_NR).target("" + track).execute();
    }

    public synchronized int volume(ZonePlayer player) {
        return getRenderingControl(player).getVolume().channel(RenderingControl.Channel.Master).execute()
                .currentVolume();
    }

    /**
     * Sets the volume of the given player.
     * 
     * Valid volumes are 0 (off) to 100 (MAX_VOLUME).
     * 
     * @param player
     * @param volume
     */
    public synchronized void setVolume(ZonePlayer player, int volume) {
        volume = clampVolume(volume);
        // Seem to be unreliable, so we set and verify as many times as needed
        int tries = MAX_TRIES;
        while (tries-- != 0) {
            getRenderingControl(player).setVolume().desiredVolume(volume).channel(RenderingControl.Channel.Master)
                    .execute();
            if (volume(player) == volume)
                return;
        }
        log.warn("Failed to set volume to: " + volume + " in zone " + getZoneName(player));
    }

    /**
     * Ensures that the passed volume is between 0 and MAX_VOLUME inclusive.
     * 
     * @param volume
     * @return
     */
    private int clampVolume(int volume) {
        volume = Math.max(0, Math.min(MAX_VOLUME, volume));
        return volume;
    }

    /**
     * Adjust the volume relative to the current volume by adding the passed
     * delta to the existing volume
     * 
     * e.g. If players current volume is 10 and the volumeChange is 2 then the
     * new volumen will be 12.
     * 
     * Valid volumes are 0 (off) to 100 (MAX_VOLUME).
     * 
     * @param player
     * @param volumeChange
     */

    public synchronized void adjustVolume(ZonePlayer player, int volumeChange) {
        setVolume(player, volume(player) + volumeChange);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Raw service wrappers

    private <T> T getService(Class<T> serviceClass, ZonePlayer player) {
        try {
            return serviceClass.getConstructor(UpnpService.class, RemoteDevice.class).newInstance(upnpService,
                    player.getRootDevice());
        } catch (Throwable e) {
            throw new SonosException(e);
        }
    }

    public AVTransport getAvTransport(ZonePlayer player) {
        return getService(AVTransport.class, player);
    }

    public ContentDirectory getContentDirectory(ZonePlayer player) {
        return getService(ContentDirectory.class, player);
    }

    public DeviceProperties getDeviceProperties(ZonePlayer player) {
        return getService(DeviceProperties.class, player);
    }

    public AlarmClock getAlarmClock(ZonePlayer player) {
        return getService(AlarmClock.class, player);
    }

    public AudioIn getAudioIn(ZonePlayer player) {
        return getService(AudioIn.class, player);
    }

    public ConnectionManager getConnectionManager(ZonePlayer player) {
        return getService(ConnectionManager.class, player);
    }

    public GroupManagement getGroupManagement(ZonePlayer player) {
        return getService(GroupManagement.class, player);
    }

    public GroupRenderingControl getGroupRenderingControl(ZonePlayer player) {
        return getService(GroupRenderingControl.class, player);
    }

    public MusicServices getMusicServices(ZonePlayer player) {
        return getService(MusicServices.class, player);
    }

    /**
     * Get the list of MusicService supported by the given ZonePlayer.
     * 
     * This method is hopefully more useful than the getMusicServices call as
     * this returns the parsed lists as a set of java objects.
     * 
     * @param List<MusicService>
     *            - list of music services supported by this ZonePlayer.
     * @return
     * @throws SAXException
     */
    public List<MusicService> getMusicServiceList(ZonePlayer player) throws SAXException {
        MusicServices services = getMusicServices(player);

        ListAvailableServicesRequest request = services.listAvailableServices();
        ListAvailableServicesResponse response = request.execute();

        String xml = response.availableServiceDescriptorList();

        return ResultParser.parseMusicServices(xml);

    }

    public QPlay getQPlay(ZonePlayer player) {
        return getService(QPlay.class, player);
    }

    public Queue getQueue(ZonePlayer player) {
        return getService(Queue.class, player);
    }

    public RenderingControl getRenderingControl(ZonePlayer player) {
        return getService(RenderingControl.class, player);
    }

    public SystemProperties getSystemProperties(ZonePlayer player) {
        return getService(SystemProperties.class, player);
    }

    public ZoneGroupTopology getZoneGroupTopology(ZonePlayer player) {
        return getService(ZoneGroupTopology.class, player);
    }

}
