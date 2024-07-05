package org.microservices.feignclient.services;

import org.microservices.feignclient.fraud.FraudClient;
import org.microservices.feignclient.models.ClientRegistrationRequest;
import org.microservices.feignclient.models.Client;
import org.microservices.feignclient.models.FraudCheckResponse;
import org.microservices.feignclient.notification.NotificationClient;
import org.microservices.feignclient.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    @Autowired
    public ClientService(ClientRepository clientRepository, FraudClient fraudClient, NotificationClient notificationClient) {
        this.clientRepository = clientRepository;
        this.fraudClient = fraudClient;
        this.notificationClient = notificationClient;
    }

    public void register(ClientRegistrationRequest request) {
        Client client = Client.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();

        clientRepository.saveAndFlush(client);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(client.getId());
        if (fraudCheckResponse.isFraudster())
            throw new IllegalStateException("Fraudster!");

        notificationClient.notifyClient(client.getId(), "Welcome to our service!");
    }
}
