package com.noname.jobhub.restapi.model;

public class ClientAppRequest {
    private String applicationName;
    private String emailAddress;

    public ClientAppRequest(String applicationName, String emailAddress) {
        this.applicationName = applicationName;
        this.emailAddress = emailAddress;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
