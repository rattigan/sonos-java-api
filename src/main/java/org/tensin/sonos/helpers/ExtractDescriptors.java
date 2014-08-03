package org.tensin.sonos.helpers;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import org.teleal.cling.model.meta.RemoteDevice;
import org.teleal.cling.model.meta.RemoteService;
import org.tensin.sonos.commander.Sonos;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;


/**
 */
public class ExtractDescriptors {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Sonos sonos = new Sonos();
        try {
            List<String> zones = sonos.getZoneNames();
            for (String zone : zones) {
                RemoteDevice device = sonos.getPlayer(zone).getRootDevice();
                writeDeviceDescriptors(device, 0);
            }
        } finally {
            sonos.close();
        }
    }

    private static void writeDeviceDescriptors(RemoteDevice device, int n) throws IOException {
        for (int i = 0; i != n; i++)
            System.out.print("  ");
        System.out.println(device.getDetails().getModelDetails().getModelDescription());
        URL descriptorUrl = device.getIdentity().getDescriptorURL();
        String model = device.getDetails().getModelDetails().getModelDescription();
        writeDescriptor(model, descriptorUrl);
        RemoteService[] services = device.getServices();
        for (RemoteService service : services) {
            URL serviceUrl = new URL(descriptorUrl.getProtocol(), descriptorUrl.getHost(), descriptorUrl.getPort(), service.getDescriptorURI().toString());
            writeDescriptor(null, serviceUrl);
        }

        for (RemoteDevice embeddedDevice : device.getEmbeddedDevices()) {
            writeDeviceDescriptors(embeddedDevice, n + 1);
        }
    }

    private static void writeDescriptor(String prefix, URL descriptorUrl) throws IOException {
        String path = descriptorUrl.getPath();

        File file = prefix == null ?
                new File("descriptors", path) :
                new File("descriptors", new File(prefix, path).getPath());
        Files.createParentDirs(file);
        String deviceDescriptor = Resources.toString(descriptorUrl, Charsets.UTF_8);
        Files.write(deviceDescriptor, file, Charsets.UTF_8);
    }
}
