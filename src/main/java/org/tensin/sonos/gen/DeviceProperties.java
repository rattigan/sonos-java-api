package org.tensin.sonos.gen;

import org.teleal.cling.model.meta.Service;
import org.teleal.cling.model.meta.Action;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.controlpoint.ActionCallback;
import org.teleal.cling.UpnpService;
import org.teleal.cling.model.meta.RemoteDevice;
import org.tensin.sonos.helpers.RemoteDeviceHelper;
import org.tensin.sonos.helpers.ServiceHelper;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;
import org.teleal.cling.model.types.UnsignedIntegerTwoBytes;
import org.tensin.sonos.SonosException;


public class DeviceProperties {
    private Service service;
    private UpnpService upnpService;

    public DeviceProperties(UpnpService upnpService, RemoteDevice device) {
        this.upnpService = upnpService;
        this.service = RemoteDeviceHelper.findService(device, "urn:upnp-org:serviceId:DeviceProperties");
    }
    
    public enum LEDState {On, Off}

    
    public SetLEDStateRequest setLEDState() {
        return new SetLEDStateRequest();
    }

    public GetLEDStateRequest getLEDState() {
        return new GetLEDStateRequest();
    }

    public SetInvisibleRequest setInvisible() {
        return new SetInvisibleRequest();
    }

    public GetInvisibleRequest getInvisible() {
        return new GetInvisibleRequest();
    }

    public AddBondedZonesRequest addBondedZones() {
        return new AddBondedZonesRequest();
    }

    public RemoveBondedZonesRequest removeBondedZones() {
        return new RemoveBondedZonesRequest();
    }

    public CreateStereoPairRequest createStereoPair() {
        return new CreateStereoPairRequest();
    }

    public SeparateStereoPairRequest separateStereoPair() {
        return new SeparateStereoPairRequest();
    }

    public SetZoneAttributesRequest setZoneAttributes() {
        return new SetZoneAttributesRequest();
    }

    public GetZoneAttributesRequest getZoneAttributes() {
        return new GetZoneAttributesRequest();
    }

    public GetHouseholdIDRequest getHouseholdID() {
        return new GetHouseholdIDRequest();
    }

    public GetZoneInfoRequest getZoneInfo() {
        return new GetZoneInfoRequest();
    }

    public SetAutoplayLinkedZonesRequest setAutoplayLinkedZones() {
        return new SetAutoplayLinkedZonesRequest();
    }

    public GetAutoplayLinkedZonesRequest getAutoplayLinkedZones() {
        return new GetAutoplayLinkedZonesRequest();
    }

    public SetAutoplayRoomUUIDRequest setAutoplayRoomUUID() {
        return new SetAutoplayRoomUUIDRequest();
    }

    public GetAutoplayRoomUUIDRequest getAutoplayRoomUUID() {
        return new GetAutoplayRoomUUIDRequest();
    }

    public SetAutoplayVolumeRequest setAutoplayVolume() {
        return new SetAutoplayVolumeRequest();
    }

    public GetAutoplayVolumeRequest getAutoplayVolume() {
        return new GetAutoplayVolumeRequest();
    }

    public ImportSettingRequest importSetting() {
        return new ImportSettingRequest();
    }

    public SetUseAutoplayVolumeRequest setUseAutoplayVolume() {
        return new SetUseAutoplayVolumeRequest();
    }

    public GetUseAutoplayVolumeRequest getUseAutoplayVolume() {
        return new GetUseAutoplayVolumeRequest();
    }

    public AddHTSatelliteRequest addHTSatellite() {
        return new AddHTSatelliteRequest();
    }

    public RemoveHTSatelliteRequest removeHTSatellite() {
        return new RemoveHTSatelliteRequest();
    }

    
    public class SetLEDStateRequest {
        
        private LEDState desiredLEDState;

        
        public SetLEDStateRequest desiredLEDState(LEDState desiredLEDState) {
            this.desiredLEDState = desiredLEDState;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetLEDState");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("DesiredLEDState", this.desiredLEDState);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetLEDStateRequest {
        
        
        public GetLEDStateResponse execute() throws SonosException {
            Action action = service.getAction("GetLEDState");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetLEDStateResponse response = new GetLEDStateResponse();
            
            response.currentLEDState = ServiceHelper._string(invocation, "CurrentLEDState", LEDState.class);

            return response;

        }
    }

    public class SetInvisibleRequest {
        
        private boolean desiredInvisible;

        
        public SetInvisibleRequest desiredInvisible(boolean desiredInvisible) {
            this.desiredInvisible = desiredInvisible;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetInvisible");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("DesiredInvisible", this.desiredInvisible);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetInvisibleRequest {
        
        
        public GetInvisibleResponse execute() throws SonosException {
            Action action = service.getAction("GetInvisible");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetInvisibleResponse response = new GetInvisibleResponse();
            
            response.currentInvisible = ServiceHelper._boolean(invocation, "CurrentInvisible");

            return response;

        }
    }

    public class AddBondedZonesRequest {
        
        private String channelMapSet;

        
        public AddBondedZonesRequest channelMapSet(String channelMapSet) {
            this.channelMapSet = channelMapSet;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("AddBondedZones");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("ChannelMapSet", this.channelMapSet);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class RemoveBondedZonesRequest {
        
        private String channelMapSet;

        
        public RemoveBondedZonesRequest channelMapSet(String channelMapSet) {
            this.channelMapSet = channelMapSet;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("RemoveBondedZones");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("ChannelMapSet", this.channelMapSet);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class CreateStereoPairRequest {
        
        private String channelMapSet;

        
        public CreateStereoPairRequest channelMapSet(String channelMapSet) {
            this.channelMapSet = channelMapSet;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("CreateStereoPair");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("ChannelMapSet", this.channelMapSet);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class SeparateStereoPairRequest {
        
        private String channelMapSet;

        
        public SeparateStereoPairRequest channelMapSet(String channelMapSet) {
            this.channelMapSet = channelMapSet;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SeparateStereoPair");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("ChannelMapSet", this.channelMapSet);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class SetZoneAttributesRequest {
        
        private String desiredZoneName;

        private String desiredIcon;

        private String desiredConfiguration;

        
        public SetZoneAttributesRequest desiredZoneName(String desiredZoneName) {
            this.desiredZoneName = desiredZoneName;
            return this;
        }

        public SetZoneAttributesRequest desiredIcon(String desiredIcon) {
            this.desiredIcon = desiredIcon;
            return this;
        }

        public SetZoneAttributesRequest desiredConfiguration(String desiredConfiguration) {
            this.desiredConfiguration = desiredConfiguration;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetZoneAttributes");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("DesiredZoneName", this.desiredZoneName);

            invocation.setInput("DesiredIcon", this.desiredIcon);

            invocation.setInput("DesiredConfiguration", this.desiredConfiguration);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetZoneAttributesRequest {
        
        
        public GetZoneAttributesResponse execute() throws SonosException {
            Action action = service.getAction("GetZoneAttributes");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetZoneAttributesResponse response = new GetZoneAttributesResponse();
            
            response.currentZoneName = ServiceHelper._string(invocation, "CurrentZoneName");

            response.currentIcon = ServiceHelper._string(invocation, "CurrentIcon");

            response.currentConfiguration = ServiceHelper._string(invocation, "CurrentConfiguration");

            return response;

        }
    }

    public class GetHouseholdIDRequest {
        
        
        public GetHouseholdIDResponse execute() throws SonosException {
            Action action = service.getAction("GetHouseholdID");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetHouseholdIDResponse response = new GetHouseholdIDResponse();
            
            response.currentHouseholdID = ServiceHelper._string(invocation, "CurrentHouseholdID");

            return response;

        }
    }

    public class GetZoneInfoRequest {
        
        
        public GetZoneInfoResponse execute() throws SonosException {
            Action action = service.getAction("GetZoneInfo");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetZoneInfoResponse response = new GetZoneInfoResponse();
            
            response.serialNumber = ServiceHelper._string(invocation, "SerialNumber");

            response.softwareVersion = ServiceHelper._string(invocation, "SoftwareVersion");

            response.displaySoftwareVersion = ServiceHelper._string(invocation, "DisplaySoftwareVersion");

            response.hardwareVersion = ServiceHelper._string(invocation, "HardwareVersion");

            response.iPAddress = ServiceHelper._string(invocation, "IPAddress");

            response.mACAddress = ServiceHelper._string(invocation, "MACAddress");

            response.copyrightInfo = ServiceHelper._string(invocation, "CopyrightInfo");

            response.extraInfo = ServiceHelper._string(invocation, "ExtraInfo");

            response.hTAudioIn = ServiceHelper._ui4(invocation, "HTAudioIn");

            return response;

        }
    }

    public class SetAutoplayLinkedZonesRequest {
        
        private boolean includeLinkedZones;

        
        public SetAutoplayLinkedZonesRequest includeLinkedZones(boolean includeLinkedZones) {
            this.includeLinkedZones = includeLinkedZones;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetAutoplayLinkedZones");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("IncludeLinkedZones", this.includeLinkedZones);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetAutoplayLinkedZonesRequest {
        
        
        public GetAutoplayLinkedZonesResponse execute() throws SonosException {
            Action action = service.getAction("GetAutoplayLinkedZones");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetAutoplayLinkedZonesResponse response = new GetAutoplayLinkedZonesResponse();
            
            response.includeLinkedZones = ServiceHelper._boolean(invocation, "IncludeLinkedZones");

            return response;

        }
    }

    public class SetAutoplayRoomUUIDRequest {
        
        private String roomUUID;

        
        public SetAutoplayRoomUUIDRequest roomUUID(String roomUUID) {
            this.roomUUID = roomUUID;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetAutoplayRoomUUID");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("RoomUUID", this.roomUUID);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetAutoplayRoomUUIDRequest {
        
        
        public GetAutoplayRoomUUIDResponse execute() throws SonosException {
            Action action = service.getAction("GetAutoplayRoomUUID");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetAutoplayRoomUUIDResponse response = new GetAutoplayRoomUUIDResponse();
            
            response.roomUUID = ServiceHelper._string(invocation, "RoomUUID");

            return response;

        }
    }

    public class SetAutoplayVolumeRequest {
        
        private int volume;

        
        public SetAutoplayVolumeRequest volume(int volume) {
            this.volume = volume;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetAutoplayVolume");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("Volume", new UnsignedIntegerTwoBytes(this.volume));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetAutoplayVolumeRequest {
        
        
        public GetAutoplayVolumeResponse execute() throws SonosException {
            Action action = service.getAction("GetAutoplayVolume");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetAutoplayVolumeResponse response = new GetAutoplayVolumeResponse();
            
            response.currentVolume = ServiceHelper._ui2(invocation, "CurrentVolume");

            return response;

        }
    }

    public class ImportSettingRequest {
        
        private int settingID;

        private String settingURI;

        
        public ImportSettingRequest settingID(int settingID) {
            this.settingID = settingID;
            return this;
        }

        public ImportSettingRequest settingURI(String settingURI) {
            this.settingURI = settingURI;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("ImportSetting");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("SettingID", new UnsignedIntegerFourBytes(this.settingID));

            invocation.setInput("SettingURI", this.settingURI);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class SetUseAutoplayVolumeRequest {
        
        private boolean useVolume;

        
        public SetUseAutoplayVolumeRequest useVolume(boolean useVolume) {
            this.useVolume = useVolume;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetUseAutoplayVolume");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("UseVolume", this.useVolume);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetUseAutoplayVolumeRequest {
        
        
        public GetUseAutoplayVolumeResponse execute() throws SonosException {
            Action action = service.getAction("GetUseAutoplayVolume");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetUseAutoplayVolumeResponse response = new GetUseAutoplayVolumeResponse();
            
            response.useVolume = ServiceHelper._boolean(invocation, "UseVolume");

            return response;

        }
    }

    public class AddHTSatelliteRequest {
        
        private String hTSatChanMapSet;

        
        public AddHTSatelliteRequest hTSatChanMapSet(String hTSatChanMapSet) {
            this.hTSatChanMapSet = hTSatChanMapSet;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("AddHTSatellite");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("HTSatChanMapSet", this.hTSatChanMapSet);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class RemoveHTSatelliteRequest {
        
        private String satRoomUUID;

        
        public RemoveHTSatelliteRequest satRoomUUID(String satRoomUUID) {
            this.satRoomUUID = satRoomUUID;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("RemoveHTSatellite");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("SatRoomUUID", this.satRoomUUID);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    
    public class GetLEDStateResponse {
        
        private LEDState currentLEDState;

        
        public LEDState currentLEDState() {
            return currentLEDState;
        }

    }

    public class GetInvisibleResponse {
        
        private boolean currentInvisible;

        
        public boolean currentInvisible() {
            return currentInvisible;
        }

    }

    public class GetZoneAttributesResponse {
        
        private String currentZoneName;

        private String currentIcon;

        private String currentConfiguration;

        
        public String currentZoneName() {
            return currentZoneName;
        }

        public String currentIcon() {
            return currentIcon;
        }

        public String currentConfiguration() {
            return currentConfiguration;
        }

    }

    public class GetHouseholdIDResponse {
        
        private String currentHouseholdID;

        
        public String currentHouseholdID() {
            return currentHouseholdID;
        }

    }

    public class GetZoneInfoResponse {
        
        private String serialNumber;

        private String softwareVersion;

        private String displaySoftwareVersion;

        private String hardwareVersion;

        private String iPAddress;

        private String mACAddress;

        private String copyrightInfo;

        private String extraInfo;

        private int hTAudioIn;

        
        public String serialNumber() {
            return serialNumber;
        }

        public String softwareVersion() {
            return softwareVersion;
        }

        public String displaySoftwareVersion() {
            return displaySoftwareVersion;
        }

        public String hardwareVersion() {
            return hardwareVersion;
        }

        public String iPAddress() {
            return iPAddress;
        }

        public String mACAddress() {
            return mACAddress;
        }

        public String copyrightInfo() {
            return copyrightInfo;
        }

        public String extraInfo() {
            return extraInfo;
        }

        public int hTAudioIn() {
            return hTAudioIn;
        }

    }

    public class GetAutoplayLinkedZonesResponse {
        
        private boolean includeLinkedZones;

        
        public boolean includeLinkedZones() {
            return includeLinkedZones;
        }

    }

    public class GetAutoplayRoomUUIDResponse {
        
        private String roomUUID;

        
        public String roomUUID() {
            return roomUUID;
        }

    }

    public class GetAutoplayVolumeResponse {
        
        private int currentVolume;

        
        public int currentVolume() {
            return currentVolume;
        }

    }

    public class GetUseAutoplayVolumeResponse {
        
        private boolean useVolume;

        
        public boolean useVolume() {
            return useVolume;
        }

    }

}
