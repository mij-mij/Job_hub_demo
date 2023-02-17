package com.noname.jobhub.businessrules.clientapplication;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class ClientApplication {
    private Integer id;

    @Size(min = 2, max = 100, message = "A kliens app nevének legalább 2 és maximum 100 karakter hosszúnak kell lennie")
    private String name;
    @Size(min = 6, max = 50, message = "Egy valós e-mail címnek  legalább 6 (x@x.xx) és maximum 50 karakter hosszúnak kell lennie")
    @Email(regexp = "^[A-Za-z0-9]+([._%+-][A-Za-z0-9]+)*@[A-Za-z0-9]+([.-][A-Za-z0-9])*\\.[A-Za-z]{2,6}$", message = "Hibás e-mail cím")
    private String emailAddress;


    private String apiKeyUUID;

    public ClientApplication(String name, String emailAddress) {
        this(null, name, emailAddress);
    }

    public ClientApplication(Integer id, String name, String emailAddress) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public ClientApplication(Integer id, String name, String emailAddress, String apiKeyUUID) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.apiKeyUUID = apiKeyUUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (this.id != null)
            throw new IllegalAccessError("Overwrite is not allowed");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getApiKeyUUID() {
        return apiKeyUUID;
    }

    public void setApiKeyUUID(String apiKeyUUID) {
        if (this.apiKeyUUID != null)
            throw new IllegalAccessError("Overwrite is not allowed");
        this.apiKeyUUID = apiKeyUUID;

    }
}
