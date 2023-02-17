package com.noname.jobhub.restapi;

import com.noname.jobhub.businessrules.clientapplication.ClientApplication;
import com.noname.jobhub.businessrules.clientapplication.ClientApplicationService;
import com.noname.jobhub.restapi.model.ClientAppRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/jobhub/admin/clientapplication")
public class ClientApplicationController {
    private static final org.apache.commons.logging.Log log =
            org.apache.commons.logging.LogFactory.getLog(ClientApplicationController.class);
    private final ClientApplicationService clientApplicationService;

    @Autowired
    public ClientApplicationController(ClientApplicationService clientApplicationService) {
        this.clientApplicationService = clientApplicationService;
    }

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createClientApplication(@RequestBody ClientAppRequest request) {
        try {
            String uuid = clientApplicationService.create(request.getApplicationName(), request.getEmailAddress());
            return ResponseEntity.ok("" + uuid);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ClientApplication>> getAllOrders() {
        try {
            List<ClientApplication> clientApplications = clientApplicationService.findAll();
            return ResponseEntity.ok(clientApplications);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

}
