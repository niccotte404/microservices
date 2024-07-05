package org.microservices.feignclient.fraud;

import org.microservices.feignclient.models.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient("fraud")
public interface FraudClient {
    @GetMapping(path = "api/v1/fraud-check/{clientId}")
    FraudCheckResponse isFraudster(@PathVariable("clientId") UUID clientId);
}
