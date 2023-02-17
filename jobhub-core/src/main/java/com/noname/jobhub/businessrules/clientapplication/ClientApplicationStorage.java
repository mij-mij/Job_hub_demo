package com.noname.jobhub.businessrules.clientapplication;

import java.util.List;

public interface ClientApplicationStorage {
    ClientApplication load(Integer id);

    void save(ClientApplication clientApplication);

    boolean isUniqueEmail(String emailAddress);

    ClientApplication findByUUID(String uUID);

    List<ClientApplication> findAll();
}
