package com.ase.ebuss.iad.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

public class ErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

    @KafkaListener(topics = "${kafka.topic.error}")
    public void handleError(@Payload ConsumerRecord<?, ?> record,
                            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        LOGGER.error("Error in topic '{}' with message: {}", topic, record.value());
    }

}
