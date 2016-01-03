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


public class RenderingControl {
    private Service service;
    private UpnpService upnpService;

    public RenderingControl(UpnpService upnpService, RemoteDevice device) {
        this.upnpService = upnpService;
        this.service = RemoteDeviceHelper.findService(device, "urn:upnp-org:serviceId:RenderingControl");
    }
    
    public enum Channel {Master, LF, RF}

    public enum MuteChannel {Master, LF, RF, SpeakerOnly}

    public enum RampType {SLEEP_TIMER_RAMP_TYPE, ALARM_RAMP_TYPE, AUTOPLAY_RAMP_TYPE}

    
    public GetMuteRequest getMute() {
        return new GetMuteRequest();
    }

    public SetMuteRequest setMute() {
        return new SetMuteRequest();
    }

    public ResetBasicEQRequest resetBasicEQ() {
        return new ResetBasicEQRequest();
    }

    public ResetExtEQRequest resetExtEQ() {
        return new ResetExtEQRequest();
    }

    public GetVolumeRequest getVolume() {
        return new GetVolumeRequest();
    }

    public SetVolumeRequest setVolume() {
        return new SetVolumeRequest();
    }

    public SetRelativeVolumeRequest setRelativeVolume() {
        return new SetRelativeVolumeRequest();
    }

    public GetVolumeDBRequest getVolumeDB() {
        return new GetVolumeDBRequest();
    }

    public SetVolumeDBRequest setVolumeDB() {
        return new SetVolumeDBRequest();
    }

    public GetVolumeDBRangeRequest getVolumeDBRange() {
        return new GetVolumeDBRangeRequest();
    }

    public GetBassRequest getBass() {
        return new GetBassRequest();
    }

    public SetBassRequest setBass() {
        return new SetBassRequest();
    }

    public GetTrebleRequest getTreble() {
        return new GetTrebleRequest();
    }

    public SetTrebleRequest setTreble() {
        return new SetTrebleRequest();
    }

    public GetEQRequest getEQ() {
        return new GetEQRequest();
    }

    public SetEQRequest setEQ() {
        return new SetEQRequest();
    }

    public GetLoudnessRequest getLoudness() {
        return new GetLoudnessRequest();
    }

    public SetLoudnessRequest setLoudness() {
        return new SetLoudnessRequest();
    }

    public GetSupportsOutputFixedRequest getSupportsOutputFixed() {
        return new GetSupportsOutputFixedRequest();
    }

    public GetOutputFixedRequest getOutputFixed() {
        return new GetOutputFixedRequest();
    }

    public SetOutputFixedRequest setOutputFixed() {
        return new SetOutputFixedRequest();
    }

    public GetHeadphoneConnectedRequest getHeadphoneConnected() {
        return new GetHeadphoneConnectedRequest();
    }

    public RampToVolumeRequest rampToVolume() {
        return new RampToVolumeRequest();
    }

    public RestoreVolumePriorToRampRequest restoreVolumePriorToRamp() {
        return new RestoreVolumePriorToRampRequest();
    }

    public SetChannelMapRequest setChannelMap() {
        return new SetChannelMapRequest();
    }

    
    public class GetMuteRequest {
        
        private int instanceID;

        private MuteChannel channel;

        
        public GetMuteRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetMuteRequest channel(MuteChannel channel) {
            this.channel = channel;
            return this;
        }

        public GetMuteResponse execute() throws SonosException {
            Action action = service.getAction("GetMute");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Channel", this.channel);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetMuteResponse response = new GetMuteResponse();
            
            response.currentMute = ServiceHelper._boolean(invocation, "CurrentMute");

            return response;

        }
    }

    public class SetMuteRequest {
        
        private int instanceID;

        private MuteChannel channel;

        private boolean desiredMute;

        
        public SetMuteRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SetMuteRequest channel(MuteChannel channel) {
            this.channel = channel;
            return this;
        }

        public SetMuteRequest desiredMute(boolean desiredMute) {
            this.desiredMute = desiredMute;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetMute");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Channel", this.channel);

            invocation.setInput("DesiredMute", this.desiredMute);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class ResetBasicEQRequest {
        
        private int instanceID;

        
        public ResetBasicEQRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public ResetBasicEQResponse execute() throws SonosException {
            Action action = service.getAction("ResetBasicEQ");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            ResetBasicEQResponse response = new ResetBasicEQResponse();
            
            response.bass = ServiceHelper._i2(invocation, "Bass");

            response.treble = ServiceHelper._i2(invocation, "Treble");

            response.loudness = ServiceHelper._boolean(invocation, "Loudness");

            response.leftVolume = ServiceHelper._ui2(invocation, "LeftVolume");

            response.rightVolume = ServiceHelper._ui2(invocation, "RightVolume");

            return response;

        }
    }

    public class ResetExtEQRequest {
        
        private int instanceID;

        private String eQType;

        
        public ResetExtEQRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public ResetExtEQRequest eQType(String eQType) {
            this.eQType = eQType;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("ResetExtEQ");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("EQType", this.eQType);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetVolumeRequest {
        
        private int instanceID;

        private Channel channel;

        
        public GetVolumeRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetVolumeRequest channel(Channel channel) {
            this.channel = channel;
            return this;
        }

        public GetVolumeResponse execute() throws SonosException {
            Action action = service.getAction("GetVolume");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Channel", this.channel);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetVolumeResponse response = new GetVolumeResponse();
            
            response.currentVolume = ServiceHelper._ui2(invocation, "CurrentVolume");

            return response;

        }
    }

    public class SetVolumeRequest {
        
        private int instanceID;

        private Channel channel;

        private int desiredVolume;

        
        public SetVolumeRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SetVolumeRequest channel(Channel channel) {
            this.channel = channel;
            return this;
        }

        public SetVolumeRequest desiredVolume(int desiredVolume) {
            this.desiredVolume = desiredVolume;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetVolume");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Channel", this.channel);

            invocation.setInput("DesiredVolume", new UnsignedIntegerTwoBytes(this.desiredVolume));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class SetRelativeVolumeRequest {
        
        private int instanceID;

        private Channel channel;

        private int adjustment;

        
        public SetRelativeVolumeRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SetRelativeVolumeRequest channel(Channel channel) {
            this.channel = channel;
            return this;
        }

        public SetRelativeVolumeRequest adjustment(int adjustment) {
            this.adjustment = adjustment;
            return this;
        }

        public SetRelativeVolumeResponse execute() throws SonosException {
            Action action = service.getAction("SetRelativeVolume");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Channel", this.channel);

            invocation.setInput("Adjustment", this.adjustment);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            SetRelativeVolumeResponse response = new SetRelativeVolumeResponse();
            
            response.newVolume = ServiceHelper._ui2(invocation, "NewVolume");

            return response;

        }
    }

    public class GetVolumeDBRequest {
        
        private int instanceID;

        private Channel channel;

        
        public GetVolumeDBRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetVolumeDBRequest channel(Channel channel) {
            this.channel = channel;
            return this;
        }

        public GetVolumeDBResponse execute() throws SonosException {
            Action action = service.getAction("GetVolumeDB");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Channel", this.channel);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetVolumeDBResponse response = new GetVolumeDBResponse();
            
            response.currentVolume = ServiceHelper._i2(invocation, "CurrentVolume");

            return response;

        }
    }

    public class SetVolumeDBRequest {
        
        private int instanceID;

        private Channel channel;

        private int desiredVolume;

        
        public SetVolumeDBRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SetVolumeDBRequest channel(Channel channel) {
            this.channel = channel;
            return this;
        }

        public SetVolumeDBRequest desiredVolume(int desiredVolume) {
            this.desiredVolume = desiredVolume;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetVolumeDB");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Channel", this.channel);

            invocation.setInput("DesiredVolume", this.desiredVolume);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetVolumeDBRangeRequest {
        
        private int instanceID;

        private Channel channel;

        
        public GetVolumeDBRangeRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetVolumeDBRangeRequest channel(Channel channel) {
            this.channel = channel;
            return this;
        }

        public GetVolumeDBRangeResponse execute() throws SonosException {
            Action action = service.getAction("GetVolumeDBRange");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Channel", this.channel);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetVolumeDBRangeResponse response = new GetVolumeDBRangeResponse();
            
            response.minValue = ServiceHelper._i2(invocation, "MinValue");

            response.maxValue = ServiceHelper._i2(invocation, "MaxValue");

            return response;

        }
    }

    public class GetBassRequest {
        
        private int instanceID;

        
        public GetBassRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetBassResponse execute() throws SonosException {
            Action action = service.getAction("GetBass");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetBassResponse response = new GetBassResponse();
            
            response.currentBass = ServiceHelper._i2(invocation, "CurrentBass");

            return response;

        }
    }

    public class SetBassRequest {
        
        private int instanceID;

        private int desiredBass;

        
        public SetBassRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SetBassRequest desiredBass(int desiredBass) {
            this.desiredBass = desiredBass;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetBass");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("DesiredBass", this.desiredBass);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetTrebleRequest {
        
        private int instanceID;

        
        public GetTrebleRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetTrebleResponse execute() throws SonosException {
            Action action = service.getAction("GetTreble");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetTrebleResponse response = new GetTrebleResponse();
            
            response.currentTreble = ServiceHelper._i2(invocation, "CurrentTreble");

            return response;

        }
    }

    public class SetTrebleRequest {
        
        private int instanceID;

        private int desiredTreble;

        
        public SetTrebleRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SetTrebleRequest desiredTreble(int desiredTreble) {
            this.desiredTreble = desiredTreble;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetTreble");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("DesiredTreble", this.desiredTreble);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetEQRequest {
        
        private int instanceID;

        private String eQType;

        
        public GetEQRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetEQRequest eQType(String eQType) {
            this.eQType = eQType;
            return this;
        }

        public GetEQResponse execute() throws SonosException {
            Action action = service.getAction("GetEQ");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("EQType", this.eQType);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetEQResponse response = new GetEQResponse();
            
            response.currentValue = ServiceHelper._i2(invocation, "CurrentValue");

            return response;

        }
    }

    public class SetEQRequest {
        
        private int instanceID;

        private String eQType;

        private int desiredValue;

        
        public SetEQRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SetEQRequest eQType(String eQType) {
            this.eQType = eQType;
            return this;
        }

        public SetEQRequest desiredValue(int desiredValue) {
            this.desiredValue = desiredValue;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetEQ");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("EQType", this.eQType);

            invocation.setInput("DesiredValue", this.desiredValue);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetLoudnessRequest {
        
        private int instanceID;

        private Channel channel;

        
        public GetLoudnessRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetLoudnessRequest channel(Channel channel) {
            this.channel = channel;
            return this;
        }

        public GetLoudnessResponse execute() throws SonosException {
            Action action = service.getAction("GetLoudness");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Channel", this.channel);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetLoudnessResponse response = new GetLoudnessResponse();
            
            response.currentLoudness = ServiceHelper._boolean(invocation, "CurrentLoudness");

            return response;

        }
    }

    public class SetLoudnessRequest {
        
        private int instanceID;

        private Channel channel;

        private boolean desiredLoudness;

        
        public SetLoudnessRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SetLoudnessRequest channel(Channel channel) {
            this.channel = channel;
            return this;
        }

        public SetLoudnessRequest desiredLoudness(boolean desiredLoudness) {
            this.desiredLoudness = desiredLoudness;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetLoudness");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Channel", this.channel);

            invocation.setInput("DesiredLoudness", this.desiredLoudness);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetSupportsOutputFixedRequest {
        
        private int instanceID;

        
        public GetSupportsOutputFixedRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetSupportsOutputFixedResponse execute() throws SonosException {
            Action action = service.getAction("GetSupportsOutputFixed");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetSupportsOutputFixedResponse response = new GetSupportsOutputFixedResponse();
            
            response.currentSupportsFixed = ServiceHelper._boolean(invocation, "CurrentSupportsFixed");

            return response;

        }
    }

    public class GetOutputFixedRequest {
        
        private int instanceID;

        
        public GetOutputFixedRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetOutputFixedResponse execute() throws SonosException {
            Action action = service.getAction("GetOutputFixed");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetOutputFixedResponse response = new GetOutputFixedResponse();
            
            response.currentFixed = ServiceHelper._boolean(invocation, "CurrentFixed");

            return response;

        }
    }

    public class SetOutputFixedRequest {
        
        private int instanceID;

        private boolean desiredFixed;

        
        public SetOutputFixedRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SetOutputFixedRequest desiredFixed(boolean desiredFixed) {
            this.desiredFixed = desiredFixed;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetOutputFixed");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("DesiredFixed", this.desiredFixed);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetHeadphoneConnectedRequest {
        
        private int instanceID;

        
        public GetHeadphoneConnectedRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetHeadphoneConnectedResponse execute() throws SonosException {
            Action action = service.getAction("GetHeadphoneConnected");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetHeadphoneConnectedResponse response = new GetHeadphoneConnectedResponse();
            
            response.currentHeadphoneConnected = ServiceHelper._boolean(invocation, "CurrentHeadphoneConnected");

            return response;

        }
    }

    public class RampToVolumeRequest {
        
        private int instanceID;

        private Channel channel;

        private RampType rampType;

        private int desiredVolume;

        private boolean resetVolumeAfter;

        private String programURI;

        
        public RampToVolumeRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public RampToVolumeRequest channel(Channel channel) {
            this.channel = channel;
            return this;
        }

        public RampToVolumeRequest rampType(RampType rampType) {
            this.rampType = rampType;
            return this;
        }

        public RampToVolumeRequest desiredVolume(int desiredVolume) {
            this.desiredVolume = desiredVolume;
            return this;
        }

        public RampToVolumeRequest resetVolumeAfter(boolean resetVolumeAfter) {
            this.resetVolumeAfter = resetVolumeAfter;
            return this;
        }

        public RampToVolumeRequest programURI(String programURI) {
            this.programURI = programURI;
            return this;
        }

        public RampToVolumeResponse execute() throws SonosException {
            Action action = service.getAction("RampToVolume");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Channel", this.channel);

            invocation.setInput("RampType", this.rampType);

            invocation.setInput("DesiredVolume", new UnsignedIntegerTwoBytes(this.desiredVolume));

            invocation.setInput("ResetVolumeAfter", this.resetVolumeAfter);

            invocation.setInput("ProgramURI", this.programURI);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            RampToVolumeResponse response = new RampToVolumeResponse();
            
            response.rampTime = ServiceHelper._ui4(invocation, "RampTime");

            return response;

        }
    }

    public class RestoreVolumePriorToRampRequest {
        
        private int instanceID;

        private Channel channel;

        
        public RestoreVolumePriorToRampRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public RestoreVolumePriorToRampRequest channel(Channel channel) {
            this.channel = channel;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("RestoreVolumePriorToRamp");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Channel", this.channel);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class SetChannelMapRequest {
        
        private int instanceID;

        private String channelMap;

        
        public SetChannelMapRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SetChannelMapRequest channelMap(String channelMap) {
            this.channelMap = channelMap;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetChannelMap");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("ChannelMap", this.channelMap);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    
    public class GetMuteResponse {
        
        private boolean currentMute;

        
        public boolean currentMute() {
            return currentMute;
        }

    }

    public class ResetBasicEQResponse {
        
        private int bass;

        private int treble;

        private boolean loudness;

        private int leftVolume;

        private int rightVolume;

        
        public int bass() {
            return bass;
        }

        public int treble() {
            return treble;
        }

        public boolean loudness() {
            return loudness;
        }

        public int leftVolume() {
            return leftVolume;
        }

        public int rightVolume() {
            return rightVolume;
        }

    }

    public class GetVolumeResponse {
        
        private int currentVolume;

        
        public int currentVolume() {
            return currentVolume;
        }

    }

    public class SetRelativeVolumeResponse {
        
        private int newVolume;

        
        public int newVolume() {
            return newVolume;
        }

    }

    public class GetVolumeDBResponse {
        
        private int currentVolume;

        
        public int currentVolume() {
            return currentVolume;
        }

    }

    public class GetVolumeDBRangeResponse {
        
        private int minValue;

        private int maxValue;

        
        public int minValue() {
            return minValue;
        }

        public int maxValue() {
            return maxValue;
        }

    }

    public class GetBassResponse {
        
        private int currentBass;

        
        public int currentBass() {
            return currentBass;
        }

    }

    public class GetTrebleResponse {
        
        private int currentTreble;

        
        public int currentTreble() {
            return currentTreble;
        }

    }

    public class GetEQResponse {
        
        private int currentValue;

        
        public int currentValue() {
            return currentValue;
        }

    }

    public class GetLoudnessResponse {
        
        private boolean currentLoudness;

        
        public boolean currentLoudness() {
            return currentLoudness;
        }

    }

    public class GetSupportsOutputFixedResponse {
        
        private boolean currentSupportsFixed;

        
        public boolean currentSupportsFixed() {
            return currentSupportsFixed;
        }

    }

    public class GetOutputFixedResponse {
        
        private boolean currentFixed;

        
        public boolean currentFixed() {
            return currentFixed;
        }

    }

    public class GetHeadphoneConnectedResponse {
        
        private boolean currentHeadphoneConnected;

        
        public boolean currentHeadphoneConnected() {
            return currentHeadphoneConnected;
        }

    }

    public class RampToVolumeResponse {
        
        private int rampTime;

        
        public int rampTime() {
            return rampTime;
        }

    }

}
