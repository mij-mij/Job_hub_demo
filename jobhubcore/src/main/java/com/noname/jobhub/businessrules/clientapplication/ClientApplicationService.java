package com.noname.jobhub.businessrules.clientapplication;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@Slf4j
public class ClientApplicationService {
    static final String EMAIL_ALREADY_USED = "This email address (%s) is already used.";
    private final ClientApplicationStorage clientApplicationStorage;

    public ClientApplicationService(ClientApplicationStorage clientApplicationStorage) {
        this.clientApplicationStorage = clientApplicationStorage;
    }

    private void generateUUID(ClientApplication clientApplication) {
        UUID uuid = UUID.nameUUIDFromBytes((clientApplication.getName() + clientApplication.getEmailAddress()).getBytes());
        String apiKey = uuid.toString();
        clientApplication.setApiKeyUUID(apiKey);
    }

    public String create(String name, String emailAddress) {
        String uuid;
        if (clientApplicationStorage.isUniqueEmail(emailAddress)) {
            ClientApplication clientApplication = new ClientApplication(name, emailAddress);
            generateUUID(clientApplication);
            clientApplicationStorage.save(clientApplication);
            uuid = clientApplication.getApiKeyUUID();
        } else {
            String message = String.format(EMAIL_ALREADY_USED, emailAddress);
            log.info(message);
            throw new IllegalArgumentException(message);
        }
        return uuid;
    }

    public ClientApplication load(Integer id) {
        return clientApplicationStorage.load(id);
    }

    public ClientApplication findByUUID(String uuid) {
        return clientApplicationStorage.findByUUID(uuid);
    }

    public List<ClientApplication> findAll() {
        return clientApplicationStorage.findAll();
    }
}
