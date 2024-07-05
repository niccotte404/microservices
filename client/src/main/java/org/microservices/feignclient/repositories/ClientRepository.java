package org.microservices.feignclient.repositories;

import org.microservices.feignclient.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

}
