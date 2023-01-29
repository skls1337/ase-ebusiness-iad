package com.ase.ebuss.iad.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consumeUser(String message) throws IOException {
        logger.info(String.format("#### Consumed message %s", message));
    }

    @KafkaListener(topics = "danene", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### Consumed message %s", message));
    }


}