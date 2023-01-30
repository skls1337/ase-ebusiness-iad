package com.ase.ebuss.iad.web.controller;

import com.ase.ebuss.iad.model.RequestMessage;
import com.ase.ebuss.iad.model.TopicRequest;
import com.ase.ebuss.iad.service.Producer;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.KafkaFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    @Autowired
    private AdminClient adminClient;

    private final Producer producer;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody RequestMessage message) {
        this.producer.sendMessage(message);
    }

    @PostMapping(value = "/publish/sync")
    public void sendMessageSync(@RequestBody RequestMessage message) {
        this.producer.sendMessage(message);
    }

    @PostMapping("/topics")
    public KafkaFuture<Void> createTopic(@RequestBody TopicRequest request) {
        NewTopic newTopic = new NewTopic(request.getName(), request.getNumPartitions(), request.getReplicationFactor());
        return adminClient.createTopics(Collections.singletonList(newTopic)).all().whenComplete((voidValues, throwable) -> {
        });
    }


}