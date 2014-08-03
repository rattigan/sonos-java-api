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


public class ContentDirectory {
    private Service service;
    private UpnpService upnpService;

    public ContentDirectory(UpnpService upnpService, RemoteDevice device) {
        this.upnpService = upnpService;
        this.service = RemoteDeviceHelper.findService(device, "urn:upnp-org:serviceId:ContentDirectory");
    }
    
    public enum BrowseFlag {BrowseMetadata, BrowseDirectChildren}

    public enum ShareListRefreshState {NOTRUN, RUNNING, DONE}

    
    public GetSearchCapabilitiesRequest getSearchCapabilities() {
        return new GetSearchCapabilitiesRequest();
    }

    public GetSortCapabilitiesRequest getSortCapabilities() {
        return new GetSortCapabilitiesRequest();
    }

    public GetSystemUpdateIDRequest getSystemUpdateID() {
        return new GetSystemUpdateIDRequest();
    }

    public GetAlbumArtistDisplayOptionRequest getAlbumArtistDisplayOption() {
        return new GetAlbumArtistDisplayOptionRequest();
    }

    public GetLastIndexChangeRequest getLastIndexChange() {
        return new GetLastIndexChangeRequest();
    }

    public BrowseRequest browse() {
        return new BrowseRequest();
    }

    public FindPrefixRequest findPrefix() {
        return new FindPrefixRequest();
    }

    public GetAllPrefixLocationsRequest getAllPrefixLocations() {
        return new GetAllPrefixLocationsRequest();
    }

    public CreateObjectRequest createObject() {
        return new CreateObjectRequest();
    }

    public UpdateObjectRequest updateObject() {
        return new UpdateObjectRequest();
    }

    public DestroyObjectRequest destroyObject() {
        return new DestroyObjectRequest();
    }

    public RefreshShareListRequest refreshShareList() {
        return new RefreshShareListRequest();
    }

    public RefreshShareIndexRequest refreshShareIndex() {
        return new RefreshShareIndexRequest();
    }

    public RequestResortRequest requestResort() {
        return new RequestResortRequest();
    }

    public GetShareIndexInProgressRequest getShareIndexInProgress() {
        return new GetShareIndexInProgressRequest();
    }

    public GetBrowseableRequest getBrowseable() {
        return new GetBrowseableRequest();
    }

    public SetBrowseableRequest setBrowseable() {
        return new SetBrowseableRequest();
    }

    
    public class GetSearchCapabilitiesRequest {
        
        
        public GetSearchCapabilitiesResponse execute() {
            Action action = service.getAction("GetSearchCapabilities");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetSearchCapabilitiesResponse response = new GetSearchCapabilitiesResponse();
            
            response.searchCaps = ServiceHelper._string(invocation, "SearchCaps");

            return response;

        }
    }

    public class GetSortCapabilitiesRequest {
        
        
        public GetSortCapabilitiesResponse execute() {
            Action action = service.getAction("GetSortCapabilities");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetSortCapabilitiesResponse response = new GetSortCapabilitiesResponse();
            
            response.sortCaps = ServiceHelper._string(invocation, "SortCaps");

            return response;

        }
    }

    public class GetSystemUpdateIDRequest {
        
        
        public GetSystemUpdateIDResponse execute() {
            Action action = service.getAction("GetSystemUpdateID");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetSystemUpdateIDResponse response = new GetSystemUpdateIDResponse();
            
            response.id = ServiceHelper._ui4(invocation, "Id");

            return response;

        }
    }

    public class GetAlbumArtistDisplayOptionRequest {
        
        
        public GetAlbumArtistDisplayOptionResponse execute() {
            Action action = service.getAction("GetAlbumArtistDisplayOption");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetAlbumArtistDisplayOptionResponse response = new GetAlbumArtistDisplayOptionResponse();
            
            response.albumArtistDisplayOption = ServiceHelper._string(invocation, "AlbumArtistDisplayOption");

            return response;

        }
    }

    public class GetLastIndexChangeRequest {
        
        
        public GetLastIndexChangeResponse execute() {
            Action action = service.getAction("GetLastIndexChange");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetLastIndexChangeResponse response = new GetLastIndexChangeResponse();
            
            response.lastIndexChange = ServiceHelper._string(invocation, "LastIndexChange");

            return response;

        }
    }

    public class BrowseRequest {
        
        private String objectID;

        private BrowseFlag browseFlag;

        private String filter;

        private int startingIndex;

        private int requestedCount;

        private String sortCriteria;

        
        public BrowseRequest objectID(String objectID) {
            this.objectID = objectID;
            return this;
        }

        public BrowseRequest browseFlag(BrowseFlag browseFlag) {
            this.browseFlag = browseFlag;
            return this;
        }

        public BrowseRequest filter(String filter) {
            this.filter = filter;
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

        public BrowseRequest sortCriteria(String sortCriteria) {
            this.sortCriteria = sortCriteria;
            return this;
        }

        public BrowseResponse execute() {
            Action action = service.getAction("Browse");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("ObjectID", this.objectID);

            invocation.setInput("BrowseFlag", this.browseFlag);

            invocation.setInput("Filter", this.filter);

            invocation.setInput("StartingIndex", new UnsignedIntegerFourBytes(this.startingIndex));

            invocation.setInput("RequestedCount", new UnsignedIntegerFourBytes(this.requestedCount));

            invocation.setInput("SortCriteria", this.sortCriteria);

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

    public class FindPrefixRequest {
        
        private String objectID;

        private String prefix;

        
        public FindPrefixRequest objectID(String objectID) {
            this.objectID = objectID;
            return this;
        }

        public FindPrefixRequest prefix(String prefix) {
            this.prefix = prefix;
            return this;
        }

        public FindPrefixResponse execute() {
            Action action = service.getAction("FindPrefix");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("ObjectID", this.objectID);

            invocation.setInput("Prefix", this.prefix);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            FindPrefixResponse response = new FindPrefixResponse();
            
            response.startingIndex = ServiceHelper._ui4(invocation, "StartingIndex");

            response.updateID = ServiceHelper._ui4(invocation, "UpdateID");

            return response;

        }
    }

    public class GetAllPrefixLocationsRequest {
        
        private String objectID;

        
        public GetAllPrefixLocationsRequest objectID(String objectID) {
            this.objectID = objectID;
            return this;
        }

        public GetAllPrefixLocationsResponse execute() {
            Action action = service.getAction("GetAllPrefixLocations");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("ObjectID", this.objectID);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetAllPrefixLocationsResponse response = new GetAllPrefixLocationsResponse();
            
            response.totalPrefixes = ServiceHelper._ui4(invocation, "TotalPrefixes");

            response.prefixAndIndexCSV = ServiceHelper._string(invocation, "PrefixAndIndexCSV");

            response.updateID = ServiceHelper._ui4(invocation, "UpdateID");

            return response;

        }
    }

    public class CreateObjectRequest {
        
        private String containerID;

        private String elements;

        
        public CreateObjectRequest containerID(String containerID) {
            this.containerID = containerID;
            return this;
        }

        public CreateObjectRequest elements(String elements) {
            this.elements = elements;
            return this;
        }

        public CreateObjectResponse execute() {
            Action action = service.getAction("CreateObject");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("ContainerID", this.containerID);

            invocation.setInput("Elements", this.elements);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            CreateObjectResponse response = new CreateObjectResponse();
            
            response.objectID = ServiceHelper._string(invocation, "ObjectID");

            response.result = ServiceHelper._string(invocation, "Result");

            return response;

        }
    }

    public class UpdateObjectRequest {
        
        private String objectID;

        private String currentTagValue;

        private String newTagValue;

        
        public UpdateObjectRequest objectID(String objectID) {
            this.objectID = objectID;
            return this;
        }

        public UpdateObjectRequest currentTagValue(String currentTagValue) {
            this.currentTagValue = currentTagValue;
            return this;
        }

        public UpdateObjectRequest newTagValue(String newTagValue) {
            this.newTagValue = newTagValue;
            return this;
        }

        public void execute() {
            Action action = service.getAction("UpdateObject");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("ObjectID", this.objectID);

            invocation.setInput("CurrentTagValue", this.currentTagValue);

            invocation.setInput("NewTagValue", this.newTagValue);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class DestroyObjectRequest {
        
        private String objectID;

        
        public DestroyObjectRequest objectID(String objectID) {
            this.objectID = objectID;
            return this;
        }

        public void execute() {
            Action action = service.getAction("DestroyObject");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("ObjectID", this.objectID);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class RefreshShareListRequest {
        
        
        public void execute() {
            Action action = service.getAction("RefreshShareList");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class RefreshShareIndexRequest {
        
        private String albumArtistDisplayOption;

        
        public RefreshShareIndexRequest albumArtistDisplayOption(String albumArtistDisplayOption) {
            this.albumArtistDisplayOption = albumArtistDisplayOption;
            return this;
        }

        public void execute() {
            Action action = service.getAction("RefreshShareIndex");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("AlbumArtistDisplayOption", this.albumArtistDisplayOption);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class RequestResortRequest {
        
        private String sortOrder;

        
        public RequestResortRequest sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        public void execute() {
            Action action = service.getAction("RequestResort");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("SortOrder", this.sortOrder);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetShareIndexInProgressRequest {
        
        
        public GetShareIndexInProgressResponse execute() {
            Action action = service.getAction("GetShareIndexInProgress");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetShareIndexInProgressResponse response = new GetShareIndexInProgressResponse();
            
            response.isIndexing = ServiceHelper._boolean(invocation, "IsIndexing");

            return response;

        }
    }

    public class GetBrowseableRequest {
        
        
        public GetBrowseableResponse execute() {
            Action action = service.getAction("GetBrowseable");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetBrowseableResponse response = new GetBrowseableResponse();
            
            response.isBrowseable = ServiceHelper._boolean(invocation, "IsBrowseable");

            return response;

        }
    }

    public class SetBrowseableRequest {
        
        private boolean browseable;

        
        public SetBrowseableRequest browseable(boolean browseable) {
            this.browseable = browseable;
            return this;
        }

        public void execute() {
            Action action = service.getAction("SetBrowseable");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("Browseable", this.browseable);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException("" + invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    
    public class GetSearchCapabilitiesResponse {
        
        private String searchCaps;

        
        public String searchCaps() {
            return searchCaps;
        }

    }

    public class GetSortCapabilitiesResponse {
        
        private String sortCaps;

        
        public String sortCaps() {
            return sortCaps;
        }

    }

    public class GetSystemUpdateIDResponse {
        
        private int id;

        
        public int id() {
            return id;
        }

    }

    public class GetAlbumArtistDisplayOptionResponse {
        
        private String albumArtistDisplayOption;

        
        public String albumArtistDisplayOption() {
            return albumArtistDisplayOption;
        }

    }

    public class GetLastIndexChangeResponse {
        
        private String lastIndexChange;

        
        public String lastIndexChange() {
            return lastIndexChange;
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

    public class FindPrefixResponse {
        
        private int startingIndex;

        private int updateID;

        
        public int startingIndex() {
            return startingIndex;
        }

        public int updateID() {
            return updateID;
        }

    }

    public class GetAllPrefixLocationsResponse {
        
        private int totalPrefixes;

        private String prefixAndIndexCSV;

        private int updateID;

        
        public int totalPrefixes() {
            return totalPrefixes;
        }

        public String prefixAndIndexCSV() {
            return prefixAndIndexCSV;
        }

        public int updateID() {
            return updateID;
        }

    }

    public class CreateObjectResponse {
        
        private String objectID;

        private String result;

        
        public String objectID() {
            return objectID;
        }

        public String result() {
            return result;
        }

    }

    public class GetShareIndexInProgressResponse {
        
        private boolean isIndexing;

        
        public boolean isIndexing() {
            return isIndexing;
        }

    }

    public class GetBrowseableResponse {
        
        private boolean isBrowseable;

        
        public boolean isBrowseable() {
            return isBrowseable;
        }

    }

}
