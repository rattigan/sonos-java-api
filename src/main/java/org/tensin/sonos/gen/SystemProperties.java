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


public class SystemProperties {
    private Service service;
    private UpnpService upnpService;

    public SystemProperties(UpnpService upnpService, RemoteDevice device) {
        this.upnpService = upnpService;
        this.service = RemoteDeviceHelper.findService(device, "urn:upnp-org:serviceId:SystemProperties");
    }
    
    
    public SetStringRequest setString() {
        return new SetStringRequest();
    }

    public SetStringXRequest setStringX() {
        return new SetStringXRequest();
    }

    public GetStringRequest getString() {
        return new GetStringRequest();
    }

    public GetStringXRequest getStringX() {
        return new GetStringXRequest();
    }

    public RemoveRequest remove() {
        return new RemoveRequest();
    }

    public RemoveXRequest removeX() {
        return new RemoveXRequest();
    }

    public GetWebCodeRequest getWebCode() {
        return new GetWebCodeRequest();
    }

    public ProvisionTrialAccountRequest provisionTrialAccount() {
        return new ProvisionTrialAccountRequest();
    }

    public ProvisionCredentialedTrialAccountXRequest provisionCredentialedTrialAccountX() {
        return new ProvisionCredentialedTrialAccountXRequest();
    }

    public MigrateTrialAccountXRequest migrateTrialAccountX() {
        return new MigrateTrialAccountXRequest();
    }

    public AddAccountXRequest addAccountX() {
        return new AddAccountXRequest();
    }

    public AddAccountWithCredentialsXRequest addAccountWithCredentialsX() {
        return new AddAccountWithCredentialsXRequest();
    }

    public RemoveAccountRequest removeAccount() {
        return new RemoveAccountRequest();
    }

    public EditAccountPasswordXRequest editAccountPasswordX() {
        return new EditAccountPasswordXRequest();
    }

    public RefreshAccountCredentialsXRequest refreshAccountCredentialsX() {
        return new RefreshAccountCredentialsXRequest();
    }

    public EditAccountMdRequest editAccountMd() {
        return new EditAccountMdRequest();
    }

    public DoPostUpdateTasksRequest doPostUpdateTasks() {
        return new DoPostUpdateTasksRequest();
    }

    public ResetThirdPartyCredentialsRequest resetThirdPartyCredentials() {
        return new ResetThirdPartyCredentialsRequest();
    }

    public EnableRDMRequest enableRDM() {
        return new EnableRDMRequest();
    }

    public GetRDMRequest getRDM() {
        return new GetRDMRequest();
    }

    
    public class SetStringRequest {
        
        private String variableName;

        private String stringValue;

        
        public SetStringRequest variableName(String variableName) {
            this.variableName = variableName;
            return this;
        }

        public SetStringRequest stringValue(String stringValue) {
            this.stringValue = stringValue;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetString");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("VariableName", this.variableName);

            invocation.setInput("StringValue", this.stringValue);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class SetStringXRequest {
        
        private String variableName;

        private String stringValue;

        
        public SetStringXRequest variableName(String variableName) {
            this.variableName = variableName;
            return this;
        }

        public SetStringXRequest stringValue(String stringValue) {
            this.stringValue = stringValue;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("SetStringX");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("VariableName", this.variableName);

            invocation.setInput("StringValue", this.stringValue);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetStringRequest {
        
        private String variableName;

        
        public GetStringRequest variableName(String variableName) {
            this.variableName = variableName;
            return this;
        }

        public GetStringResponse execute() throws SonosException {
            Action action = service.getAction("GetString");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("VariableName", this.variableName);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetStringResponse response = new GetStringResponse();
            
            response.stringValue = ServiceHelper._string(invocation, "StringValue");

            return response;

        }
    }

    public class GetStringXRequest {
        
        private String variableName;

        
        public GetStringXRequest variableName(String variableName) {
            this.variableName = variableName;
            return this;
        }

        public GetStringXResponse execute() throws SonosException {
            Action action = service.getAction("GetStringX");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("VariableName", this.variableName);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetStringXResponse response = new GetStringXResponse();
            
            response.stringValue = ServiceHelper._string(invocation, "StringValue");

            return response;

        }
    }

    public class RemoveRequest {
        
        private String variableName;

        
        public RemoveRequest variableName(String variableName) {
            this.variableName = variableName;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("Remove");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("VariableName", this.variableName);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class RemoveXRequest {
        
        private String variableName;

        
        public RemoveXRequest variableName(String variableName) {
            this.variableName = variableName;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("RemoveX");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("VariableName", this.variableName);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetWebCodeRequest {
        
        private int accountType;

        
        public GetWebCodeRequest accountType(int accountType) {
            this.accountType = accountType;
            return this;
        }

        public GetWebCodeResponse execute() throws SonosException {
            Action action = service.getAction("GetWebCode");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("AccountType", new UnsignedIntegerFourBytes(this.accountType));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetWebCodeResponse response = new GetWebCodeResponse();
            
            response.webCode = ServiceHelper._string(invocation, "WebCode");

            return response;

        }
    }

    public class ProvisionTrialAccountRequest {
        
        private int accountType;

        
        public ProvisionTrialAccountRequest accountType(int accountType) {
            this.accountType = accountType;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("ProvisionTrialAccount");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("AccountType", new UnsignedIntegerFourBytes(this.accountType));

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class ProvisionCredentialedTrialAccountXRequest {
        
        private int accountType;

        private String accountID;

        private String accountPassword;

        
        public ProvisionCredentialedTrialAccountXRequest accountType(int accountType) {
            this.accountType = accountType;
            return this;
        }

        public ProvisionCredentialedTrialAccountXRequest accountID(String accountID) {
            this.accountID = accountID;
            return this;
        }

        public ProvisionCredentialedTrialAccountXRequest accountPassword(String accountPassword) {
            this.accountPassword = accountPassword;
            return this;
        }

        public ProvisionCredentialedTrialAccountXResponse execute() throws SonosException {
            Action action = service.getAction("ProvisionCredentialedTrialAccountX");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("AccountType", new UnsignedIntegerFourBytes(this.accountType));

            invocation.setInput("AccountID", this.accountID);

            invocation.setInput("AccountPassword", this.accountPassword);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            ProvisionCredentialedTrialAccountXResponse response = new ProvisionCredentialedTrialAccountXResponse();
            
            response.isExpired = ServiceHelper._boolean(invocation, "IsExpired");

            return response;

        }
    }

    public class MigrateTrialAccountXRequest {
        
        private int targetAccountType;

        private String targetAccountID;

        private String targetAccountPassword;

        
        public MigrateTrialAccountXRequest targetAccountType(int targetAccountType) {
            this.targetAccountType = targetAccountType;
            return this;
        }

        public MigrateTrialAccountXRequest targetAccountID(String targetAccountID) {
            this.targetAccountID = targetAccountID;
            return this;
        }

        public MigrateTrialAccountXRequest targetAccountPassword(String targetAccountPassword) {
            this.targetAccountPassword = targetAccountPassword;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("MigrateTrialAccountX");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("TargetAccountType", new UnsignedIntegerFourBytes(this.targetAccountType));

            invocation.setInput("TargetAccountID", this.targetAccountID);

            invocation.setInput("TargetAccountPassword", this.targetAccountPassword);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class AddAccountXRequest {
        
        private int accountType;

        private String accountID;

        private String accountPassword;

        
        public AddAccountXRequest accountType(int accountType) {
            this.accountType = accountType;
            return this;
        }

        public AddAccountXRequest accountID(String accountID) {
            this.accountID = accountID;
            return this;
        }

        public AddAccountXRequest accountPassword(String accountPassword) {
            this.accountPassword = accountPassword;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("AddAccountX");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("AccountType", new UnsignedIntegerFourBytes(this.accountType));

            invocation.setInput("AccountID", this.accountID);

            invocation.setInput("AccountPassword", this.accountPassword);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class AddAccountWithCredentialsXRequest {
        
        private int accountType;

        private String accountToken;

        private String accountKey;

        
        public AddAccountWithCredentialsXRequest accountType(int accountType) {
            this.accountType = accountType;
            return this;
        }

        public AddAccountWithCredentialsXRequest accountToken(String accountToken) {
            this.accountToken = accountToken;
            return this;
        }

        public AddAccountWithCredentialsXRequest accountKey(String accountKey) {
            this.accountKey = accountKey;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("AddAccountWithCredentialsX");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("AccountType", new UnsignedIntegerFourBytes(this.accountType));

            invocation.setInput("AccountToken", this.accountToken);

            invocation.setInput("AccountKey", this.accountKey);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class RemoveAccountRequest {
        
        private int accountType;

        private String accountID;

        
        public RemoveAccountRequest accountType(int accountType) {
            this.accountType = accountType;
            return this;
        }

        public RemoveAccountRequest accountID(String accountID) {
            this.accountID = accountID;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("RemoveAccount");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("AccountType", new UnsignedIntegerFourBytes(this.accountType));

            invocation.setInput("AccountID", this.accountID);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class EditAccountPasswordXRequest {
        
        private int accountType;

        private String accountID;

        private String newAccountPassword;

        
        public EditAccountPasswordXRequest accountType(int accountType) {
            this.accountType = accountType;
            return this;
        }

        public EditAccountPasswordXRequest accountID(String accountID) {
            this.accountID = accountID;
            return this;
        }

        public EditAccountPasswordXRequest newAccountPassword(String newAccountPassword) {
            this.newAccountPassword = newAccountPassword;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("EditAccountPasswordX");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("AccountType", new UnsignedIntegerFourBytes(this.accountType));

            invocation.setInput("AccountID", this.accountID);

            invocation.setInput("NewAccountPassword", this.newAccountPassword);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class RefreshAccountCredentialsXRequest {
        
        private int accountType;

        private String accountToken;

        private String accountKey;

        
        public RefreshAccountCredentialsXRequest accountType(int accountType) {
            this.accountType = accountType;
            return this;
        }

        public RefreshAccountCredentialsXRequest accountToken(String accountToken) {
            this.accountToken = accountToken;
            return this;
        }

        public RefreshAccountCredentialsXRequest accountKey(String accountKey) {
            this.accountKey = accountKey;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("RefreshAccountCredentialsX");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("AccountType", new UnsignedIntegerFourBytes(this.accountType));

            invocation.setInput("AccountToken", this.accountToken);

            invocation.setInput("AccountKey", this.accountKey);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class EditAccountMdRequest {
        
        private int accountType;

        private String accountID;

        private String newAccountMd;

        
        public EditAccountMdRequest accountType(int accountType) {
            this.accountType = accountType;
            return this;
        }

        public EditAccountMdRequest accountID(String accountID) {
            this.accountID = accountID;
            return this;
        }

        public EditAccountMdRequest newAccountMd(String newAccountMd) {
            this.newAccountMd = newAccountMd;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("EditAccountMd");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("AccountType", new UnsignedIntegerFourBytes(this.accountType));

            invocation.setInput("AccountID", this.accountID);

            invocation.setInput("NewAccountMd", this.newAccountMd);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class DoPostUpdateTasksRequest {
        
        
        public void execute() throws SonosException {
            Action action = service.getAction("DoPostUpdateTasks");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class ResetThirdPartyCredentialsRequest {
        
        
        public void execute() throws SonosException {
            Action action = service.getAction("ResetThirdPartyCredentials");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class EnableRDMRequest {
        
        private boolean rDMValue;

        
        public EnableRDMRequest rDMValue(boolean rDMValue) {
            this.rDMValue = rDMValue;
            return this;
        }

        public void execute() throws SonosException {
            Action action = service.getAction("EnableRDM");
            ActionInvocation invocation = new ActionInvocation(action);
            
            invocation.setInput("RDMValue", this.rDMValue);

            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
        }
    }

    public class GetRDMRequest {
        
        
        public GetRDMResponse execute() throws SonosException {
            Action action = service.getAction("GetRDM");
            ActionInvocation invocation = new ActionInvocation(action);
            
            new ActionCallback.Default(invocation, upnpService.getControlPoint()).run();
            if (invocation.getFailure() != null)
                throw new SonosException(invocation.getFailure().getErrorCode(), invocation.getFailure());
            
            GetRDMResponse response = new GetRDMResponse();
            
            response.rDMValue = ServiceHelper._boolean(invocation, "RDMValue");

            return response;

        }
    }

    
    public class GetStringResponse {
        
        private String stringValue;

        
        public String stringValue() {
            return stringValue;
        }

    }

    public class GetStringXResponse {
        
        private String stringValue;

        
        public String stringValue() {
            return stringValue;
        }

    }

    public class GetWebCodeResponse {
        
        private String webCode;

        
        public String webCode() {
            return webCode;
        }

    }

    public class ProvisionCredentialedTrialAccountXResponse {
        
        private boolean isExpired;

        
        public boolean isExpired() {
            return isExpired;
        }

    }

    public class GetRDMResponse {
        
        private boolean rDMValue;

        
        public boolean rDMValue() {
            return rDMValue;
        }

    }

}
