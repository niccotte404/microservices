package org.microservices.notification.controllers;

import lombok.extern.slf4j.Slf4j;
import org.microservices.notification.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/api/v1/notify")
public class NotificationController {

    private final NotificationService notificationService;
    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping(path = "{clientId}")
    public ResponseEntity<String> notifyClient(
            @PathVariable("clientId") UUID clientId,
            @RequestParam(name = "message") String message) {
        log.info(STR."Notify client: \{clientId} with message: \"\{message}\"");
        notificationService.notifyClient(clientId, message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
