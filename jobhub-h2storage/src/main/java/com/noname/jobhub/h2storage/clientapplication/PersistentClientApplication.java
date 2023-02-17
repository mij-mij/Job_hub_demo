package com.noname.jobhub.h2storage.clientapplication;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class PersistentClientApplication implements Serializable {
    @Id
    private Integer id;
    private String name;
    private String emailAddress;
    private String apiKeyUUID;

    public PersistentClientApplication() {
    }

    public PersistentClientApplication(Integer id, String name, String emailAddress, String apiKeyUUID) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.apiKeyUUID = apiKeyUUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getApiKeyUUID() {
        return apiKeyUUID;
    }

    public void setApiKeyUUID(String apiKeyUUID) {
        this.apiKeyUUID = apiKeyUUID;
    }
}
