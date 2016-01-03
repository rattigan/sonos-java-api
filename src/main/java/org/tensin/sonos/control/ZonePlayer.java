/*
 * Copyright 2007 David Wheeler
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.tensin.sonos.control;

import org.teleal.cling.UpnpService;
import org.teleal.cling.model.meta.RemoteDevice;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Corresponds to a physical Zone Player, and gives access all the devices and
 * services that a Zone Player has.
 *
 * @author David WHEELER
 * @author Serge SIMON
 */
public class ZonePlayer {

    /**
     * Find child device.
     *
     * @param device
     *            the device
     * @param type
     *            the type
     * @return the remote device
     */
    protected static RemoteDevice findChildDevice(final RemoteDevice device, final String type) {
        for (final RemoteDevice remoteDevice : device.getEmbeddedDevices()) {
            if (remoteDevice.getType().toString().equalsIgnoreCase(type)) {
                return remoteDevice;
            }
        }
        return null;
    }

    public String toString() {
        return dev.getDetails().getFriendlyName();
    }

    /**
     * The dev.
     */
    private final RemoteDevice dev;

    /**
     * The ip.
     */
    private InetAddress ip;

    /**
     * The port.
     */
    private final int port;

    /**
     * Creates a new sonos device around the given RemoteDevice. This device
     * must be a sonos device
     *
     * @param upnpService
     *            the upnp service
     * @param dev
     *            the dev
     */
    public ZonePlayer(final UpnpService upnpService, final RemoteDevice dev) {
        if (!dev.getType().toString().equals(ZonePlayerConstants.SONOS_DEVICE_TYPE)) {
            throw new IllegalArgumentException("dev must be a sonos device, not [" + dev.getType() + "]");
        }
        this.dev = dev;
        try {
            ip = InetAddress.getByName(dev.getIdentity().getDescriptorURL().getHost());
        } catch (final UnknownHostException e) {
            // will not happen - should be IP not host
            e.printStackTrace();
        }
        port = dev.getIdentity().getDescriptorURL().getPort();
    }

    /**
     * Creates a new URL by appending the given string to this zonePlayer's
     * attributes.
     *
     * @param url
     *            the url to append, eg "/images/image1.png"
     * @return the complete url eg "http://192.168.0.1:1400/images/image1.png"
     * @throws MalformedURLException
     *             the malformed url exception
     */
    public URL appendUrl(final String url) throws MalformedURLException {
        return new URL("http", getIP().getHostAddress(), getPort(), url);
    }

    /**
     * Dispose.
     */
    public void dispose() {
    }

    /**
     * {@inheritDoc}
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof ZonePlayer) {
            final ZonePlayer zp = (ZonePlayer) obj;
            return zp.getRootDevice().getIdentity().getUdn().getIdentifierString()
                    .equals(getRootDevice().getIdentity().getUdn().getIdentifierString());
        }
        return false;
    }

    /**
     * Gets the id.
     *
     * @return A string of characters identifying this sonos to other sonos
     */
    public String getId() {
        return getRootDevice().getIdentity().getUdn().getIdentifierString().substring(5);
    }

    /**
     * Gets the ip.
     *
     * @return the IP address for this zone player.
     */
    public InetAddress getIP() {
        return ip;
    }

    // --- a few convenience methods

    /**
     * Gets the port.
     *
     * @return the port for HTTP requests to this zone player.
     */
    public int getPort() {
        return port;
    }

    /**
     * Gets the root device.
     *
     * @return the RemoteDevice around which this object has been created.
     */
    public RemoteDevice getRootDevice() {
        return dev;
    }

    /**
     * {@inheritDoc}
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return getRootDevice().getIdentity().getUdn().getIdentifierString().hashCode();
    }
}
