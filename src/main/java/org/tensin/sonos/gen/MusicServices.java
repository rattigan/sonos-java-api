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


public class MusicServices {
    private Service service;
    private UpnpService upnpService;

    public MusicServices(UpnpService upnpService, RemoteDevice device) {
        this.upnpService = upnpService;
        this.service = RemoteDeviceHelper.findService(device, "urn:upnp-org:serviceId:MusicServices");
    }
    
    
    public GetSessionIdRequest getSessionId() {
        return new GetSessionIdRequest();
    }

    public ListAvailableServicesRequest listAvailableServices() {
        return new ListAvailableServicesRequest();
    }

    public UpdateAvailableServicesRequest updateAvailableServices() {
        return new UpdateAvailableServicesRequest();
    }

    
    public class GetSessionIdRequest {
        
        private int serviceId;

        private String username;

        
        public GetSessionIdRequest serviceId(int serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        public GetSessionIdRequest username(String username) {
            this.username = username;
            return this;
        }

        public GetSessionIdResponse execute() throws SonosException {
            Action action = service.getAction("GetSessionId");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("ServiceId", this.serviceId);

            invocation.setInput("Username", this.username);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetSessionIdResponse response = new GetSessionIdResponse();
            
            response.sessionId = ServiceHelper._string(invocation, "SessionId");

            return response;

        }
    }

    public class ListAvailableServicesRequest {
        
        
        public ListAvailableServicesResponse execute() throws SonosException {
            Action action = service.getAction("ListAvailableServices");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            ListAvailableServicesResponse response = new ListAvailableServicesResponse();
            
            response.availableServiceDescriptorList = ServiceHelper._string(invocation, "AvailableServiceDescriptorList");

            response.availableServiceTypeList = ServiceHelper._string(invocation, "AvailableServiceTypeList");

            response.availableServiceListVersion = ServiceHelper._string(invocation, "AvailableServiceListVersion");

            return response;

        }
    }

    public class UpdateAvailableServicesRequest {
        
        
        public void execute() throws SonosException {
            Action action = service.getAction("UpdateAvailableServices");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    
    public class GetSessionIdResponse {
        
        private String sessionId;

        
        public String sessionId() {
            return sessionId;
        }

    }

    public class ListAvailableServicesResponse {
        
        private String availableServiceDescriptorList;

        private String availableServiceTypeList;

        private String availableServiceListVersion;

        
        public String availableServiceDescriptorList() {
            return availableServiceDescriptorList;
        }

        public String availableServiceTypeList() {
            return availableServiceTypeList;
        }

        public String availableServiceListVersion() {
            return availableServiceListVersion;
        }

    }

}
