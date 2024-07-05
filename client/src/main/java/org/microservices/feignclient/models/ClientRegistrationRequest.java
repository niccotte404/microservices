package org.microservices.feignclient.models;

public record ClientRegistrationRequest(
        String firstname,
        String lastname,
        String email) {
}
