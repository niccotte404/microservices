package org.microservices.feignclient.services;

import org.microservices.feignclient.models.FraudCheckHistory;
import org.microservices.feignclient.repositories.FraudCheckHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
    @Autowired
    public FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
    }

    public boolean isFraudulentClient(UUID clientId) {
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder()
                .isFraudster(false)
                .clientId(clientId)
                .createdAt(LocalDateTime.now())
                .build();
        fraudCheckHistoryRepository.save(fraudCheckHistory);
        return false;
    }
}
