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


public class GroupManagement {
    private Service service;
    private UpnpService upnpService;

    public GroupManagement(UpnpService upnpService, RemoteDevice device) {
        this.upnpService = upnpService;
        this.service = RemoteDeviceHelper.findService(device, "urn:upnp-org:serviceId:GroupManagement");
    }
    
    
    public AddMemberRequest addMember() {
        return new AddMemberRequest();
    }

    public RemoveMemberRequest removeMember() {
        return new RemoveMemberRequest();
    }

    public ReportTrackBufferingResultRequest reportTrackBufferingResult() {
        return new ReportTrackBufferingResultRequest();
    }

    
    public class AddMemberRequest {
        
        private String memberID;

        
        public AddMemberRequest memberID(String memberID) {
            this.memberID = memberID;
            return this;
        }

        public AddMemberResponse execute() throws SonosException {
            Action action = service.getAction("AddMember");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("MemberID", this.memberID);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            AddMemberResponse response = new AddMemberResponse();
            
            response.currentTransportSettings = ServiceHelper._string(invocation, "CurrentTransportSettings");

            response.groupUUIDJoined = ServiceHelper._string(invocation, "GroupUUIDJoined");

            response.resetVolumeAfter = ServiceHelper._boolean(invocation, "ResetVolumeAfter");

            response.volumeAVTransportURI = ServiceHelper._string(invocation, "VolumeAVTransportURI");

            return response;

        }
    }

    public class RemoveMemberRequest {
        
        private String memberID;

        
        public RemoveMemberRequest memberID(String memberID) {
            this.memberID = memberID;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("RemoveMember");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("MemberID", this.memberID);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class ReportTrackBufferingResultRequest {
        
        private String memberID;

        private int resultCode;

        
        public ReportTrackBufferingResultRequest memberID(String memberID) {
            this.memberID = memberID;
            return this;
        }

        public ReportTrackBufferingResultRequest resultCode(int resultCode) {
            this.resultCode = resultCode;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("ReportTrackBufferingResult");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("MemberID", this.memberID);

            invocation.setInput("ResultCode", this.resultCode);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    
    public class AddMemberResponse {
        
        private String currentTransportSettings;

        private String groupUUIDJoined;

        private boolean resetVolumeAfter;

        private String volumeAVTransportURI;

        
        public String currentTransportSettings() {
            return currentTransportSettings;
        }

        public String groupUUIDJoined() {
            return groupUUIDJoined;
        }

        public boolean resetVolumeAfter() {
            return resetVolumeAfter;
        }

        public String volumeAVTransportURI() {
            return volumeAVTransportURI;
        }

    }

}
