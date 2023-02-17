package com.noname.jobhub.h2storage.clientapplication;

import com.noname.jobhub.businessrules.clientapplication.ClientApplication;

import java.util.ArrayList;
import java.util.List;

public class ClientApplicationMapper {

    public PersistentClientApplication fromClientApplication(ClientApplication clientApplication) {
        return new PersistentClientApplication(clientApplication.getId(), clientApplication.getName(), clientApplication.getEmailAddress(), clientApplication.getApiKeyUUID());
    }

    public ClientApplication fromEntity(PersistentClientApplication persistentClientApplication) {
        return new ClientApplication(persistentClientApplication.getId(), persistentClientApplication.getName(), persistentClientApplication.getEmailAddress(), persistentClientApplication.getApiKeyUUID());
    }

    public List<PersistentClientApplication> fromClientApplications(Iterable<ClientApplication> clientApplications) {
        ArrayList<PersistentClientApplication> ret = new ArrayList<>();
        clientApplications.forEach(item -> ret.add(fromClientApplication(item)));
        return ret;
    }

    public List<ClientApplication> fromEntities(Iterable<PersistentClientApplication> persistentClientApplications) {
        ArrayList<ClientApplication> ret = new ArrayList<>();
        persistentClientApplications.forEach(item -> ret.add(fromEntity(item)));
        return ret;
    }


}
