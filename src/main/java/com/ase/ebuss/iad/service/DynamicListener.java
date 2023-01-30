package com.ase.ebuss.iad.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class DynamicListener {
    private final Logger logger = LoggerFactory.getLogger(DynamicListener.class);
    @Autowired
    private KafkaListenerEndpointRegistry registry;

//    public void addListener(String topic) {
//        ContainerProperties containerProperties = new ContainerProperties(topic);
//        MessageListener<String, String> messageListener = record -> logger.info(String.format("#### Consumed message %s", record.value()));
//        KafkaMessageListenerContainer<String, String> kafkaMessageListenerContainer =
//                new KafkaMessageListenerContainer<>(new DefaultKafkaConsumerFactory<>(consumerConfigs()), containerProperties);
//        kafkaMessageListenerContainer.setupMessageListener(messageListener);
//        registry.registerListenerContainer(kafkaMessageListenerContainer);
//    }
}