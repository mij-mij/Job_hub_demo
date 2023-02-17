package com.noname.jobhub.h2storage.clientapplication;

import org.springframework.data.repository.CrudRepository;

public interface ClientApplicationH2Repository extends CrudRepository<PersistentClientApplication, Integer> {
    PersistentClientApplication findByApiKeyUUID(String apiKeyUUID);

    PersistentClientApplication findByEmailAddress(String emailAddress);
}
