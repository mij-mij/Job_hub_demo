package com.noname.jobhub.h2storage.clientapplication;

import com.noname.jobhub.businessrules.clientapplication.ClientApplication;
import com.noname.jobhub.businessrules.clientapplication.ClientApplicationStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class ClientApplicationH2Storage implements ClientApplicationStorage {
    private ClientApplicationH2Repository clientApplicationH2Repository;
    private ClientApplicationMapper mapper;

    @Autowired
    public ClientApplicationH2Storage(ClientApplicationH2Repository clientApplicationH2Repository, ClientApplicationMapper clientApplicationMapper) {
        this.clientApplicationH2Repository = clientApplicationH2Repository;
        this.mapper = clientApplicationMapper;
    }

    public ClientApplication load(Integer id) {
        return mapper.fromEntity(clientApplicationH2Repository.findById(id).orElseThrow(() -> new IllegalStateException("ClientApplication not found")));
    }

    public void save(ClientApplication clientApplication) {
        PersistentClientApplication persistentClientApplication = clientApplicationH2Repository.save(mapper.fromClientApplication(clientApplication));
        if (clientApplication.getId() == null)
            clientApplication.setId(persistentClientApplication.getId());
    }

    public boolean isUniqueEmail(String emailAddress) {
        return clientApplicationH2Repository.findByEmailAddress(emailAddress) == null;
    }


    public ClientApplication findByUUID(String uUID) {
        return mapper.fromEntity(clientApplicationH2Repository.findByApiKeyUUID(uUID));
    }

    public List<ClientApplication> findAll() {
        return mapper.fromEntities(clientApplicationH2Repository.findAll());
    }
}
