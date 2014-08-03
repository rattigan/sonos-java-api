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


public class Queue {
    private Service service;
    private UpnpService upnpService;

    public Queue(UpnpService upnpService, RemoteDevice device) {
        this.upnpService = upnpService;
        this.service = RemoteDeviceHelper.findService(device, "urn:sonos-com:serviceId:Queue");
    }
    
    
    public AddURIRequest addURI() {
        return new AddURIRequest();
    }

    public AddMultipleURIsRequest addMultipleURIs() {
        return new AddMultipleURIsRequest();
    }

    public AttachQueueRequest attachQueue() {
        return new AttachQueueRequest();
    }

    public BackupRequest backup() {
        return new BackupRequest();
    }

    public BrowseRequest browse() {
        return new BrowseRequest();
    }

    public CreateQueueRequest createQueue() {
        return new CreateQueueRequest();
    }

    public RemoveAllTracksRequest removeAllTracks() {
        return new RemoveAllTracksRequest();
    }

    public RemoveTrackRangeRequest removeTrackRange() {
        return new RemoveTrackRangeRequest();
    }

    public ReorderTracksRequest reorderTracks() {
        return new ReorderTracksRequest();
    }

    public ReplaceAllTracksRequest replaceAllTracks() {
        return new ReplaceAllTracksRequest();
    }

    public SaveAsSonosPlaylistRequest saveAsSonosPlaylist() {
        return new SaveAsSonosPlaylistRequest();
    }

    
    public class AddURIRequest {
        
        private int queueID;

        private int updateID;

        private String enqueuedURI;

        private String enqueuedURIMetaData;

        private int desiredFirstTrackNumberEnqueued;

        private boolean enqueueAsNext;

        
        public AddURIRequest queueID(int queueID) {
            this.queueID = queueID;
            return this;
        }

        public AddURIRequest updateID(int updateID) {
            this.updateID = updateID;
            return this;
        }

        public AddURIRequest enqueuedURI(String enqueuedURI) {
            this.enqueuedURI = enqueuedURI;
            return this;
        }

        public AddURIRequest enqueuedURIMetaData(String enqueuedURIMetaData) {
            this.enqueuedURIMetaData = enqueuedURIMetaData;
            return this;
        }

        public AddURIRequest desiredFirstTrackNumberEnqueued(int desiredFirstTrackNumberEnqueued) {
            this.desiredFirstTrackNumberEnqueued = desiredFirstTrackNumberEnqueued;
            return this;
        }

        public AddURIRequest enqueueAsNext(boolean enqueueAsNext) {
            this.enqueueAsNext = enqueueAsNext;
            return this;
        }

        public AddURIResponse execute() {
            Action action = service.getAction("AddURI");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("QueueID", new UnsignedIntegerFourBytes(this.queueID));

            invocation.setInput("UpdateID", new UnsignedIntegerFourBytes(this.updateID));

            invocation.setInput("EnqueuedURI", this.enqueuedURI);

            invocation.setInput("EnqueuedURIMetaData", this.enqueuedURIMetaData);

            invocation.setInput("DesiredFirstTrackNumberEnqueued", new UnsignedIntegerFourBytes(this.desiredFirstTrackNumberEnqueued));

            invocation.setInput("EnqueueAsNext", this.enqueueAsNext);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            AddURIResponse response = new AddURIResponse();
            
            response.firstTrackNumberEnqueued = ServiceHelper._ui4(invocation, "FirstTrackNumberEnqueued");

            response.numTracksAdded = ServiceHelper._ui4(invocation, "NumTracksAdded");

            response.newQueueLength = ServiceHelper._ui4(invocation, "NewQueueLength");

            response.newUpdateID = ServiceHelper._ui4(invocation, "NewUpdateID");

            return response;

        }
    }

    public class AddMultipleURIsRequest {
        
        private int queueID;

        private int updateID;

        private String containerURI;

        private String containerMetaData;

        private int desiredFirstTrackNumberEnqueued;

        private boolean enqueueAsNext;

        private int numberOfURIs;

        private String enqueuedURIsAndMetaData;

        
        public AddMultipleURIsRequest queueID(int queueID) {
            this.queueID = queueID;
            return this;
        }

        public AddMultipleURIsRequest updateID(int updateID) {
            this.updateID = updateID;
            return this;
        }

        public AddMultipleURIsRequest containerURI(String containerURI) {
            this.containerURI = containerURI;
            return this;
        }

        public AddMultipleURIsRequest containerMetaData(String containerMetaData) {
            this.containerMetaData = containerMetaData;
            return this;
        }

        public AddMultipleURIsRequest desiredFirstTrackNumberEnqueued(int desiredFirstTrackNumberEnqueued) {
            this.desiredFirstTrackNumberEnqueued = desiredFirstTrackNumberEnqueued;
            return this;
        }

        public AddMultipleURIsRequest enqueueAsNext(boolean enqueueAsNext) {
            this.enqueueAsNext = enqueueAsNext;
            return this;
        }

        public AddMultipleURIsRequest numberOfURIs(int numberOfURIs) {
            this.numberOfURIs = numberOfURIs;
            return this;
        }

        public AddMultipleURIsRequest enqueuedURIsAndMetaData(String enqueuedURIsAndMetaData) {
            this.enqueuedURIsAndMetaData = enqueuedURIsAndMetaData;
            return this;
        }

        public AddMultipleURIsResponse execute() {
            Action action = service.getAction("AddMultipleURIs");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("QueueID", new UnsignedIntegerFourBytes(this.queueID));

            invocation.setInput("UpdateID", new UnsignedIntegerFourBytes(this.updateID));

            invocation.setInput("ContainerURI", this.containerURI);

            invocation.setInput("ContainerMetaData", this.containerMetaData);

            invocation.setInput("DesiredFirstTrackNumberEnqueued", new UnsignedIntegerFourBytes(this.desiredFirstTrackNumberEnqueued));

            invocation.setInput("EnqueueAsNext", this.enqueueAsNext);

            invocation.setInput("NumberOfURIs", new UnsignedIntegerFourBytes(this.numberOfURIs));

            invocation.setInput("EnqueuedURIsAndMetaData", this.enqueuedURIsAndMetaData);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            AddMultipleURIsResponse response = new AddMultipleURIsResponse();
            
            response.firstTrackNumberEnqueued = ServiceHelper._ui4(invocation, "FirstTrackNumberEnqueued");

            response.numTracksAdded = ServiceHelper._ui4(invocation, "NumTracksAdded");

            response.newQueueLength = ServiceHelper._ui4(invocation, "NewQueueLength");

            response.newUpdateID = ServiceHelper._ui4(invocation, "NewUpdateID");

            return response;

        }
    }

    public class AttachQueueRequest {
        
        private String queueOwnerID;

        
        public AttachQueueRequest queueOwnerID(String queueOwnerID) {
            this.queueOwnerID = queueOwnerID;
            return this;
        }

        public AttachQueueResponse execute() {
            Action action = service.getAction("AttachQueue");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("QueueOwnerID", this.queueOwnerID);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            AttachQueueResponse response = new AttachQueueResponse();
            
            response.queueID = ServiceHelper._ui4(invocation, "QueueID");

            response.queueOwnerContext = ServiceHelper._string(invocation, "QueueOwnerContext");

            return response;

        }
    }

    public class BackupRequest {
        
        
        public void execute() {
            Action action = service.getAction("Backup");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class BrowseRequest {
        
        private int queueID;

        private int startingIndex;

        private int requestedCount;

        
        public BrowseRequest queueID(int queueID) {
            this.queueID = queueID;
            return this;
        }

        public BrowseRequest startingIndex(int startingIndex) {
            this.startingIndex = startingIndex;
            return this;
        }

        public BrowseRequest requestedCount(int requestedCount) {
            this.requestedCount = requestedCount;
            return this;
        }

        public BrowseResponse execute() {
            Action action = service.getAction("Browse");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("QueueID", new UnsignedIntegerFourBytes(this.queueID));

            invocation.setInput("StartingIndex", new UnsignedIntegerFourBytes(this.startingIndex));

            invocation.setInput("RequestedCount", new UnsignedIntegerFourBytes(this.requestedCount));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            BrowseResponse response = new BrowseResponse();
            
            response.result = ServiceHelper._string(invocation, "Result");

            response.numberReturned = ServiceHelper._ui4(invocation, "NumberReturned");

            response.totalMatches = ServiceHelper._ui4(invocation, "TotalMatches");

            response.updateID = ServiceHelper._ui4(invocation, "UpdateID");

            return response;

        }
    }

    public class CreateQueueRequest {
        
        private String queueOwnerID;

        private String queueOwnerContext;

        private String queuePolicy;

        
        public CreateQueueRequest queueOwnerID(String queueOwnerID) {
            this.queueOwnerID = queueOwnerID;
            return this;
        }

        public CreateQueueRequest queueOwnerContext(String queueOwnerContext) {
            this.queueOwnerContext = queueOwnerContext;
            return this;
        }

        public CreateQueueRequest queuePolicy(String queuePolicy) {
            this.queuePolicy = queuePolicy;
            return this;
        }

        public CreateQueueResponse execute() {
            Action action = service.getAction("CreateQueue");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("QueueOwnerID", this.queueOwnerID);

            invocation.setInput("QueueOwnerContext", this.queueOwnerContext);

            invocation.setInput("QueuePolicy", this.queuePolicy);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            CreateQueueResponse response = new CreateQueueResponse();
            
            response.queueID = ServiceHelper._ui4(invocation, "QueueID");

            return response;

        }
    }

    public class RemoveAllTracksRequest {
        
        private int queueID;

        private int updateID;

        
        public RemoveAllTracksRequest queueID(int queueID) {
            this.queueID = queueID;
            return this;
        }

        public RemoveAllTracksRequest updateID(int updateID) {
            this.updateID = updateID;
            return this;
        }

        public RemoveAllTracksResponse execute() {
            Action action = service.getAction("RemoveAllTracks");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("QueueID", new UnsignedIntegerFourBytes(this.queueID));

            invocation.setInput("UpdateID", new UnsignedIntegerFourBytes(this.updateID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            RemoveAllTracksResponse response = new RemoveAllTracksResponse();
            
            response.newUpdateID = ServiceHelper._ui4(invocation, "NewUpdateID");

            return response;

        }
    }

    public class RemoveTrackRangeRequest {
        
        private int queueID;

        private int updateID;

        private int startingIndex;

        private int numberOfTracks;

        
        public RemoveTrackRangeRequest queueID(int queueID) {
            this.queueID = queueID;
            return this;
        }

        public RemoveTrackRangeRequest updateID(int updateID) {
            this.updateID = updateID;
            return this;
        }

        public RemoveTrackRangeRequest startingIndex(int startingIndex) {
            this.startingIndex = startingIndex;
            return this;
        }

        public RemoveTrackRangeRequest numberOfTracks(int numberOfTracks) {
            this.numberOfTracks = numberOfTracks;
            return this;
        }

        public RemoveTrackRangeResponse execute() {
            Action action = service.getAction("RemoveTrackRange");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("QueueID", new UnsignedIntegerFourBytes(this.queueID));

            invocation.setInput("UpdateID", new UnsignedIntegerFourBytes(this.updateID));

            invocation.setInput("StartingIndex", new UnsignedIntegerFourBytes(this.startingIndex));

            invocation.setInput("NumberOfTracks", new UnsignedIntegerFourBytes(this.numberOfTracks));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            RemoveTrackRangeResponse response = new RemoveTrackRangeResponse();
            
            response.newUpdateID = ServiceHelper._ui4(invocation, "NewUpdateID");

            return response;

        }
    }

    public class ReorderTracksRequest {
        
        private int queueID;

        private int startingIndex;

        private int numberOfTracks;

        private int insertBefore;

        private int updateID;

        
        public ReorderTracksRequest queueID(int queueID) {
            this.queueID = queueID;
            return this;
        }

        public ReorderTracksRequest startingIndex(int startingIndex) {
            this.startingIndex = startingIndex;
            return this;
        }

        public ReorderTracksRequest numberOfTracks(int numberOfTracks) {
            this.numberOfTracks = numberOfTracks;
            return this;
        }

        public ReorderTracksRequest insertBefore(int insertBefore) {
            this.insertBefore = insertBefore;
            return this;
        }

        public ReorderTracksRequest updateID(int updateID) {
            this.updateID = updateID;
            return this;
        }

        public ReorderTracksResponse execute() {
            Action action = service.getAction("ReorderTracks");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("QueueID", new UnsignedIntegerFourBytes(this.queueID));

            invocation.setInput("StartingIndex", new UnsignedIntegerFourBytes(this.startingIndex));

            invocation.setInput("NumberOfTracks", new UnsignedIntegerFourBytes(this.numberOfTracks));

            invocation.setInput("InsertBefore", new UnsignedIntegerFourBytes(this.insertBefore));

            invocation.setInput("UpdateID", new UnsignedIntegerFourBytes(this.updateID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            ReorderTracksResponse response = new ReorderTracksResponse();
            
            response.newUpdateID = ServiceHelper._ui4(invocation, "NewUpdateID");

            return response;

        }
    }

    public class ReplaceAllTracksRequest {
        
        private int queueID;

        private int updateID;

        private String containerURI;

        private String containerMetaData;

        private int currentTrackIndex;

        private String newCurrentTrackIndices;

        private int numberOfURIs;

        private String enqueuedURIsAndMetaData;

        
        public ReplaceAllTracksRequest queueID(int queueID) {
            this.queueID = queueID;
            return this;
        }

        public ReplaceAllTracksRequest updateID(int updateID) {
            this.updateID = updateID;
            return this;
        }

        public ReplaceAllTracksRequest containerURI(String containerURI) {
            this.containerURI = containerURI;
            return this;
        }

        public ReplaceAllTracksRequest containerMetaData(String containerMetaData) {
            this.containerMetaData = containerMetaData;
            return this;
        }

        public ReplaceAllTracksRequest currentTrackIndex(int currentTrackIndex) {
            this.currentTrackIndex = currentTrackIndex;
            return this;
        }

        public ReplaceAllTracksRequest newCurrentTrackIndices(String newCurrentTrackIndices) {
            this.newCurrentTrackIndices = newCurrentTrackIndices;
            return this;
        }

        public ReplaceAllTracksRequest numberOfURIs(int numberOfURIs) {
            this.numberOfURIs = numberOfURIs;
            return this;
        }

        public ReplaceAllTracksRequest enqueuedURIsAndMetaData(String enqueuedURIsAndMetaData) {
            this.enqueuedURIsAndMetaData = enqueuedURIsAndMetaData;
            return this;
        }

        public ReplaceAllTracksResponse execute() {
            Action action = service.getAction("ReplaceAllTracks");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("QueueID", new UnsignedIntegerFourBytes(this.queueID));

            invocation.setInput("UpdateID", new UnsignedIntegerFourBytes(this.updateID));

            invocation.setInput("ContainerURI", this.containerURI);

            invocation.setInput("ContainerMetaData", this.containerMetaData);

            invocation.setInput("CurrentTrackIndex", new UnsignedIntegerFourBytes(this.currentTrackIndex));

            invocation.setInput("NewCurrentTrackIndices", this.newCurrentTrackIndices);

            invocation.setInput("NumberOfURIs", new UnsignedIntegerFourBytes(this.numberOfURIs));

            invocation.setInput("EnqueuedURIsAndMetaData", this.enqueuedURIsAndMetaData);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            ReplaceAllTracksResponse response = new ReplaceAllTracksResponse();
            
            response.newQueueLength = ServiceHelper._ui4(invocation, "NewQueueLength");

            response.newUpdateID = ServiceHelper._ui4(invocation, "NewUpdateID");

            return response;

        }
    }

    public class SaveAsSonosPlaylistRequest {
        
        private int queueID;

        private String title;

        private String objectID;

        
        public SaveAsSonosPlaylistRequest queueID(int queueID) {
            this.queueID = queueID;
            return this;
        }

        public SaveAsSonosPlaylistRequest title(String title) {
            this.title = title;
            return this;
        }

        public SaveAsSonosPlaylistRequest objectID(String objectID) {
            this.objectID = objectID;
            return this;
        }

        public SaveAsSonosPlaylistResponse execute() {
            Action action = service.getAction("SaveAsSonosPlaylist");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("QueueID", new UnsignedIntegerFourBytes(this.queueID));

            invocation.setInput("Title", this.title);

            invocation.setInput("ObjectID", this.objectID);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            SaveAsSonosPlaylistResponse response = new SaveAsSonosPlaylistResponse();
            
            response.assignedObjectID = ServiceHelper._string(invocation, "AssignedObjectID");

            return response;

        }
    }

    
    public class AddURIResponse {
        
        private int firstTrackNumberEnqueued;

        private int numTracksAdded;

        private int newQueueLength;

        private int newUpdateID;

        
        public int firstTrackNumberEnqueued() {
            return firstTrackNumberEnqueued;
        }

        public int numTracksAdded() {
            return numTracksAdded;
        }

        public int newQueueLength() {
            return newQueueLength;
        }

        public int newUpdateID() {
            return newUpdateID;
        }

    }

    public class AddMultipleURIsResponse {
        
        private int firstTrackNumberEnqueued;

        private int numTracksAdded;

        private int newQueueLength;

        private int newUpdateID;

        
        public int firstTrackNumberEnqueued() {
            return firstTrackNumberEnqueued;
        }

        public int numTracksAdded() {
            return numTracksAdded;
        }

        public int newQueueLength() {
            return newQueueLength;
        }

        public int newUpdateID() {
            return newUpdateID;
        }

    }

    public class AttachQueueResponse {
        
        private int queueID;

        private String queueOwnerContext;

        
        public int queueID() {
            return queueID;
        }

        public String queueOwnerContext() {
            return queueOwnerContext;
        }

    }

    public class BrowseResponse {
        
        private String result;

        private int numberReturned;

        private int totalMatches;

        private int updateID;

        
        public String result() {
            return result;
        }

        public int numberReturned() {
            return numberReturned;
        }

        public int totalMatches() {
            return totalMatches;
        }

        public int updateID() {
            return updateID;
        }

    }

    public class CreateQueueResponse {
        
        private int queueID;

        
        public int queueID() {
            return queueID;
        }

    }

    public class RemoveAllTracksResponse {
        
        private int newUpdateID;

        
        public int newUpdateID() {
            return newUpdateID;
        }

    }

    public class RemoveTrackRangeResponse {
        
        private int newUpdateID;

        
        public int newUpdateID() {
            return newUpdateID;
        }

    }

    public class ReorderTracksResponse {
        
        private int newUpdateID;

        
        public int newUpdateID() {
            return newUpdateID;
        }

    }

    public class ReplaceAllTracksResponse {
        
        private int newQueueLength;

        private int newUpdateID;

        
        public int newQueueLength() {
            return newQueueLength;
        }

        public int newUpdateID() {
            return newUpdateID;
        }

    }

    public class SaveAsSonosPlaylistResponse {
        
        private String assignedObjectID;

        
        public String assignedObjectID() {
            return assignedObjectID;
        }

    }

}
