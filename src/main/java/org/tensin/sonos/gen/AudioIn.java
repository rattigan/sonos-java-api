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


public class AudioIn {
    private Service service;
    private UpnpService upnpService;

    public AudioIn(UpnpService upnpService, RemoteDevice device) {
        this.upnpService = upnpService;
        this.service = RemoteDeviceHelper.findService(device, "urn:upnp-org:serviceId:AudioIn");
    }
    
    
    public StartTransmissionToGroupRequest startTransmissionToGroup() {
        return new StartTransmissionToGroupRequest();
    }

    public StopTransmissionToGroupRequest stopTransmissionToGroup() {
        return new StopTransmissionToGroupRequest();
    }

    public SetAudioInputAttributesRequest setAudioInputAttributes() {
        return new SetAudioInputAttributesRequest();
    }

    public GetAudioInputAttributesRequest getAudioInputAttributes() {
        return new GetAudioInputAttributesRequest();
    }

    public SetLineInLevelRequest setLineInLevel() {
        return new SetLineInLevelRequest();
    }

    public GetLineInLevelRequest getLineInLevel() {
        return new GetLineInLevelRequest();
    }

    public SelectAudioRequest selectAudio() {
        return new SelectAudioRequest();
    }

    
    public class StartTransmissionToGroupRequest {
        
        private String coordinatorID;

        
        public StartTransmissionToGroupRequest coordinatorID(String coordinatorID) {
            this.coordinatorID = coordinatorID;
            return this;
        }

        public StartTransmissionToGroupResponse execute() {
            Action action = service.getAction("StartTransmissionToGroup");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("CoordinatorID", this.coordinatorID);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            StartTransmissionToGroupResponse response = new StartTransmissionToGroupResponse();
            
            response.currentTransportSettings = ServiceHelper._string(invocation, "CurrentTransportSettings");

            return response;

        }
    }

    public class StopTransmissionToGroupRequest {
        
        private String coordinatorID;

        
        public StopTransmissionToGroupRequest coordinatorID(String coordinatorID) {
            this.coordinatorID = coordinatorID;
            return this;
        }

        public void execute() {
            Action action = service.getAction("StopTransmissionToGroup");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("CoordinatorID", this.coordinatorID);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class SetAudioInputAttributesRequest {
        
        private String desiredName;

        private String desiredIcon;

        
        public SetAudioInputAttributesRequest desiredName(String desiredName) {
            this.desiredName = desiredName;
            return this;
        }

        public SetAudioInputAttributesRequest desiredIcon(String desiredIcon) {
            this.desiredIcon = desiredIcon;
            return this;
        }

        public void execute() {
            Action action = service.getAction("SetAudioInputAttributes");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("DesiredName", this.desiredName);

            invocation.setInput("DesiredIcon", this.desiredIcon);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetAudioInputAttributesRequest {
        
        
        public GetAudioInputAttributesResponse execute() {
            Action action = service.getAction("GetAudioInputAttributes");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetAudioInputAttributesResponse response = new GetAudioInputAttributesResponse();
            
            response.currentName = ServiceHelper._string(invocation, "CurrentName");

            response.currentIcon = ServiceHelper._string(invocation, "CurrentIcon");

            return response;

        }
    }

    public class SetLineInLevelRequest {
        
        private int desiredLeftLineInLevel;

        private int desiredRightLineInLevel;

        
        public SetLineInLevelRequest desiredLeftLineInLevel(int desiredLeftLineInLevel) {
            this.desiredLeftLineInLevel = desiredLeftLineInLevel;
            return this;
        }

        public SetLineInLevelRequest desiredRightLineInLevel(int desiredRightLineInLevel) {
            this.desiredRightLineInLevel = desiredRightLineInLevel;
            return this;
        }

        public void execute() {
            Action action = service.getAction("SetLineInLevel");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("DesiredLeftLineInLevel", this.desiredLeftLineInLevel);

            invocation.setInput("DesiredRightLineInLevel", this.desiredRightLineInLevel);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetLineInLevelRequest {
        
        
        public GetLineInLevelResponse execute() {
            Action action = service.getAction("GetLineInLevel");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetLineInLevelResponse response = new GetLineInLevelResponse();
            
            response.currentLeftLineInLevel = ServiceHelper._i4(invocation, "CurrentLeftLineInLevel");

            response.currentRightLineInLevel = ServiceHelper._i4(invocation, "CurrentRightLineInLevel");

            return response;

        }
    }

    public class SelectAudioRequest {
        
        private String objectID;

        
        public SelectAudioRequest objectID(String objectID) {
            this.objectID = objectID;
            return this;
        }

        public void execute() {
            Action action = service.getAction("SelectAudio");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("ObjectID", this.objectID);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    
    public class StartTransmissionToGroupResponse {
        
        private String currentTransportSettings;

        
        public String currentTransportSettings() {
            return currentTransportSettings;
        }

    }

    public class GetAudioInputAttributesResponse {
        
        private String currentName;

        private String currentIcon;

        
        public String currentName() {
            return currentName;
        }

        public String currentIcon() {
            return currentIcon;
        }

    }

    public class GetLineInLevelResponse {
        
        private int currentLeftLineInLevel;

        private int currentRightLineInLevel;

        
        public int currentLeftLineInLevel() {
            return currentLeftLineInLevel;
        }

        public int currentRightLineInLevel() {
            return currentRightLineInLevel;
        }

    }

}
