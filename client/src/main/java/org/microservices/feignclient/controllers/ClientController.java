package org.microservices.feignclient.controllers;

import lombok.extern.slf4j.Slf4j;
import org.microservices.feignclient.models.ClientRegistrationRequest;
import org.microservices.feignclient.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/clients")
public class ClientController {
    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public void registerClient(@RequestBody ClientRegistrationRequest clientRegistrationRequest) {
        log.info("new client registration {}", clientRegistrationRequest);
        clientService.register(clientRegistrationRequest);
    }
}
