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


public class AVTransport {
    private Service service;
    private UpnpService upnpService;

    public AVTransport(UpnpService upnpService, RemoteDevice device) {
        this.upnpService = upnpService;
        this.service = RemoteDeviceHelper.findService(device, "urn:upnp-org:serviceId:AVTransport");
    }
    
    public enum TransportState {STOPPED, PLAYING, PAUSED_PLAYBACK, TRANSITIONING}

    public enum PlaybackStorageMedium {NONE, NETWORK}

    public enum RecordStorageMedium {NONE}

    public enum CurrentPlayMode {NORMAL, REPEAT_ALL, SHUFFLE_NOREPEAT, SHUFFLE}

    public enum TransportPlaySpeed {_1}

    public enum SeekMode {TRACK_NR, REL_TIME, SECTION}

    
    public SetAVTransportURIRequest setAVTransportURI() {
        return new SetAVTransportURIRequest();
    }

    public SetNextAVTransportURIRequest setNextAVTransportURI() {
        return new SetNextAVTransportURIRequest();
    }

    public AddURIToQueueRequest addURIToQueue() {
        return new AddURIToQueueRequest();
    }

    public AddMultipleURIsToQueueRequest addMultipleURIsToQueue() {
        return new AddMultipleURIsToQueueRequest();
    }

    public ReorderTracksInQueueRequest reorderTracksInQueue() {
        return new ReorderTracksInQueueRequest();
    }

    public RemoveTrackFromQueueRequest removeTrackFromQueue() {
        return new RemoveTrackFromQueueRequest();
    }

    public RemoveTrackRangeFromQueueRequest removeTrackRangeFromQueue() {
        return new RemoveTrackRangeFromQueueRequest();
    }

    public RemoveAllTracksFromQueueRequest removeAllTracksFromQueue() {
        return new RemoveAllTracksFromQueueRequest();
    }

    public SaveQueueRequest saveQueue() {
        return new SaveQueueRequest();
    }

    public BackupQueueRequest backupQueue() {
        return new BackupQueueRequest();
    }

    public CreateSavedQueueRequest createSavedQueue() {
        return new CreateSavedQueueRequest();
    }

    public AddURIToSavedQueueRequest addURIToSavedQueue() {
        return new AddURIToSavedQueueRequest();
    }

    public ReorderTracksInSavedQueueRequest reorderTracksInSavedQueue() {
        return new ReorderTracksInSavedQueueRequest();
    }

    public GetMediaInfoRequest getMediaInfo() {
        return new GetMediaInfoRequest();
    }

    public GetTransportInfoRequest getTransportInfo() {
        return new GetTransportInfoRequest();
    }

    public GetPositionInfoRequest getPositionInfo() {
        return new GetPositionInfoRequest();
    }

    public GetDeviceCapabilitiesRequest getDeviceCapabilities() {
        return new GetDeviceCapabilitiesRequest();
    }

    public GetTransportSettingsRequest getTransportSettings() {
        return new GetTransportSettingsRequest();
    }

    public GetCrossfadeModeRequest getCrossfadeMode() {
        return new GetCrossfadeModeRequest();
    }

    public StopRequest stop() {
        return new StopRequest();
    }

    public PlayRequest play() {
        return new PlayRequest();
    }

    public PauseRequest pause() {
        return new PauseRequest();
    }

    public SeekRequest seek() {
        return new SeekRequest();
    }

    public NextRequest next() {
        return new NextRequest();
    }

    public NextProgrammedRadioTracksRequest nextProgrammedRadioTracks() {
        return new NextProgrammedRadioTracksRequest();
    }

    public PreviousRequest previous() {
        return new PreviousRequest();
    }

    public NextSectionRequest nextSection() {
        return new NextSectionRequest();
    }

    public PreviousSectionRequest previousSection() {
        return new PreviousSectionRequest();
    }

    public SetPlayModeRequest setPlayMode() {
        return new SetPlayModeRequest();
    }

    public SetCrossfadeModeRequest setCrossfadeMode() {
        return new SetCrossfadeModeRequest();
    }

    public NotifyDeletedURIRequest notifyDeletedURI() {
        return new NotifyDeletedURIRequest();
    }

    public GetCurrentTransportActionsRequest getCurrentTransportActions() {
        return new GetCurrentTransportActionsRequest();
    }

    public BecomeCoordinatorOfStandaloneGroupRequest becomeCoordinatorOfStandaloneGroup() {
        return new BecomeCoordinatorOfStandaloneGroupRequest();
    }

    public DelegateGroupCoordinationToRequest delegateGroupCoordinationTo() {
        return new DelegateGroupCoordinationToRequest();
    }

    public BecomeGroupCoordinatorRequest becomeGroupCoordinator() {
        return new BecomeGroupCoordinatorRequest();
    }

    public BecomeGroupCoordinatorAndSourceRequest becomeGroupCoordinatorAndSource() {
        return new BecomeGroupCoordinatorAndSourceRequest();
    }

    public ChangeCoordinatorRequest changeCoordinator() {
        return new ChangeCoordinatorRequest();
    }

    public ChangeTransportSettingsRequest changeTransportSettings() {
        return new ChangeTransportSettingsRequest();
    }

    public ConfigureSleepTimerRequest configureSleepTimer() {
        return new ConfigureSleepTimerRequest();
    }

    public GetRemainingSleepTimerDurationRequest getRemainingSleepTimerDuration() {
        return new GetRemainingSleepTimerDurationRequest();
    }

    public RunAlarmRequest runAlarm() {
        return new RunAlarmRequest();
    }

    public StartAutoplayRequest startAutoplay() {
        return new StartAutoplayRequest();
    }

    public GetRunningAlarmPropertiesRequest getRunningAlarmProperties() {
        return new GetRunningAlarmPropertiesRequest();
    }

    public SnoozeAlarmRequest snoozeAlarm() {
        return new SnoozeAlarmRequest();
    }

    
    public class SetAVTransportURIRequest {
        
        private int instanceID;

        private String currentURI;

        private String currentURIMetaData;

        
        public SetAVTransportURIRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SetAVTransportURIRequest currentURI(String currentURI) {
            this.currentURI = currentURI;
            return this;
        }

        public SetAVTransportURIRequest currentURIMetaData(String currentURIMetaData) {
            this.currentURIMetaData = currentURIMetaData;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetAVTransportURI");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("CurrentURI", this.currentURI);

            invocation.setInput("CurrentURIMetaData", this.currentURIMetaData);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class SetNextAVTransportURIRequest {
        
        private int instanceID;

        private String nextURI;

        private String nextURIMetaData;

        
        public SetNextAVTransportURIRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SetNextAVTransportURIRequest nextURI(String nextURI) {
            this.nextURI = nextURI;
            return this;
        }

        public SetNextAVTransportURIRequest nextURIMetaData(String nextURIMetaData) {
            this.nextURIMetaData = nextURIMetaData;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetNextAVTransportURI");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("NextURI", this.nextURI);

            invocation.setInput("NextURIMetaData", this.nextURIMetaData);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class AddURIToQueueRequest {
        
        private int instanceID;

        private String enqueuedURI;

        private String enqueuedURIMetaData;

        private int desiredFirstTrackNumberEnqueued;

        private boolean enqueueAsNext;

        
        public AddURIToQueueRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public AddURIToQueueRequest enqueuedURI(String enqueuedURI) {
            this.enqueuedURI = enqueuedURI;
            return this;
        }

        public AddURIToQueueRequest enqueuedURIMetaData(String enqueuedURIMetaData) {
            this.enqueuedURIMetaData = enqueuedURIMetaData;
            return this;
        }

        public AddURIToQueueRequest desiredFirstTrackNumberEnqueued(int desiredFirstTrackNumberEnqueued) {
            this.desiredFirstTrackNumberEnqueued = desiredFirstTrackNumberEnqueued;
            return this;
        }

        public AddURIToQueueRequest enqueueAsNext(boolean enqueueAsNext) {
            this.enqueueAsNext = enqueueAsNext;
            return this;
        }

        public AddURIToQueueResponse execute() throws SonosException {
            Action action = service.getAction("AddURIToQueue");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("EnqueuedURI", this.enqueuedURI);

            invocation.setInput("EnqueuedURIMetaData", this.enqueuedURIMetaData);

            invocation.setInput("DesiredFirstTrackNumberEnqueued", new UnsignedIntegerFourBytes(this.desiredFirstTrackNumberEnqueued));

            invocation.setInput("EnqueueAsNext", this.enqueueAsNext);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            AddURIToQueueResponse response = new AddURIToQueueResponse();
            
            response.firstTrackNumberEnqueued = ServiceHelper._ui4(invocation, "FirstTrackNumberEnqueued");

            response.numTracksAdded = ServiceHelper._ui4(invocation, "NumTracksAdded");

            response.newQueueLength = ServiceHelper._ui4(invocation, "NewQueueLength");

            return response;

        }
    }

    public class AddMultipleURIsToQueueRequest {
        
        private int instanceID;

        private int updateID;

        private int numberOfURIs;

        private String enqueuedURIs;

        private String enqueuedURIsMetaData;

        private String containerURI;

        private String containerMetaData;

        private int desiredFirstTrackNumberEnqueued;

        private boolean enqueueAsNext;

        
        public AddMultipleURIsToQueueRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public AddMultipleURIsToQueueRequest updateID(int updateID) {
            this.updateID = updateID;
            return this;
        }

        public AddMultipleURIsToQueueRequest numberOfURIs(int numberOfURIs) {
            this.numberOfURIs = numberOfURIs;
            return this;
        }

        public AddMultipleURIsToQueueRequest enqueuedURIs(String enqueuedURIs) {
            this.enqueuedURIs = enqueuedURIs;
            return this;
        }

        public AddMultipleURIsToQueueRequest enqueuedURIsMetaData(String enqueuedURIsMetaData) {
            this.enqueuedURIsMetaData = enqueuedURIsMetaData;
            return this;
        }

        public AddMultipleURIsToQueueRequest containerURI(String containerURI) {
            this.containerURI = containerURI;
            return this;
        }

        public AddMultipleURIsToQueueRequest containerMetaData(String containerMetaData) {
            this.containerMetaData = containerMetaData;
            return this;
        }

        public AddMultipleURIsToQueueRequest desiredFirstTrackNumberEnqueued(int desiredFirstTrackNumberEnqueued) {
            this.desiredFirstTrackNumberEnqueued = desiredFirstTrackNumberEnqueued;
            return this;
        }

        public AddMultipleURIsToQueueRequest enqueueAsNext(boolean enqueueAsNext) {
            this.enqueueAsNext = enqueueAsNext;
            return this;
        }

        public AddMultipleURIsToQueueResponse execute() throws SonosException {
            Action action = service.getAction("AddMultipleURIsToQueue");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("UpdateID", new UnsignedIntegerFourBytes(this.updateID));

            invocation.setInput("NumberOfURIs", new UnsignedIntegerFourBytes(this.numberOfURIs));

            invocation.setInput("EnqueuedURIs", this.enqueuedURIs);

            invocation.setInput("EnqueuedURIsMetaData", this.enqueuedURIsMetaData);

            invocation.setInput("ContainerURI", this.containerURI);

            invocation.setInput("ContainerMetaData", this.containerMetaData);

            invocation.setInput("DesiredFirstTrackNumberEnqueued", new UnsignedIntegerFourBytes(this.desiredFirstTrackNumberEnqueued));

            invocation.setInput("EnqueueAsNext", this.enqueueAsNext);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            AddMultipleURIsToQueueResponse response = new AddMultipleURIsToQueueResponse();
            
            response.firstTrackNumberEnqueued = ServiceHelper._ui4(invocation, "FirstTrackNumberEnqueued");

            response.numTracksAdded = ServiceHelper._ui4(invocation, "NumTracksAdded");

            response.newQueueLength = ServiceHelper._ui4(invocation, "NewQueueLength");

            response.newUpdateID = ServiceHelper._ui4(invocation, "NewUpdateID");

            return response;

        }
    }

    public class ReorderTracksInQueueRequest {
        
        private int instanceID;

        private int startingIndex;

        private int numberOfTracks;

        private int insertBefore;

        private int updateID;

        
        public ReorderTracksInQueueRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public ReorderTracksInQueueRequest startingIndex(int startingIndex) {
            this.startingIndex = startingIndex;
            return this;
        }

        public ReorderTracksInQueueRequest numberOfTracks(int numberOfTracks) {
            this.numberOfTracks = numberOfTracks;
            return this;
        }

        public ReorderTracksInQueueRequest insertBefore(int insertBefore) {
            this.insertBefore = insertBefore;
            return this;
        }

        public ReorderTracksInQueueRequest updateID(int updateID) {
            this.updateID = updateID;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("ReorderTracksInQueue");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("StartingIndex", new UnsignedIntegerFourBytes(this.startingIndex));

            invocation.setInput("NumberOfTracks", new UnsignedIntegerFourBytes(this.numberOfTracks));

            invocation.setInput("InsertBefore", new UnsignedIntegerFourBytes(this.insertBefore));

            invocation.setInput("UpdateID", new UnsignedIntegerFourBytes(this.updateID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class RemoveTrackFromQueueRequest {
        
        private int instanceID;

        private String objectID;

        private int updateID;

        
        public RemoveTrackFromQueueRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public RemoveTrackFromQueueRequest objectID(String objectID) {
            this.objectID = objectID;
            return this;
        }

        public RemoveTrackFromQueueRequest updateID(int updateID) {
            this.updateID = updateID;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("RemoveTrackFromQueue");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("ObjectID", this.objectID);

            invocation.setInput("UpdateID", new UnsignedIntegerFourBytes(this.updateID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class RemoveTrackRangeFromQueueRequest {
        
        private int instanceID;

        private int updateID;

        private int startingIndex;

        private int numberOfTracks;

        
        public RemoveTrackRangeFromQueueRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public RemoveTrackRangeFromQueueRequest updateID(int updateID) {
            this.updateID = updateID;
            return this;
        }

        public RemoveTrackRangeFromQueueRequest startingIndex(int startingIndex) {
            this.startingIndex = startingIndex;
            return this;
        }

        public RemoveTrackRangeFromQueueRequest numberOfTracks(int numberOfTracks) {
            this.numberOfTracks = numberOfTracks;
            return this;
        }

        public RemoveTrackRangeFromQueueResponse execute() throws SonosException {
            Action action = service.getAction("RemoveTrackRangeFromQueue");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("UpdateID", new UnsignedIntegerFourBytes(this.updateID));

            invocation.setInput("StartingIndex", new UnsignedIntegerFourBytes(this.startingIndex));

            invocation.setInput("NumberOfTracks", new UnsignedIntegerFourBytes(this.numberOfTracks));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            RemoveTrackRangeFromQueueResponse response = new RemoveTrackRangeFromQueueResponse();
            
            response.newUpdateID = ServiceHelper._ui4(invocation, "NewUpdateID");

            return response;

        }
    }

    public class RemoveAllTracksFromQueueRequest {
        
        private int instanceID;

        
        public RemoveAllTracksFromQueueRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("RemoveAllTracksFromQueue");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class SaveQueueRequest {
        
        private int instanceID;

        private String title;

        private String objectID;

        
        public SaveQueueRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SaveQueueRequest title(String title) {
            this.title = title;
            return this;
        }

        public SaveQueueRequest objectID(String objectID) {
            this.objectID = objectID;
            return this;
        }

        public SaveQueueResponse execute() throws SonosException {
            Action action = service.getAction("SaveQueue");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Title", this.title);

            invocation.setInput("ObjectID", this.objectID);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            SaveQueueResponse response = new SaveQueueResponse();
            
            response.assignedObjectID = ServiceHelper._string(invocation, "AssignedObjectID");

            return response;

        }
    }

    public class BackupQueueRequest {
        
        private int instanceID;

        
        public BackupQueueRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("BackupQueue");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class CreateSavedQueueRequest {
        
        private int instanceID;

        private String title;

        private String enqueuedURI;

        private String enqueuedURIMetaData;

        
        public CreateSavedQueueRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public CreateSavedQueueRequest title(String title) {
            this.title = title;
            return this;
        }

        public CreateSavedQueueRequest enqueuedURI(String enqueuedURI) {
            this.enqueuedURI = enqueuedURI;
            return this;
        }

        public CreateSavedQueueRequest enqueuedURIMetaData(String enqueuedURIMetaData) {
            this.enqueuedURIMetaData = enqueuedURIMetaData;
            return this;
        }

        public CreateSavedQueueResponse execute() throws SonosException {
            Action action = service.getAction("CreateSavedQueue");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Title", this.title);

            invocation.setInput("EnqueuedURI", this.enqueuedURI);

            invocation.setInput("EnqueuedURIMetaData", this.enqueuedURIMetaData);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            CreateSavedQueueResponse response = new CreateSavedQueueResponse();
            
            response.numTracksAdded = ServiceHelper._ui4(invocation, "NumTracksAdded");

            response.newQueueLength = ServiceHelper._ui4(invocation, "NewQueueLength");

            response.assignedObjectID = ServiceHelper._string(invocation, "AssignedObjectID");

            response.newUpdateID = ServiceHelper._ui4(invocation, "NewUpdateID");

            return response;

        }
    }

    public class AddURIToSavedQueueRequest {
        
        private int instanceID;

        private String objectID;

        private int updateID;

        private String enqueuedURI;

        private String enqueuedURIMetaData;

        private int addAtIndex;

        
        public AddURIToSavedQueueRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public AddURIToSavedQueueRequest objectID(String objectID) {
            this.objectID = objectID;
            return this;
        }

        public AddURIToSavedQueueRequest updateID(int updateID) {
            this.updateID = updateID;
            return this;
        }

        public AddURIToSavedQueueRequest enqueuedURI(String enqueuedURI) {
            this.enqueuedURI = enqueuedURI;
            return this;
        }

        public AddURIToSavedQueueRequest enqueuedURIMetaData(String enqueuedURIMetaData) {
            this.enqueuedURIMetaData = enqueuedURIMetaData;
            return this;
        }

        public AddURIToSavedQueueRequest addAtIndex(int addAtIndex) {
            this.addAtIndex = addAtIndex;
            return this;
        }

        public AddURIToSavedQueueResponse execute() throws SonosException {
            Action action = service.getAction("AddURIToSavedQueue");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("ObjectID", this.objectID);

            invocation.setInput("UpdateID", new UnsignedIntegerFourBytes(this.updateID));

            invocation.setInput("EnqueuedURI", this.enqueuedURI);

            invocation.setInput("EnqueuedURIMetaData", this.enqueuedURIMetaData);

            invocation.setInput("AddAtIndex", new UnsignedIntegerFourBytes(this.addAtIndex));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            AddURIToSavedQueueResponse response = new AddURIToSavedQueueResponse();
            
            response.numTracksAdded = ServiceHelper._ui4(invocation, "NumTracksAdded");

            response.newQueueLength = ServiceHelper._ui4(invocation, "NewQueueLength");

            response.newUpdateID = ServiceHelper._ui4(invocation, "NewUpdateID");

            return response;

        }
    }

    public class ReorderTracksInSavedQueueRequest {
        
        private int instanceID;

        private String objectID;

        private int updateID;

        private String trackList;

        private String newPositionList;

        
        public ReorderTracksInSavedQueueRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public ReorderTracksInSavedQueueRequest objectID(String objectID) {
            this.objectID = objectID;
            return this;
        }

        public ReorderTracksInSavedQueueRequest updateID(int updateID) {
            this.updateID = updateID;
            return this;
        }

        public ReorderTracksInSavedQueueRequest trackList(String trackList) {
            this.trackList = trackList;
            return this;
        }

        public ReorderTracksInSavedQueueRequest newPositionList(String newPositionList) {
            this.newPositionList = newPositionList;
            return this;
        }

        public ReorderTracksInSavedQueueResponse execute() throws SonosException {
            Action action = service.getAction("ReorderTracksInSavedQueue");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("ObjectID", this.objectID);

            invocation.setInput("UpdateID", new UnsignedIntegerFourBytes(this.updateID));

            invocation.setInput("TrackList", this.trackList);

            invocation.setInput("NewPositionList", this.newPositionList);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            ReorderTracksInSavedQueueResponse response = new ReorderTracksInSavedQueueResponse();
            
            response.queueLengthChange = ServiceHelper._i4(invocation, "QueueLengthChange");

            response.newQueueLength = ServiceHelper._ui4(invocation, "NewQueueLength");

            response.newUpdateID = ServiceHelper._ui4(invocation, "NewUpdateID");

            return response;

        }
    }

    public class GetMediaInfoRequest {
        
        private int instanceID;

        
        public GetMediaInfoRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetMediaInfoResponse execute() throws SonosException {
            Action action = service.getAction("GetMediaInfo");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetMediaInfoResponse response = new GetMediaInfoResponse();
            
            response.nrTracks = ServiceHelper._ui4(invocation, "NrTracks");

            response.mediaDuration = ServiceHelper._string(invocation, "MediaDuration");

            response.currentURI = ServiceHelper._string(invocation, "CurrentURI");

            response.currentURIMetaData = ServiceHelper._string(invocation, "CurrentURIMetaData");

            response.nextURI = ServiceHelper._string(invocation, "NextURI");

            response.nextURIMetaData = ServiceHelper._string(invocation, "NextURIMetaData");

            response.playMedium = ServiceHelper._string(invocation, "PlayMedium", PlaybackStorageMedium.class);

            response.recordMedium = ServiceHelper._string(invocation, "RecordMedium", RecordStorageMedium.class);

            response.writeStatus = ServiceHelper._string(invocation, "WriteStatus");

            return response;

        }
    }

    public class GetTransportInfoRequest {
        
        private int instanceID;

        
        public GetTransportInfoRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetTransportInfoResponse execute() throws SonosException {
            Action action = service.getAction("GetTransportInfo");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetTransportInfoResponse response = new GetTransportInfoResponse();
            
            response.currentTransportState = ServiceHelper._string(invocation, "CurrentTransportState", TransportState.class);

            response.currentTransportStatus = ServiceHelper._string(invocation, "CurrentTransportStatus");

            response.currentSpeed = ServiceHelper._string(invocation, "CurrentSpeed", TransportPlaySpeed.class);

            return response;

        }
    }

    public class GetPositionInfoRequest {
        
        private int instanceID;

        
        public GetPositionInfoRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetPositionInfoResponse execute() throws SonosException {
            Action action = service.getAction("GetPositionInfo");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetPositionInfoResponse response = new GetPositionInfoResponse();
            
            response.track = ServiceHelper._ui4(invocation, "Track");

            response.trackDuration = ServiceHelper._string(invocation, "TrackDuration");

            response.trackMetaData = ServiceHelper._string(invocation, "TrackMetaData");

            response.trackURI = ServiceHelper._string(invocation, "TrackURI");

            response.relTime = ServiceHelper._string(invocation, "RelTime");

            response.absTime = ServiceHelper._string(invocation, "AbsTime");

            response.relCount = ServiceHelper._i4(invocation, "RelCount");

            response.absCount = ServiceHelper._i4(invocation, "AbsCount");

            return response;

        }
    }

    public class GetDeviceCapabilitiesRequest {
        
        private int instanceID;

        
        public GetDeviceCapabilitiesRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetDeviceCapabilitiesResponse execute() throws SonosException {
            Action action = service.getAction("GetDeviceCapabilities");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetDeviceCapabilitiesResponse response = new GetDeviceCapabilitiesResponse();
            
            response.playMedia = ServiceHelper._string(invocation, "PlayMedia");

            response.recMedia = ServiceHelper._string(invocation, "RecMedia");

            response.recQualityModes = ServiceHelper._string(invocation, "RecQualityModes");

            return response;

        }
    }

    public class GetTransportSettingsRequest {
        
        private int instanceID;

        
        public GetTransportSettingsRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetTransportSettingsResponse execute() throws SonosException {
            Action action = service.getAction("GetTransportSettings");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetTransportSettingsResponse response = new GetTransportSettingsResponse();
            
            response.playMode = ServiceHelper._string(invocation, "PlayMode", CurrentPlayMode.class);

            response.recQualityMode = ServiceHelper._string(invocation, "RecQualityMode");

            return response;

        }
    }

    public class GetCrossfadeModeRequest {
        
        private int instanceID;

        
        public GetCrossfadeModeRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetCrossfadeModeResponse execute() throws SonosException {
            Action action = service.getAction("GetCrossfadeMode");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetCrossfadeModeResponse response = new GetCrossfadeModeResponse();
            
            response.crossfadeMode = ServiceHelper._boolean(invocation, "CrossfadeMode");

            return response;

        }
    }

    public class StopRequest {
        
        private int instanceID;

        
        public StopRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("Stop");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class PlayRequest {
        
        private int instanceID;

        private TransportPlaySpeed speed;

        
        public PlayRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public PlayRequest speed(TransportPlaySpeed speed) {
            this.speed = speed;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("Play");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Speed", (this.speed).toString().substring(1));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class PauseRequest {
        
        private int instanceID;

        
        public PauseRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("Pause");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class SeekRequest {
        
        private int instanceID;

        private SeekMode unit;

        private String target;

        
        public SeekRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SeekRequest unit(SeekMode unit) {
            this.unit = unit;
            return this;
        }

        public SeekRequest target(String target) {
            this.target = target;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("Seek");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Unit", this.unit);

            invocation.setInput("Target", this.target);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class NextRequest {
        
        private int instanceID;

        
        public NextRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("Next");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class NextProgrammedRadioTracksRequest {
        
        private int instanceID;

        
        public NextProgrammedRadioTracksRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("NextProgrammedRadioTracks");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class PreviousRequest {
        
        private int instanceID;

        
        public PreviousRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("Previous");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class NextSectionRequest {
        
        private int instanceID;

        
        public NextSectionRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("NextSection");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class PreviousSectionRequest {
        
        private int instanceID;

        
        public PreviousSectionRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("PreviousSection");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class SetPlayModeRequest {
        
        private int instanceID;

        private CurrentPlayMode newPlayMode;

        
        public SetPlayModeRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SetPlayModeRequest newPlayMode(CurrentPlayMode newPlayMode) {
            this.newPlayMode = newPlayMode;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetPlayMode");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("NewPlayMode", this.newPlayMode);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class SetCrossfadeModeRequest {
        
        private int instanceID;

        private boolean crossfadeMode;

        
        public SetCrossfadeModeRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SetCrossfadeModeRequest crossfadeMode(boolean crossfadeMode) {
            this.crossfadeMode = crossfadeMode;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetCrossfadeMode");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("CrossfadeMode", this.crossfadeMode);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class NotifyDeletedURIRequest {
        
        private int instanceID;

        private String deletedURI;

        
        public NotifyDeletedURIRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public NotifyDeletedURIRequest deletedURI(String deletedURI) {
            this.deletedURI = deletedURI;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("NotifyDeletedURI");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("DeletedURI", this.deletedURI);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetCurrentTransportActionsRequest {
        
        private int instanceID;

        
        public GetCurrentTransportActionsRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetCurrentTransportActionsResponse execute() throws SonosException {
            Action action = service.getAction("GetCurrentTransportActions");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetCurrentTransportActionsResponse response = new GetCurrentTransportActionsResponse();
            
            response.actions = ServiceHelper._string(invocation, "Actions");

            return response;

        }
    }

    public class BecomeCoordinatorOfStandaloneGroupRequest {
        
        private int instanceID;

        
        public BecomeCoordinatorOfStandaloneGroupRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("BecomeCoordinatorOfStandaloneGroup");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class DelegateGroupCoordinationToRequest {
        
        private int instanceID;

        private String newCoordinator;

        private boolean rejoinGroup;

        
        public DelegateGroupCoordinationToRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public DelegateGroupCoordinationToRequest newCoordinator(String newCoordinator) {
            this.newCoordinator = newCoordinator;
            return this;
        }

        public DelegateGroupCoordinationToRequest rejoinGroup(boolean rejoinGroup) {
            this.rejoinGroup = rejoinGroup;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("DelegateGroupCoordinationTo");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("NewCoordinator", this.newCoordinator);

            invocation.setInput("RejoinGroup", this.rejoinGroup);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class BecomeGroupCoordinatorRequest {
        
        private int instanceID;

        private String currentCoordinator;

        private String currentGroupID;

        private String otherMembers;

        private String transportSettings;

        private String currentURI;

        private String currentURIMetaData;

        private String sleepTimerState;

        private String alarmState;

        private String streamRestartState;

        private String currentQueueTrackList;

        
        public BecomeGroupCoordinatorRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public BecomeGroupCoordinatorRequest currentCoordinator(String currentCoordinator) {
            this.currentCoordinator = currentCoordinator;
            return this;
        }

        public BecomeGroupCoordinatorRequest currentGroupID(String currentGroupID) {
            this.currentGroupID = currentGroupID;
            return this;
        }

        public BecomeGroupCoordinatorRequest otherMembers(String otherMembers) {
            this.otherMembers = otherMembers;
            return this;
        }

        public BecomeGroupCoordinatorRequest transportSettings(String transportSettings) {
            this.transportSettings = transportSettings;
            return this;
        }

        public BecomeGroupCoordinatorRequest currentURI(String currentURI) {
            this.currentURI = currentURI;
            return this;
        }

        public BecomeGroupCoordinatorRequest currentURIMetaData(String currentURIMetaData) {
            this.currentURIMetaData = currentURIMetaData;
            return this;
        }

        public BecomeGroupCoordinatorRequest sleepTimerState(String sleepTimerState) {
            this.sleepTimerState = sleepTimerState;
            return this;
        }

        public BecomeGroupCoordinatorRequest alarmState(String alarmState) {
            this.alarmState = alarmState;
            return this;
        }

        public BecomeGroupCoordinatorRequest streamRestartState(String streamRestartState) {
            this.streamRestartState = streamRestartState;
            return this;
        }

        public BecomeGroupCoordinatorRequest currentQueueTrackList(String currentQueueTrackList) {
            this.currentQueueTrackList = currentQueueTrackList;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("BecomeGroupCoordinator");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("CurrentCoordinator", this.currentCoordinator);

            invocation.setInput("CurrentGroupID", this.currentGroupID);

            invocation.setInput("OtherMembers", this.otherMembers);

            invocation.setInput("TransportSettings", this.transportSettings);

            invocation.setInput("CurrentURI", this.currentURI);

            invocation.setInput("CurrentURIMetaData", this.currentURIMetaData);

            invocation.setInput("SleepTimerState", this.sleepTimerState);

            invocation.setInput("AlarmState", this.alarmState);

            invocation.setInput("StreamRestartState", this.streamRestartState);

            invocation.setInput("CurrentQueueTrackList", this.currentQueueTrackList);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class BecomeGroupCoordinatorAndSourceRequest {
        
        private int instanceID;

        private String currentCoordinator;

        private String currentGroupID;

        private String otherMembers;

        private String currentURI;

        private String currentURIMetaData;

        private String sleepTimerState;

        private String alarmState;

        private String streamRestartState;

        private String currentAVTTrackList;

        private String currentQueueTrackList;

        private String currentSourceState;

        private boolean resumePlayback;

        
        public BecomeGroupCoordinatorAndSourceRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public BecomeGroupCoordinatorAndSourceRequest currentCoordinator(String currentCoordinator) {
            this.currentCoordinator = currentCoordinator;
            return this;
        }

        public BecomeGroupCoordinatorAndSourceRequest currentGroupID(String currentGroupID) {
            this.currentGroupID = currentGroupID;
            return this;
        }

        public BecomeGroupCoordinatorAndSourceRequest otherMembers(String otherMembers) {
            this.otherMembers = otherMembers;
            return this;
        }

        public BecomeGroupCoordinatorAndSourceRequest currentURI(String currentURI) {
            this.currentURI = currentURI;
            return this;
        }

        public BecomeGroupCoordinatorAndSourceRequest currentURIMetaData(String currentURIMetaData) {
            this.currentURIMetaData = currentURIMetaData;
            return this;
        }

        public BecomeGroupCoordinatorAndSourceRequest sleepTimerState(String sleepTimerState) {
            this.sleepTimerState = sleepTimerState;
            return this;
        }

        public BecomeGroupCoordinatorAndSourceRequest alarmState(String alarmState) {
            this.alarmState = alarmState;
            return this;
        }

        public BecomeGroupCoordinatorAndSourceRequest streamRestartState(String streamRestartState) {
            this.streamRestartState = streamRestartState;
            return this;
        }

        public BecomeGroupCoordinatorAndSourceRequest currentAVTTrackList(String currentAVTTrackList) {
            this.currentAVTTrackList = currentAVTTrackList;
            return this;
        }

        public BecomeGroupCoordinatorAndSourceRequest currentQueueTrackList(String currentQueueTrackList) {
            this.currentQueueTrackList = currentQueueTrackList;
            return this;
        }

        public BecomeGroupCoordinatorAndSourceRequest currentSourceState(String currentSourceState) {
            this.currentSourceState = currentSourceState;
            return this;
        }

        public BecomeGroupCoordinatorAndSourceRequest resumePlayback(boolean resumePlayback) {
            this.resumePlayback = resumePlayback;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("BecomeGroupCoordinatorAndSource");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("CurrentCoordinator", this.currentCoordinator);

            invocation.setInput("CurrentGroupID", this.currentGroupID);

            invocation.setInput("OtherMembers", this.otherMembers);

            invocation.setInput("CurrentURI", this.currentURI);

            invocation.setInput("CurrentURIMetaData", this.currentURIMetaData);

            invocation.setInput("SleepTimerState", this.sleepTimerState);

            invocation.setInput("AlarmState", this.alarmState);

            invocation.setInput("StreamRestartState", this.streamRestartState);

            invocation.setInput("CurrentAVTTrackList", this.currentAVTTrackList);

            invocation.setInput("CurrentQueueTrackList", this.currentQueueTrackList);

            invocation.setInput("CurrentSourceState", this.currentSourceState);

            invocation.setInput("ResumePlayback", this.resumePlayback);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class ChangeCoordinatorRequest {
        
        private int instanceID;

        private String currentCoordinator;

        private String newCoordinator;

        private String newTransportSettings;

        
        public ChangeCoordinatorRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public ChangeCoordinatorRequest currentCoordinator(String currentCoordinator) {
            this.currentCoordinator = currentCoordinator;
            return this;
        }

        public ChangeCoordinatorRequest newCoordinator(String newCoordinator) {
            this.newCoordinator = newCoordinator;
            return this;
        }

        public ChangeCoordinatorRequest newTransportSettings(String newTransportSettings) {
            this.newTransportSettings = newTransportSettings;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("ChangeCoordinator");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("CurrentCoordinator", this.currentCoordinator);

            invocation.setInput("NewCoordinator", this.newCoordinator);

            invocation.setInput("NewTransportSettings", this.newTransportSettings);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class ChangeTransportSettingsRequest {
        
        private int instanceID;

        private String newTransportSettings;

        private String currentAVTransportURI;

        
        public ChangeTransportSettingsRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public ChangeTransportSettingsRequest newTransportSettings(String newTransportSettings) {
            this.newTransportSettings = newTransportSettings;
            return this;
        }

        public ChangeTransportSettingsRequest currentAVTransportURI(String currentAVTransportURI) {
            this.currentAVTransportURI = currentAVTransportURI;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("ChangeTransportSettings");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("NewTransportSettings", this.newTransportSettings);

            invocation.setInput("CurrentAVTransportURI", this.currentAVTransportURI);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class ConfigureSleepTimerRequest {
        
        private int instanceID;

        private String newSleepTimerDuration;

        
        public ConfigureSleepTimerRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public ConfigureSleepTimerRequest newSleepTimerDuration(String newSleepTimerDuration) {
            this.newSleepTimerDuration = newSleepTimerDuration;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("ConfigureSleepTimer");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("NewSleepTimerDuration", this.newSleepTimerDuration);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetRemainingSleepTimerDurationRequest {
        
        private int instanceID;

        
        public GetRemainingSleepTimerDurationRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetRemainingSleepTimerDurationResponse execute() throws SonosException {
            Action action = service.getAction("GetRemainingSleepTimerDuration");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetRemainingSleepTimerDurationResponse response = new GetRemainingSleepTimerDurationResponse();
            
            response.remainingSleepTimerDuration = ServiceHelper._string(invocation, "RemainingSleepTimerDuration");

            response.currentSleepTimerGeneration = ServiceHelper._ui4(invocation, "CurrentSleepTimerGeneration");

            return response;

        }
    }

    public class RunAlarmRequest {
        
        private int instanceID;

        private int alarmID;

        private String loggedStartTime;

        private String duration;

        private String programURI;

        private String programMetaData;

        private CurrentPlayMode playMode;

        private int volume;

        private boolean includeLinkedZones;

        
        public RunAlarmRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public RunAlarmRequest alarmID(int alarmID) {
            this.alarmID = alarmID;
            return this;
        }

        public RunAlarmRequest loggedStartTime(String loggedStartTime) {
            this.loggedStartTime = loggedStartTime;
            return this;
        }

        public RunAlarmRequest duration(String duration) {
            this.duration = duration;
            return this;
        }

        public RunAlarmRequest programURI(String programURI) {
            this.programURI = programURI;
            return this;
        }

        public RunAlarmRequest programMetaData(String programMetaData) {
            this.programMetaData = programMetaData;
            return this;
        }

        public RunAlarmRequest playMode(CurrentPlayMode playMode) {
            this.playMode = playMode;
            return this;
        }

        public RunAlarmRequest volume(int volume) {
            this.volume = volume;
            return this;
        }

        public RunAlarmRequest includeLinkedZones(boolean includeLinkedZones) {
            this.includeLinkedZones = includeLinkedZones;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("RunAlarm");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("AlarmID", new UnsignedIntegerFourBytes(this.alarmID));

            invocation.setInput("LoggedStartTime", this.loggedStartTime);

            invocation.setInput("Duration", this.duration);

            invocation.setInput("ProgramURI", this.programURI);

            invocation.setInput("ProgramMetaData", this.programMetaData);

            invocation.setInput("PlayMode", this.playMode);

            invocation.setInput("Volume", new UnsignedIntegerTwoBytes(this.volume));

            invocation.setInput("IncludeLinkedZones", this.includeLinkedZones);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class StartAutoplayRequest {
        
        private int instanceID;

        private String programURI;

        private String programMetaData;

        private int volume;

        private boolean includeLinkedZones;

        private boolean resetVolumeAfter;

        
        public StartAutoplayRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public StartAutoplayRequest programURI(String programURI) {
            this.programURI = programURI;
            return this;
        }

        public StartAutoplayRequest programMetaData(String programMetaData) {
            this.programMetaData = programMetaData;
            return this;
        }

        public StartAutoplayRequest volume(int volume) {
            this.volume = volume;
            return this;
        }

        public StartAutoplayRequest includeLinkedZones(boolean includeLinkedZones) {
            this.includeLinkedZones = includeLinkedZones;
            return this;
        }

        public StartAutoplayRequest resetVolumeAfter(boolean resetVolumeAfter) {
            this.resetVolumeAfter = resetVolumeAfter;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("StartAutoplay");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("ProgramURI", this.programURI);

            invocation.setInput("ProgramMetaData", this.programMetaData);

            invocation.setInput("Volume", new UnsignedIntegerTwoBytes(this.volume));

            invocation.setInput("IncludeLinkedZones", this.includeLinkedZones);

            invocation.setInput("ResetVolumeAfter", this.resetVolumeAfter);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetRunningAlarmPropertiesRequest {
        
        private int instanceID;

        
        public GetRunningAlarmPropertiesRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public GetRunningAlarmPropertiesResponse execute() throws SonosException {
            Action action = service.getAction("GetRunningAlarmProperties");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetRunningAlarmPropertiesResponse response = new GetRunningAlarmPropertiesResponse();
            
            response.alarmID = ServiceHelper._ui4(invocation, "AlarmID");

            response.groupID = ServiceHelper._string(invocation, "GroupID");

            response.loggedStartTime = ServiceHelper._string(invocation, "LoggedStartTime");

            return response;

        }
    }

    public class SnoozeAlarmRequest {
        
        private int instanceID;

        private String duration;

        
        public SnoozeAlarmRequest instanceID(int instanceID) {
            this.instanceID = instanceID;
            return this;
        }

        public SnoozeAlarmRequest duration(String duration) {
            this.duration = duration;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SnoozeAlarm");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("InstanceID", new UnsignedIntegerFourBytes(this.instanceID));

            invocation.setInput("Duration", this.duration);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    
    public class AddURIToQueueResponse {
        
        private int firstTrackNumberEnqueued;

        private int numTracksAdded;

        private int newQueueLength;

        
        public int firstTrackNumberEnqueued() {
            return firstTrackNumberEnqueued;
        }

        public int numTracksAdded() {
            return numTracksAdded;
        }

        public int newQueueLength() {
            return newQueueLength;
        }

    }

    public class AddMultipleURIsToQueueResponse {
        
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

    public class RemoveTrackRangeFromQueueResponse {
        
        private int newUpdateID;

        
        public int newUpdateID() {
            return newUpdateID;
        }

    }

    public class SaveQueueResponse {
        
        private String assignedObjectID;

        
        public String assignedObjectID() {
            return assignedObjectID;
        }

    }

    public class CreateSavedQueueResponse {
        
        private int numTracksAdded;

        private int newQueueLength;

        private String assignedObjectID;

        private int newUpdateID;

        
        public int numTracksAdded() {
            return numTracksAdded;
        }

        public int newQueueLength() {
            return newQueueLength;
        }

        public String assignedObjectID() {
            return assignedObjectID;
        }

        public int newUpdateID() {
            return newUpdateID;
        }

    }

    public class AddURIToSavedQueueResponse {
        
        private int numTracksAdded;

        private int newQueueLength;

        private int newUpdateID;

        
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

    public class ReorderTracksInSavedQueueResponse {
        
        private int queueLengthChange;

        private int newQueueLength;

        private int newUpdateID;

        
        public int queueLengthChange() {
            return queueLengthChange;
        }

        public int newQueueLength() {
            return newQueueLength;
        }

        public int newUpdateID() {
            return newUpdateID;
        }

    }

    public class GetMediaInfoResponse {
        
        private int nrTracks;

        private String mediaDuration;

        private String currentURI;

        private String currentURIMetaData;

        private String nextURI;

        private String nextURIMetaData;

        private PlaybackStorageMedium playMedium;

        private RecordStorageMedium recordMedium;

        private String writeStatus;

        
        public int nrTracks() {
            return nrTracks;
        }

        public String mediaDuration() {
            return mediaDuration;
        }

        public String currentURI() {
            return currentURI;
        }

        public String currentURIMetaData() {
            return currentURIMetaData;
        }

        public String nextURI() {
            return nextURI;
        }

        public String nextURIMetaData() {
            return nextURIMetaData;
        }

        public PlaybackStorageMedium playMedium() {
            return playMedium;
        }

        public RecordStorageMedium recordMedium() {
            return recordMedium;
        }

        public String writeStatus() {
            return writeStatus;
        }

    }

    public class GetTransportInfoResponse {
        
        private TransportState currentTransportState;

        private String currentTransportStatus;

        private TransportPlaySpeed currentSpeed;

        
        public TransportState currentTransportState() {
            return currentTransportState;
        }

        public String currentTransportStatus() {
            return currentTransportStatus;
        }

        public TransportPlaySpeed currentSpeed() {
            return currentSpeed;
        }

    }

    public class GetPositionInfoResponse {
        
        private int track;

        private String trackDuration;

        private String trackMetaData;

        private String trackURI;

        private String relTime;

        private String absTime;

        private int relCount;

        private int absCount;

        
        public int track() {
            return track;
        }

        public String trackDuration() {
            return trackDuration;
        }

        public String trackMetaData() {
            return trackMetaData;
        }

        public String trackURI() {
            return trackURI;
        }

        public String relTime() {
            return relTime;
        }

        public String absTime() {
            return absTime;
        }

        public int relCount() {
            return relCount;
        }

        public int absCount() {
            return absCount;
        }

    }

    public class GetDeviceCapabilitiesResponse {
        
        private String playMedia;

        private String recMedia;

        private String recQualityModes;

        
        public String playMedia() {
            return playMedia;
        }

        public String recMedia() {
            return recMedia;
        }

        public String recQualityModes() {
            return recQualityModes;
        }

    }

    public class GetTransportSettingsResponse {
        
        private CurrentPlayMode playMode;

        private String recQualityMode;

        
        public CurrentPlayMode playMode() {
            return playMode;
        }

        public String recQualityMode() {
            return recQualityMode;
        }

    }

    public class GetCrossfadeModeResponse {
        
        private boolean crossfadeMode;

        
        public boolean crossfadeMode() {
            return crossfadeMode;
        }

    }

    public class GetCurrentTransportActionsResponse {
        
        private String actions;

        
        public String actions() {
            return actions;
        }

    }

    public class GetRemainingSleepTimerDurationResponse {
        
        private String remainingSleepTimerDuration;

        private int currentSleepTimerGeneration;

        
        public String remainingSleepTimerDuration() {
            return remainingSleepTimerDuration;
        }

        public int currentSleepTimerGeneration() {
            return currentSleepTimerGeneration;
        }

    }

    public class GetRunningAlarmPropertiesResponse {
        
        private int alarmID;

        private String groupID;

        private String loggedStartTime;

        
        public int alarmID() {
            return alarmID;
        }

        public String groupID() {
            return groupID;
        }

        public String loggedStartTime() {
            return loggedStartTime;
        }

    }

}
