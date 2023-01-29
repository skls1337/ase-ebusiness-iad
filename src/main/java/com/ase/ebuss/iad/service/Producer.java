package com.ase.ebuss.iad.service;

import com.ase.ebuss.iad.model.RequestMessage;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

@Service
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(RequestMessage message) {
        logger.info(String.format("#### Producing message %s", message.getMessage()));
        try {
            kafkaTemplate.executeInTransaction(operations -> {
                operations.send(message.getTopicName(), message.getMessage());
                return null;
            });
        } catch (Exception e) {
            kafkaTemplate.executeInTransaction(operations -> {
                operations.send(message.getTopicName(), message.getMessage());
                return null;
            });
        }
    }

    public void sendMessageSync(RequestMessage message) throws ExecutionException, InterruptedException {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message.getTopicName(), message.getMessage());
        future.get();
    }

}
