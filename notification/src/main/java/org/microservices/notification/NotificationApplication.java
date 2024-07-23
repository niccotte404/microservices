package org.microservices.notification;

import org.microservices.amqp.RabbitMqProducer;
import org.microservices.notification.amqp.NotificationAmqpConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "org.microservices.notification")
@ComponentScan(basePackages = {"org.microservices.amqp", "org.microservices.notification"})
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RabbitMqProducer rabbitMqProducer, NotificationAmqpConfig notificationAmqpConfig) {
        return args -> {
            rabbitMqProducer.publish("foo", notificationAmqpConfig.getInternalExchange(), notificationAmqpConfig.getInternalNotificationRoutingKey());
        };
    }
}