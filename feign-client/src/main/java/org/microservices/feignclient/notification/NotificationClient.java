package org.microservices.feignclient.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient("notification")
public interface NotificationClient {

    @PostMapping(path = "/api/v1/notify/{clientId}")
    void notifyClient(@PathVariable("clientId") UUID clientId, @RequestParam(name = "message") String message);
}
