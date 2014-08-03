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


public class ConnectionManager {
    private Service service;
    private UpnpService upnpService;

    public ConnectionManager(UpnpService upnpService, RemoteDevice device) {
        this.upnpService = upnpService;
        this.service = RemoteDeviceHelper.findService(device, "urn:upnp-org:serviceId:ConnectionManager");
    }
    
    public enum ConnectionStatus {OK, ContentFormatMismatch, InsufficientBandwidth, UnreliableChannel, Unknown}

    public enum Direction {Input, Output}

    
    public GetProtocolInfoRequest getProtocolInfo() {
        return new GetProtocolInfoRequest();
    }

    public GetCurrentConnectionIDsRequest getCurrentConnectionIDs() {
        return new GetCurrentConnectionIDsRequest();
    }

    public GetCurrentConnectionInfoRequest getCurrentConnectionInfo() {
        return new GetCurrentConnectionInfoRequest();
    }

    
    public class GetProtocolInfoRequest {
        
        
        public GetProtocolInfoResponse execute() {
            Action action = service.getAction("GetProtocolInfo");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetProtocolInfoResponse response = new GetProtocolInfoResponse();
            
            response.source = ServiceHelper._string(invocation, "Source");

            response.sink = ServiceHelper._string(invocation, "Sink");

            return response;

        }
    }

    public class GetCurrentConnectionIDsRequest {
        
        
        public GetCurrentConnectionIDsResponse execute() {
            Action action = service.getAction("GetCurrentConnectionIDs");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetCurrentConnectionIDsResponse response = new GetCurrentConnectionIDsResponse();
            
            response.connectionIDs = ServiceHelper._string(invocation, "ConnectionIDs");

            return response;

        }
    }

    public class GetCurrentConnectionInfoRequest {
        
        private int connectionID;

        
        public GetCurrentConnectionInfoRequest connectionID(int connectionID) {
            this.connectionID = connectionID;
            return this;
        }

        public GetCurrentConnectionInfoResponse execute() {
            Action action = service.getAction("GetCurrentConnectionInfo");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("ConnectionID", this.connectionID);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetCurrentConnectionInfoResponse response = new GetCurrentConnectionInfoResponse();
            
            response.rcsID = ServiceHelper._i4(invocation, "RcsID");

            response.aVTransportID = ServiceHelper._i4(invocation, "AVTransportID");

            response.protocolInfo = ServiceHelper._string(invocation, "ProtocolInfo");

            response.peerConnectionManager = ServiceHelper._string(invocation, "PeerConnectionManager");

            response.peerConnectionID = ServiceHelper._i4(invocation, "PeerConnectionID");

            response.direction = ServiceHelper._string(invocation, "Direction", Direction.class);

            response.status = ServiceHelper._string(invocation, "Status", ConnectionStatus.class);

            return response;

        }
    }

    
    public class GetProtocolInfoResponse {
        
        private String source;

        private String sink;

        
        public String source() {
            return source;
        }

        public String sink() {
            return sink;
        }

    }

    public class GetCurrentConnectionIDsResponse {
        
        private String connectionIDs;

        
        public String connectionIDs() {
            return connectionIDs;
        }

    }

    public class GetCurrentConnectionInfoResponse {
        
        private int rcsID;

        private int aVTransportID;

        private String protocolInfo;

        private String peerConnectionManager;

        private int peerConnectionID;

        private Direction direction;

        private ConnectionStatus status;

        
        public int rcsID() {
            return rcsID;
        }

        public int aVTransportID() {
            return aVTransportID;
        }

        public String protocolInfo() {
            return protocolInfo;
        }

        public String peerConnectionManager() {
            return peerConnectionManager;
        }

        public int peerConnectionID() {
            return peerConnectionID;
        }

        public Direction direction() {
            return direction;
        }

        public ConnectionStatus status() {
            return status;
        }

    }

}
