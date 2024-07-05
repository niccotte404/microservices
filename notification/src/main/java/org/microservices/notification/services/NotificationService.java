package org.microservices.notification.services;

import org.microservices.notification.models.Notification;
import org.microservices.notification.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void notifyClient(UUID clientId, String message) {
        Notification notification = Notification.builder()
                .clientId(clientId)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
        notificationRepository.save(notification);
    }
}
