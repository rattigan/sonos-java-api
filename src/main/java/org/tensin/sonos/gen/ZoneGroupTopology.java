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


public class ZoneGroupTopology {
    private Service service;
    private UpnpService upnpService;

    public ZoneGroupTopology(UpnpService upnpService, RemoteDevice device) {
        this.upnpService = upnpService;
        this.service = RemoteDeviceHelper.findService(device, "urn:upnp-org:serviceId:ZoneGroupTopology");
    }
    
    public enum UpdateType {All, Software}

    public enum UnresponsiveDeviceActionType {Remove, VerifyThenRemoveSystemwide}

    public enum Origin {Healthcheck, Server, User}

    
    public CheckForUpdateRequest checkForUpdate() {
        return new CheckForUpdateRequest();
    }

    public BeginSoftwareUpdateRequest beginSoftwareUpdate() {
        return new BeginSoftwareUpdateRequest();
    }

    public ReportUnresponsiveDeviceRequest reportUnresponsiveDevice() {
        return new ReportUnresponsiveDeviceRequest();
    }

    public ReportAlarmStartedRunningRequest reportAlarmStartedRunning() {
        return new ReportAlarmStartedRunningRequest();
    }

    public SubmitDiagnosticsRequest submitDiagnostics() {
        return new SubmitDiagnosticsRequest();
    }

    public RegisterMobileDeviceRequest registerMobileDevice() {
        return new RegisterMobileDeviceRequest();
    }

    public GetZoneGroupAttributesRequest getZoneGroupAttributes() {
        return new GetZoneGroupAttributesRequest();
    }

    public GetZoneGroupStateRequest getZoneGroupState() {
        return new GetZoneGroupStateRequest();
    }

    
    public class CheckForUpdateRequest {
        
        private UpdateType updateType;

        private boolean cachedOnly;

        private String version;

        
        public CheckForUpdateRequest updateType(UpdateType updateType) {
            this.updateType = updateType;
            return this;
        }

        public CheckForUpdateRequest cachedOnly(boolean cachedOnly) {
            this.cachedOnly = cachedOnly;
            return this;
        }

        public CheckForUpdateRequest version(String version) {
            this.version = version;
            return this;
        }

        public CheckForUpdateResponse execute() throws SonosException {
            Action action = service.getAction("CheckForUpdate");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("UpdateType", this.updateType);

            invocation.setInput("CachedOnly", this.cachedOnly);

            invocation.setInput("Version", this.version);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            CheckForUpdateResponse response = new CheckForUpdateResponse();
            
            response.updateItem = ServiceHelper._string(invocation, "UpdateItem");

            return response;

        }
    }

    public class BeginSoftwareUpdateRequest {
        
        private String updateURL;

        private int flags;

        private String extraOptions;

        
        public BeginSoftwareUpdateRequest updateURL(String updateURL) {
            this.updateURL = updateURL;
            return this;
        }

        public BeginSoftwareUpdateRequest flags(int flags) {
            this.flags = flags;
            return this;
        }

        public BeginSoftwareUpdateRequest extraOptions(String extraOptions) {
            this.extraOptions = extraOptions;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("BeginSoftwareUpdate");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("UpdateURL", this.updateURL);

            invocation.setInput("Flags", new UnsignedIntegerFourBytes(this.flags));

            invocation.setInput("ExtraOptions", this.extraOptions);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class ReportUnresponsiveDeviceRequest {
        
        private String deviceUUID;

        private UnresponsiveDeviceActionType desiredAction;

        
        public ReportUnresponsiveDeviceRequest deviceUUID(String deviceUUID) {
            this.deviceUUID = deviceUUID;
            return this;
        }

        public ReportUnresponsiveDeviceRequest desiredAction(UnresponsiveDeviceActionType desiredAction) {
            this.desiredAction = desiredAction;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("ReportUnresponsiveDevice");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("DeviceUUID", this.deviceUUID);

            invocation.setInput("DesiredAction", this.desiredAction);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class ReportAlarmStartedRunningRequest {
        
        
        public void execute() throws SonosException {
            Action action = service.getAction("ReportAlarmStartedRunning");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class SubmitDiagnosticsRequest {
        
        private boolean includeControllers;

        private Origin type;

        
        public SubmitDiagnosticsRequest includeControllers(boolean includeControllers) {
            this.includeControllers = includeControllers;
            return this;
        }

        public SubmitDiagnosticsRequest type(Origin type) {
            this.type = type;
            return this;
        }

        public SubmitDiagnosticsResponse execute() throws SonosException {
            Action action = service.getAction("SubmitDiagnostics");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("IncludeControllers", this.includeControllers);

            invocation.setInput("Type", this.type);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            SubmitDiagnosticsResponse response = new SubmitDiagnosticsResponse();
            
            response.diagnosticID = ServiceHelper._ui4(invocation, "DiagnosticID");

            return response;

        }
    }

    public class RegisterMobileDeviceRequest {
        
        private String mobileDeviceName;

        private String mobileDeviceUDN;

        private String mobileIPAndPort;

        
        public RegisterMobileDeviceRequest mobileDeviceName(String mobileDeviceName) {
            this.mobileDeviceName = mobileDeviceName;
            return this;
        }

        public RegisterMobileDeviceRequest mobileDeviceUDN(String mobileDeviceUDN) {
            this.mobileDeviceUDN = mobileDeviceUDN;
            return this;
        }

        public RegisterMobileDeviceRequest mobileIPAndPort(String mobileIPAndPort) {
            this.mobileIPAndPort = mobileIPAndPort;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("RegisterMobileDevice");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("MobileDeviceName", this.mobileDeviceName);

            invocation.setInput("MobileDeviceUDN", this.mobileDeviceUDN);

            invocation.setInput("MobileIPAndPort", this.mobileIPAndPort);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetZoneGroupAttributesRequest {
        
        
        public GetZoneGroupAttributesResponse execute() throws SonosException {
            Action action = service.getAction("GetZoneGroupAttributes");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetZoneGroupAttributesResponse response = new GetZoneGroupAttributesResponse();
            
            response.currentZoneGroupName = ServiceHelper._string(invocation, "CurrentZoneGroupName");

            response.currentZoneGroupID = ServiceHelper._string(invocation, "CurrentZoneGroupID");

            response.currentZonePlayerUUIDsInGroup = ServiceHelper._string(invocation, "CurrentZonePlayerUUIDsInGroup");

            return response;

        }
    }

    public class GetZoneGroupStateRequest {
        
        
        public GetZoneGroupStateResponse execute() throws SonosException {
            Action action = service.getAction("GetZoneGroupState");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetZoneGroupStateResponse response = new GetZoneGroupStateResponse();
            
            response.zoneGroupState = ServiceHelper._string(invocation, "ZoneGroupState");

            return response;

        }
    }

    
    public class CheckForUpdateResponse {
        
        private String updateItem;

        
        public String updateItem() {
            return updateItem;
        }

    }

    public class SubmitDiagnosticsResponse {
        
        private int diagnosticID;

        
        public int diagnosticID() {
            return diagnosticID;
        }

    }

    public class GetZoneGroupAttributesResponse {
        
        private String currentZoneGroupName;

        private String currentZoneGroupID;

        private String currentZonePlayerUUIDsInGroup;

        
        public String currentZoneGroupName() {
            return currentZoneGroupName;
        }

        public String currentZoneGroupID() {
            return currentZoneGroupID;
        }

        public String currentZonePlayerUUIDsInGroup() {
            return currentZonePlayerUUIDsInGroup;
        }

    }

    public class GetZoneGroupStateResponse {
        
        private String zoneGroupState;

        
        public String zoneGroupState() {
            return zoneGroupState;
        }

    }

}
