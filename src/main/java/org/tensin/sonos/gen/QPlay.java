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


public class QPlay {
    private Service service;
    private UpnpService upnpService;

    public QPlay(UpnpService upnpService, RemoteDevice device) {
        this.upnpService = upnpService;
        this.service = RemoteDeviceHelper.findService(device, "urn:tencent-com:serviceId:QPlay");
    }
    
    
    public QPlayAuthRequest qPlayAuth() {
        return new QPlayAuthRequest();
    }

    
    public class QPlayAuthRequest {
        
        private String seed;

        
        public QPlayAuthRequest seed(String seed) {
            this.seed = seed;
            return this;
        }

        public QPlayAuthResponse execute() {
            Action action = service.getAction("QPlayAuth");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("Seed", this.seed);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            QPlayAuthResponse response = new QPlayAuthResponse();
            
            response.code = ServiceHelper._string(invocation, "Code");

            response.mID = ServiceHelper._string(invocation, "MID");

            response.dID = ServiceHelper._string(invocation, "DID");

            return response;

        }
    }

    
    public class QPlayAuthResponse {
        
        private String code;

        private String mID;

        private String dID;

        
        public String code() {
            return code;
        }

        public String mID() {
            return mID;
        }

        public String dID() {
            return dID;
        }

    }

}
