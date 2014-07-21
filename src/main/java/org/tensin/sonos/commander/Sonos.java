package org.tensin.sonos.commander;

import com.beust.jcommander.internal.Lists;
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
import org.tensin.sonos.control.BrowseHandle;
import org.tensin.sonos.control.ZonePlayer;
import org.tensin.sonos.helpers.EntryHelper;
import org.tensin.sonos.helpers.RemoteDeviceHelper;
import org.tensin.sonos.helpers.TimeUtilities;
import org.tensin.sonos.model.*;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 */
public class Sonos implements Closeable {
    private static final Logger log = LoggerFactory.getLogger(Sonos.class);

    private static final int DEFAULT_UDP_SEARCH_TIME = 120;

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

    public ZonePlayer addZonePlayer(RemoteDevice dev) {
        synchronized (zonePlayers) {
            if (isZonePlayerAlreadyDefined(dev.getIdentity().getUdn().getIdentifierString())) {
                return null;
            }

            // Ignore zone bridges
            // TODO may need to implement cut down zone player for the zone bridge
            // I believe the bridge only supports the following interfaces:
            // - DeviceProperties
            // - GroupManagement
            // - SystemProperties
            // - ZoneGroup
            Collection<String> ignoredDevicesModelName = new ArrayList<String>();
            ignoredDevicesModelName.add("ZB100");
            ignoredDevicesModelName.add("BR100");
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
        return dev.getType().getDisplayString() + " " +
                dev.getDetails().getModelDetails().getModelDescription() + " " +
                dev.getDetails().getModelDetails().getModelName() + " " +
                dev.getDetails().getModelDetails().getModelNumber();
    }

    public void dispose() {
        synchronized (zonePlayers) {
            for (ZonePlayer zp : zonePlayers)
                zp.dispose();
        }
    }

    public ZonePlayer getPlayer(String name) {
        name = name.toLowerCase();
        synchronized (zonePlayers) {
            for (ZonePlayer zp : zonePlayers) {
                if (getZoneName(zp).toLowerCase().equals(name))
                    return zp;
            }
            throw new RuntimeException("Invalid player id: [" + name + "]");
        }
    }

    public ZonePlayer getZonePlayerById(String id) {
        synchronized (zonePlayers) {
            for (ZonePlayer zp : zonePlayers) {
                if (zp.getId().equals(id))
                    return zp;
            }
            throw new RuntimeException("Invalid player id: [" + id + "]");
        }
    }

    public ZonePlayer getZonePlayerByUDN(String udn) {
        for (ZonePlayer zone : zonePlayers) {
            if (zone.getRootDevice().getIdentity().getUdn().getIdentifierString().equals(udn))
                return zone;
        }
        return null;
    }


    public boolean isZonePlayerAlreadyDefined(String udn) {
        return getZonePlayerByUDN(udn) != null;
    }

    public void removeZonePlayer(String udn) {
        synchronized (zonePlayers) {
            ZonePlayer zp = getZonePlayerByUDN(udn);
            if (zp != null) {
                log.info("Removing ZonePlayer " + udn + " " + zp.getRootDevice().getDetails().getModelDetails().getModelDescription());
                zonePlayers.remove(zp);
                zp.dispose();
            }
        }
    }

    public void close() {
        log.info("Shutting down UPNP services and discovery");
        upnpService.shutdown();
        log.info("Cleaning up internal resources");
        dispose();
    }

    public void startDiscovery() {
        upnpService = new UpnpServiceImpl(listener);
        // Send a search message to all devices and services, they should respond soon
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

    public ZonePlayer getCoordinator(final ZonePlayer zp) {
        if ((zp == null) || (zp.getZoneGroupTopologyService().getGroupState() == null)) {
            return zp;
        }
        for (final ZoneGroup zg : zp.getZoneGroupTopologyService().getGroupState().getGroups()) {
            if (zg.getMembers().contains(zp.getId()))
                return getZonePlayerById(zg.getCoordinator());
        }
        return zp;
    }

    public void enqueue(ZonePlayer player, String url) {
        getCoordinator(player).enqueueEntry(EntryHelper.createEntryForUrl(url));
    }

    public Iterable<Entry> browse(final ZonePlayer player, String type) throws SonosException {
        EntryCollector collector = new EntryCollector();
        BrowseHandle handle = player.getMediaServerDevice()
                .getContentDirectoryService()
                .getAllEntriesAsync(collector, type);

        try {
            synchronized (handle) {
                handle.wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return collector.getEntries();
    }

    public Iterable<Entry> browseArtists(final ZonePlayer player) throws SonosException {
        return browse(player, "A:ARTIST");
    }

    public void crossFade(ZonePlayer player, boolean crossfade) {
        player.getMediaRendererDevice().getRenderingControlService().setCrossFade(crossfade);
    }

    public List<String> getZoneNames() {
        List<String> zones = Lists.newArrayList();
        for (ZonePlayer player : zonePlayers)
            zones.add(getZoneName(player));
        return zones;
    }

    private String getZoneName(ZonePlayer player) {
        return player.getDevicePropertiesService().getZoneAttributes().getName();
    }

    public String getInfo(ZonePlayer player) {
        return RemoteDeviceHelper.dumpRemoteDevice(player.getRootDevice());
    }

    public void lineIn(ZonePlayer player) {
        // TODO doesn't look right
        player.getMediaRendererDevice().getRenderingControlService().setMute(false);
        player.getMediaRendererDevice().getAvTransportService().play();
    }

    public void moveTracks(ZonePlayer player, int startAt, int count, int insertBefore) {
        player.getMediaRendererDevice().getAvTransportService()
                .reorderTracksInQueue(startAt, count, insertBefore);
    }

    public void mute(ZonePlayer player, boolean mute) {
        player.getMediaRendererDevice().getRenderingControlService().setMute(mute);
    }

    public void next(ZonePlayer player) {
        player.getMediaRendererDevice().getAvTransportService().next();
    }

    public void previous(ZonePlayer player) {
        player.getMediaRendererDevice().getAvTransportService().previous();
    }

    public void pause(ZonePlayer player) {
        player.getMediaRendererDevice().getAvTransportService().pause();
    }

    public void play(ZonePlayer player) {
        player.getMediaRendererDevice().getAvTransportService().play();
    }

    public void remove(ZonePlayer player, String url) {
        player.getMediaRendererDevice().getAvTransportService()
                .removeTrackFromQueue(EntryHelper.createEntryForUrl(url));
    }

    public void clearQueue(ZonePlayer player) {
        player.getMediaRendererDevice().getAvTransportService()
                .clearQueue();
    }

    public void saveQueue(ZonePlayer player, String title) {
        player.getMediaRendererDevice().getAvTransportService().saveQueue(title, "");
    }

    public void saveQueue(ZonePlayer player, String title, String playlistId) {
        player.getMediaRendererDevice().getAvTransportService().saveQueue(title, playlistId);
    }

    public void shuffle(ZonePlayer player, boolean shuffle) {
        player.getMediaRendererDevice().getAvTransportService().setPlayMode(shuffle ? PlayMode.SHUFFLE_NOREPEAT : PlayMode.NORMAL);
    }

    public void track(ZonePlayer player, int track) {
        SeekTarget target = new SeekTarget(SeekMode.TRACK_NR, Integer.toString(track));
        player.getMediaRendererDevice().getAvTransportService().seek(target);
    }

    public int volume(ZonePlayer player) {
        return player.getMediaRendererDevice().getRenderingControlService().getVolume();
    }

    public void setVolume(ZonePlayer player, int volume) {
        player.getMediaRendererDevice().getRenderingControlService().setVolume(volume);
    }

    public void adjustVolume(ZonePlayer player, int volumeChange) {
        int volume = player.getMediaRendererDevice().getRenderingControlService().getVolume();
        volume = volume + volumeChange;
        volume = Math.max(0, Math.min(100, volume));
        player.getMediaRendererDevice().getRenderingControlService().setVolume(volume);
    }
}
