package org.microservices.feignclient.controllers;

import lombok.extern.slf4j.Slf4j;
import org.microservices.feignclient.models.FraudCheckResponse;
import org.microservices.feignclient.services.FraudCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {
    private final FraudCheckService fraudCheckService;
    @Autowired
    public FraudController(FraudCheckService fraudCheckService) {
        this.fraudCheckService = fraudCheckService;
    }

    @GetMapping(path = "{clientId}")
    public FraudCheckResponse isFraudster(@PathVariable("clientId") UUID clientId) {
        log.info("Fraud check request for client {}", clientId);
        return new FraudCheckResponse(fraudCheckService.isFraudulentClient(clientId));
    }
}
