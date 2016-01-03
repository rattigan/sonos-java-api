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


public class AlarmClock {
    private Service service;
    private UpnpService upnpService;

    public AlarmClock(UpnpService upnpService, RemoteDevice device) {
        this.upnpService = upnpService;
        this.service = RemoteDeviceHelper.findService(device, "urn:upnp-org:serviceId:AlarmClock");
    }
    
    public enum Recurrence {ONCE, WEEKDAYS, WEEKENDS, DAILY}

    public enum AlarmPlayMode {NORMAL, REPEAT_ALL, SHUFFLE_NOREPEAT, SHUFFLE}

    
    public SetFormatRequest setFormat() {
        return new SetFormatRequest();
    }

    public GetFormatRequest getFormat() {
        return new GetFormatRequest();
    }

    public SetTimeZoneRequest setTimeZone() {
        return new SetTimeZoneRequest();
    }

    public GetTimeZoneRequest getTimeZone() {
        return new GetTimeZoneRequest();
    }

    public GetTimeZoneAndRuleRequest getTimeZoneAndRule() {
        return new GetTimeZoneAndRuleRequest();
    }

    public GetTimeZoneRuleRequest getTimeZoneRule() {
        return new GetTimeZoneRuleRequest();
    }

    public SetTimeServerRequest setTimeServer() {
        return new SetTimeServerRequest();
    }

    public GetTimeServerRequest getTimeServer() {
        return new GetTimeServerRequest();
    }

    public SetTimeNowRequest setTimeNow() {
        return new SetTimeNowRequest();
    }

    public GetHouseholdTimeAtStampRequest getHouseholdTimeAtStamp() {
        return new GetHouseholdTimeAtStampRequest();
    }

    public GetTimeNowRequest getTimeNow() {
        return new GetTimeNowRequest();
    }

    public CreateAlarmRequest createAlarm() {
        return new CreateAlarmRequest();
    }

    public UpdateAlarmRequest updateAlarm() {
        return new UpdateAlarmRequest();
    }

    public DestroyAlarmRequest destroyAlarm() {
        return new DestroyAlarmRequest();
    }

    public ListAlarmsRequest listAlarms() {
        return new ListAlarmsRequest();
    }

    public SetDailyIndexRefreshTimeRequest setDailyIndexRefreshTime() {
        return new SetDailyIndexRefreshTimeRequest();
    }

    public GetDailyIndexRefreshTimeRequest getDailyIndexRefreshTime() {
        return new GetDailyIndexRefreshTimeRequest();
    }

    
    public class SetFormatRequest {
        
        private String desiredTimeFormat;

        private String desiredDateFormat;

        
        public SetFormatRequest desiredTimeFormat(String desiredTimeFormat) {
            this.desiredTimeFormat = desiredTimeFormat;
            return this;
        }

        public SetFormatRequest desiredDateFormat(String desiredDateFormat) {
            this.desiredDateFormat = desiredDateFormat;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetFormat");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("DesiredTimeFormat", this.desiredTimeFormat);

            invocation.setInput("DesiredDateFormat", this.desiredDateFormat);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetFormatRequest {
        
        
        public GetFormatResponse execute() throws SonosException {
            Action action = service.getAction("GetFormat");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetFormatResponse response = new GetFormatResponse();
            
            response.currentTimeFormat = ServiceHelper._string(invocation, "CurrentTimeFormat");

            response.currentDateFormat = ServiceHelper._string(invocation, "CurrentDateFormat");

            return response;

        }
    }

    public class SetTimeZoneRequest {
        
        private int index;

        private boolean autoAdjustDst;

        
        public SetTimeZoneRequest index(int index) {
            this.index = index;
            return this;
        }

        public SetTimeZoneRequest autoAdjustDst(boolean autoAdjustDst) {
            this.autoAdjustDst = autoAdjustDst;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetTimeZone");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("Index", this.index);

            invocation.setInput("AutoAdjustDst", this.autoAdjustDst);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetTimeZoneRequest {
        
        
        public GetTimeZoneResponse execute() throws SonosException {
            Action action = service.getAction("GetTimeZone");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetTimeZoneResponse response = new GetTimeZoneResponse();
            
            response.index = ServiceHelper._i4(invocation, "Index");

            response.autoAdjustDst = ServiceHelper._boolean(invocation, "AutoAdjustDst");

            return response;

        }
    }

    public class GetTimeZoneAndRuleRequest {
        
        
        public GetTimeZoneAndRuleResponse execute() throws SonosException {
            Action action = service.getAction("GetTimeZoneAndRule");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetTimeZoneAndRuleResponse response = new GetTimeZoneAndRuleResponse();
            
            response.index = ServiceHelper._i4(invocation, "Index");

            response.autoAdjustDst = ServiceHelper._boolean(invocation, "AutoAdjustDst");

            response.currentTimeZone = ServiceHelper._string(invocation, "CurrentTimeZone");

            return response;

        }
    }

    public class GetTimeZoneRuleRequest {
        
        private int index;

        
        public GetTimeZoneRuleRequest index(int index) {
            this.index = index;
            return this;
        }

        public GetTimeZoneRuleResponse execute() throws SonosException {
            Action action = service.getAction("GetTimeZoneRule");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("Index", this.index);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetTimeZoneRuleResponse response = new GetTimeZoneRuleResponse();
            
            response.timeZone = ServiceHelper._string(invocation, "TimeZone");

            return response;

        }
    }

    public class SetTimeServerRequest {
        
        private String desiredTimeServer;

        
        public SetTimeServerRequest desiredTimeServer(String desiredTimeServer) {
            this.desiredTimeServer = desiredTimeServer;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetTimeServer");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("DesiredTimeServer", this.desiredTimeServer);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetTimeServerRequest {
        
        
        public GetTimeServerResponse execute() throws SonosException {
            Action action = service.getAction("GetTimeServer");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetTimeServerResponse response = new GetTimeServerResponse();
            
            response.currentTimeServer = ServiceHelper._string(invocation, "CurrentTimeServer");

            return response;

        }
    }

    public class SetTimeNowRequest {
        
        private String desiredTime;

        private String timeZoneForDesiredTime;

        
        public SetTimeNowRequest desiredTime(String desiredTime) {
            this.desiredTime = desiredTime;
            return this;
        }

        public SetTimeNowRequest timeZoneForDesiredTime(String timeZoneForDesiredTime) {
            this.timeZoneForDesiredTime = timeZoneForDesiredTime;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetTimeNow");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("DesiredTime", this.desiredTime);

            invocation.setInput("TimeZoneForDesiredTime", this.timeZoneForDesiredTime);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetHouseholdTimeAtStampRequest {
        
        private String timeStamp;

        
        public GetHouseholdTimeAtStampRequest timeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public GetHouseholdTimeAtStampResponse execute() throws SonosException {
            Action action = service.getAction("GetHouseholdTimeAtStamp");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("TimeStamp", this.timeStamp);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetHouseholdTimeAtStampResponse response = new GetHouseholdTimeAtStampResponse();
            
            response.householdUTCTime = ServiceHelper._string(invocation, "HouseholdUTCTime");

            return response;

        }
    }

    public class GetTimeNowRequest {
        
        
        public GetTimeNowResponse execute() throws SonosException {
            Action action = service.getAction("GetTimeNow");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetTimeNowResponse response = new GetTimeNowResponse();
            
            response.currentUTCTime = ServiceHelper._string(invocation, "CurrentUTCTime");

            response.currentLocalTime = ServiceHelper._string(invocation, "CurrentLocalTime");

            response.currentTimeZone = ServiceHelper._string(invocation, "CurrentTimeZone");

            response.currentTimeGeneration = ServiceHelper._ui4(invocation, "CurrentTimeGeneration");

            return response;

        }
    }

    public class CreateAlarmRequest {
        
        private String startLocalTime;

        private String duration;

        private Recurrence recurrence;

        private boolean enabled;

        private String roomUUID;

        private String programURI;

        private String programMetaData;

        private AlarmPlayMode playMode;

        private int volume;

        private boolean includeLinkedZones;

        
        public CreateAlarmRequest startLocalTime(String startLocalTime) {
            this.startLocalTime = startLocalTime;
            return this;
        }

        public CreateAlarmRequest duration(String duration) {
            this.duration = duration;
            return this;
        }

        public CreateAlarmRequest recurrence(Recurrence recurrence) {
            this.recurrence = recurrence;
            return this;
        }

        public CreateAlarmRequest enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public CreateAlarmRequest roomUUID(String roomUUID) {
            this.roomUUID = roomUUID;
            return this;
        }

        public CreateAlarmRequest programURI(String programURI) {
            this.programURI = programURI;
            return this;
        }

        public CreateAlarmRequest programMetaData(String programMetaData) {
            this.programMetaData = programMetaData;
            return this;
        }

        public CreateAlarmRequest playMode(AlarmPlayMode playMode) {
            this.playMode = playMode;
            return this;
        }

        public CreateAlarmRequest volume(int volume) {
            this.volume = volume;
            return this;
        }

        public CreateAlarmRequest includeLinkedZones(boolean includeLinkedZones) {
            this.includeLinkedZones = includeLinkedZones;
            return this;
        }

        public CreateAlarmResponse execute() throws SonosException {
            Action action = service.getAction("CreateAlarm");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("StartLocalTime", this.startLocalTime);

            invocation.setInput("Duration", this.duration);

            invocation.setInput("Recurrence", this.recurrence);

            invocation.setInput("Enabled", this.enabled);

            invocation.setInput("RoomUUID", this.roomUUID);

            invocation.setInput("ProgramURI", this.programURI);

            invocation.setInput("ProgramMetaData", this.programMetaData);

            invocation.setInput("PlayMode", this.playMode);

            invocation.setInput("Volume", new UnsignedIntegerTwoBytes(this.volume));

            invocation.setInput("IncludeLinkedZones", this.includeLinkedZones);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            CreateAlarmResponse response = new CreateAlarmResponse();
            
            response.assignedID = ServiceHelper._ui4(invocation, "AssignedID");

            return response;

        }
    }

    public class UpdateAlarmRequest {
        
        private int iD;

        private String startLocalTime;

        private String duration;

        private Recurrence recurrence;

        private boolean enabled;

        private String roomUUID;

        private String programURI;

        private String programMetaData;

        private AlarmPlayMode playMode;

        private int volume;

        private boolean includeLinkedZones;

        
        public UpdateAlarmRequest iD(int iD) {
            this.iD = iD;
            return this;
        }

        public UpdateAlarmRequest startLocalTime(String startLocalTime) {
            this.startLocalTime = startLocalTime;
            return this;
        }

        public UpdateAlarmRequest duration(String duration) {
            this.duration = duration;
            return this;
        }

        public UpdateAlarmRequest recurrence(Recurrence recurrence) {
            this.recurrence = recurrence;
            return this;
        }

        public UpdateAlarmRequest enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public UpdateAlarmRequest roomUUID(String roomUUID) {
            this.roomUUID = roomUUID;
            return this;
        }

        public UpdateAlarmRequest programURI(String programURI) {
            this.programURI = programURI;
            return this;
        }

        public UpdateAlarmRequest programMetaData(String programMetaData) {
            this.programMetaData = programMetaData;
            return this;
        }

        public UpdateAlarmRequest playMode(AlarmPlayMode playMode) {
            this.playMode = playMode;
            return this;
        }

        public UpdateAlarmRequest volume(int volume) {
            this.volume = volume;
            return this;
        }

        public UpdateAlarmRequest includeLinkedZones(boolean includeLinkedZones) {
            this.includeLinkedZones = includeLinkedZones;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("UpdateAlarm");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("ID", new UnsignedIntegerFourBytes(this.iD));

            invocation.setInput("StartLocalTime", this.startLocalTime);

            invocation.setInput("Duration", this.duration);

            invocation.setInput("Recurrence", this.recurrence);

            invocation.setInput("Enabled", this.enabled);

            invocation.setInput("RoomUUID", this.roomUUID);

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

    public class DestroyAlarmRequest {
        
        private int iD;

        
        public DestroyAlarmRequest iD(int iD) {
            this.iD = iD;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("DestroyAlarm");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("ID", new UnsignedIntegerFourBytes(this.iD));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class ListAlarmsRequest {
        
        
        public ListAlarmsResponse execute() throws SonosException {
            Action action = service.getAction("ListAlarms");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            ListAlarmsResponse response = new ListAlarmsResponse();
            
            response.currentAlarmList = ServiceHelper._string(invocation, "CurrentAlarmList");

            response.currentAlarmListVersion = ServiceHelper._string(invocation, "CurrentAlarmListVersion");

            return response;

        }
    }

    public class SetDailyIndexRefreshTimeRequest {
        
        private String desiredDailyIndexRefreshTime;

        
        public SetDailyIndexRefreshTimeRequest desiredDailyIndexRefreshTime(String desiredDailyIndexRefreshTime) {
            this.desiredDailyIndexRefreshTime = desiredDailyIndexRefreshTime;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetDailyIndexRefreshTime");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("DesiredDailyIndexRefreshTime", this.desiredDailyIndexRefreshTime);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetDailyIndexRefreshTimeRequest {
        
        
        public GetDailyIndexRefreshTimeResponse execute() throws SonosException {
            Action action = service.getAction("GetDailyIndexRefreshTime");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetDailyIndexRefreshTimeResponse response = new GetDailyIndexRefreshTimeResponse();
            
            response.currentDailyIndexRefreshTime = ServiceHelper._string(invocation, "CurrentDailyIndexRefreshTime");

            return response;

        }
    }

    
    public class GetFormatResponse {
        
        private String currentTimeFormat;

        private String currentDateFormat;

        
        public String currentTimeFormat() {
            return currentTimeFormat;
        }

        public String currentDateFormat() {
            return currentDateFormat;
        }

    }

    public class GetTimeZoneResponse {
        
        private int index;

        private boolean autoAdjustDst;

        
        public int index() {
            return index;
        }

        public boolean autoAdjustDst() {
            return autoAdjustDst;
        }

    }

    public class GetTimeZoneAndRuleResponse {
        
        private int index;

        private boolean autoAdjustDst;

        private String currentTimeZone;

        
        public int index() {
            return index;
        }

        public boolean autoAdjustDst() {
            return autoAdjustDst;
        }

        public String currentTimeZone() {
            return currentTimeZone;
        }

    }

    public class GetTimeZoneRuleResponse {
        
        private String timeZone;

        
        public String timeZone() {
            return timeZone;
        }

    }

    public class GetTimeServerResponse {
        
        private String currentTimeServer;

        
        public String currentTimeServer() {
            return currentTimeServer;
        }

    }

    public class GetHouseholdTimeAtStampResponse {
        
        private String householdUTCTime;

        
        public String householdUTCTime() {
            return householdUTCTime;
        }

    }

    public class GetTimeNowResponse {
        
        private String currentUTCTime;

        private String currentLocalTime;

        private String currentTimeZone;

        private int currentTimeGeneration;

        
        public String currentUTCTime() {
            return currentUTCTime;
        }

        public String currentLocalTime() {
            return currentLocalTime;
        }

        public String currentTimeZone() {
            return currentTimeZone;
        }

        public int currentTimeGeneration() {
            return currentTimeGeneration;
        }

    }

    public class CreateAlarmResponse {
        
        private int assignedID;

        
        public int assignedID() {
            return assignedID;
        }

    }

    public class ListAlarmsResponse {
        
        private String currentAlarmList;

        private String currentAlarmListVersion;

        
        public String currentAlarmList() {
            return currentAlarmList;
        }

        public String currentAlarmListVersion() {
            return currentAlarmListVersion;
        }

    }

    public class GetDailyIndexRefreshTimeResponse {
        
        private String currentDailyIndexRefreshTime;

        
        public String currentDailyIndexRefreshTime() {
            return currentDailyIndexRefreshTime;
        }

    }

}
