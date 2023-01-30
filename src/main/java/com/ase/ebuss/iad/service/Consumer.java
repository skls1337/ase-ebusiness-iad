package com.ase.ebuss.iad.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consumeUser(String message) throws IOException {
        String transformedMessage = message.toUpperCase();
        logger.info(String.format("#### Consumed message %s", transformedMessage));
    }

    @KafkaListener(topics = "test", groupId = "group_id")
    public void consumeTest(String message) throws IOException {
        String transformedMessage = message.toUpperCase();
        logger.info(String.format("#### Consumed message %s", transformedMessage));
    }

}
