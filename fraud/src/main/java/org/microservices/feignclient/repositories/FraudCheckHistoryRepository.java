package org.microservices.feignclient.repositories;

import org.microservices.feignclient.models.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, UUID> {
}
