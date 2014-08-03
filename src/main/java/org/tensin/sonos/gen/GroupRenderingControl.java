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


public class GroupRenderingControl {
    private Service service;
    private UpnpService upnpService;

    public GroupRenderingControl(UpnpService upnpService, RemoteDevice device) {
        this.upnpService = upnpService;
        this.service = RemoteDeviceHelper.findService(device, "urn:upnp-org:serviceId:GroupRenderingControl");
    }
    
    
    public GetGroupMuteRequest getGroupMute() {
        return new GetGroupMuteRequest();
    }

    public SetGroupMuteRequest setGroupMute() {
        return new SetGroupMuteRequest();
    }

    public GetGroupVolumeRequest getGroupVolume() {
        return new GetGroupVolumeRequest();
    }

    public SetGroupVolumeRequest setGroupVolume() {
        return new SetGroupVolumeRequest();
    }

    public SetRelativeGroupVolumeRequest setRelativeGroupVolume() {
        return new SetRelativeGroupVolumeRequest();
    }

    public SnapshotGroupVolumeRequest snapshotGroupVolume() {
        return new SnapshotGroupVolumeRequest();
    }

    
    public class GetGroupMuteRequest {
        
        private int instanceID;

        
        public GetGroupMuteRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetGroupMuteResponse execute() {
            Action action = service.getAction("GetGroupMute");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetGroupMuteResponse response = new GetGroupMuteResponse();
            
            response.currentMute = ServiceHelper._boolean(invocation, "CurrentMute");

            return response;

        }
    }

    public class SetGroupMuteRequest {
        
        private int instanceID;

        private boolean desiredMute;

        
        public SetGroupMuteRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SetGroupMuteRequest desiredMute(boolean desiredMute) {
            this.desiredMute = desiredMute;
            return this;
        }

        public void execute() {
            Action action = service.getAction("SetGroupMute");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("DesiredMute", this.desiredMute);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetGroupVolumeRequest {
        
        private int instanceID;

        
        public GetGroupVolumeRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetGroupVolumeResponse execute() {
            Action action = service.getAction("GetGroupVolume");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetGroupVolumeResponse response = new GetGroupVolumeResponse();
            
            response.currentVolume = ServiceHelper._ui2(invocation, "CurrentVolume");

            return response;

        }
    }

    public class SetGroupVolumeRequest {
        
        private int instanceID;

        private int desiredVolume;

        
        public SetGroupVolumeRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SetGroupVolumeRequest desiredVolume(int desiredVolume) {
            this.desiredVolume = desiredVolume;
            return this;
        }

        public void execute() {
            Action action = service.getAction("SetGroupVolume");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("DesiredVolume", new UnsignedIntegerTwoBytes(this.desiredVolume));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class SetRelativeGroupVolumeRequest {
        
        private int instanceID;

        private int adjustment;

        
        public SetRelativeGroupVolumeRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SetRelativeGroupVolumeRequest adjustment(int adjustment) {
            this.adjustment = adjustment;
            return this;
        }

        public SetRelativeGroupVolumeResponse execute() {
            Action action = service.getAction("SetRelativeGroupVolume");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Adjustment", this.adjustment);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            SetRelativeGroupVolumeResponse response = new SetRelativeGroupVolumeResponse();
            
            response.newVolume = ServiceHelper._ui2(invocation, "NewVolume");

            return response;

        }
    }

    public class SnapshotGroupVolumeRequest {
        
        private int instanceID;

        
        public SnapshotGroupVolumeRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public void execute() {
            Action action = service.getAction("SnapshotGroupVolume");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    
    public class GetGroupMuteResponse {
        
        private boolean currentMute;

        
        public boolean currentMute() {
            return currentMute;
        }

    }

    public class GetGroupVolumeResponse {
        
        private int currentVolume;

        
        public int currentVolume() {
            return currentVolume;
        }

    }

    public class SetRelativeGroupVolumeResponse {
        
        private int newVolume;

        
        public int newVolume() {
            return newVolume;
        }

    }

}
