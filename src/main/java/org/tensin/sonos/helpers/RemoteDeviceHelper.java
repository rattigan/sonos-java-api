package org.tensin.sonos.helpers;

import com.google.common.base.Joiner;
import org.teleal.cling.model.meta.Action;
import org.teleal.cling.model.meta.ActionArgument;
import org.teleal.cling.model.meta.RemoteDevice;
import org.teleal.cling.model.meta.Service;
import org.teleal.cling.model.types.Datatype;
import org.teleal.cling.model.types.UDAServiceId;

/**
 * The Class RemoteDeviceHelper.
 */
public class RemoteDeviceHelper {

    /**
     * Dump remote device.
     *
     * @param device the device
     * @return the string
     */
    public static String dumpRemoteDevice(final RemoteDevice device) {
        final StringBuilder sb = new StringBuilder();
        sb.append(device.toString()).append('\n');

        sb.append("  Details :").append('\n');
        sb.append("    Name [").append(device.getDetails().getFriendlyName()).append("]").append('\n');
        sb.append("    Serial Number [").append(device.getDetails().getSerialNumber()).append("]").append('\n');
        sb.append("    UPC [").append(device.getDetails().getUpc()).append("]").append('\n');
        sb.append("    Base URL [").append(device.getDetails().getBaseURL()).append("]").append('\n');
        sb.append("    URI [").append(device.getDetails().getPresentationURI()).append("]").append('\n');
        sb.append("    Manufacturer :").append('\n');
        sb.append("      Manufacturer [").append(device.getDetails().getManufacturerDetails().getManufacturer()).append("]").append('\n');
        sb.append("      Manufacturer URI [").append(device.getDetails().getManufacturerDetails().getManufacturerURI()).append("]")
                .append('\n');
        sb.append("    Model :").append('\n');
        sb.append("      Name [").append(device.getDetails().getModelDetails().getModelName()).append("]").append('\n');
        sb.append("      Description [").append(device.getDetails().getModelDetails().getModelDescription()).append("]").append('\n');
        sb.append("      Model Number [").append(device.getDetails().getModelDetails().getModelNumber()).append("]").append('\n');
        sb.append("      Model URI [").append(device.getDetails().getModelDetails().getModelURI()).append("]").append('\n');

        sb.append("  Identity :").append('\n');
        sb.append("    UDN [").append(device.getIdentity().getUdn()).append("]").append('\n');
        sb.append("    Descriptor URL [").append(device.getIdentity().getDescriptorURL()).append("]").append('\n');
        sb.append("    Discovered on local address [").append(device.getIdentity().getDiscoveredOnLocalAddress()).append("]").append('\n');
        sb.append("    Interface MAC addresss [").append(device.getIdentity().getInterfaceMacAddress()).append("]").append('\n');
        sb.append("    Max age (seconds) [").append(device.getIdentity().getMaxAgeSeconds()).append("]").append('\n');
        sb.append("    WoL bytes [").append(device.getIdentity().getWakeOnLANBytes()).append("]").append('\n');

        sb.append("  Identity [").append(device.getVersion().toString()).append("]").append('\n');

        sb.append("  Embedded devices :").append('\n');
        for (final RemoteDevice remoteDevice : device.findEmbeddedDevices()) {
            sb.append("    - ").append(remoteDevice.toString()).append('\n');
        }

        sb.append("  Services :").append('\n');
        for (final Service service : device.findServices()) {
            // sb.append("    - ").append(service.toString()).append(SonosConstants.NEWLINE);
            sb.append("    - ").append(service.getServiceId()).append('\n');
            sb.append("        Actions :").append('\n');
            for (final Action action : service.getActions()) {
                sb.append("          - ").append(action.getName())
                        .append('\n');
                for (ActionArgument argument : action.getInputArguments()) {
                    Datatype datatype = argument.getDatatype();
                    sb.append("              ->")
                            .append(argument.getName())
                            .append(": ")
                            .append(datatype.getDisplayString())
                            .append(" (state ")
                            .append(argument.getRelatedStateVariableName())
                            .append(" )");
                    if (argument.getAliases().length > 0) {
                        sb.append("\n              <- aliases: ")
                                .append(Joiner.on(", ").join(argument.getAliases()));
                    }
                    sb.append('\n');
                }
                for (ActionArgument argument : action.getOutputArguments()) {
                    Datatype datatype = argument.getDatatype();
                    sb.append("              <-")
                            .append(argument.getName())
                            .append(": ")
                            .append(datatype.getDisplayString())
                            .append(" (state ")
                            .append(argument.getRelatedStateVariableName())
                            .append(" )");
                    if (argument.getAliases().length > 0) {
                        sb.append("\n              <- aliases: ")
                                .append(Joiner.on(", ").join(argument.getAliases()));
                    }
                    sb.append('\n');
                }
            }
        }

//        sb.append("  Services types:").append('\n');
//        for (final ServiceType serviceType : device.findServiceTypes()) {
//            sb.append("    - ").append(serviceType.toString()).append('\n');
//        }

        return sb.toString();
    }

    public static RemoteDevice findChildDevice(RemoteDevice device, String type) {
        for (RemoteDevice remoteDevice : device.getEmbeddedDevices()) {
            if (remoteDevice.getType().toString().equalsIgnoreCase(type)) {
                return remoteDevice;
            }
        }
        return null;
    }

    public static Service findService(final RemoteDevice device, final String serviceName) {
        UDAServiceId uadServiceId = UDAServiceId.valueOf(serviceName.replace(":1", ""));
        return device.findService(uadServiceId);
    }

}
