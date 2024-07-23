package org.microservices.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMqProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routingKey) {
        log.info(STR."Publishing to \{exchange} using routing key \{routingKey}. Payload: \{payload}");
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info(STR."Published to \{exchange} using routing key \{routingKey}. Payload: \{payload}");
    }
}
