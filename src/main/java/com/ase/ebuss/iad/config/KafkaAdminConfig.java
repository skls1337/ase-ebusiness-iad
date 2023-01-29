package com.ase.ebuss.iad.config;

import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaAdminConfig {
    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String hostName;
    @Bean
    public AdminClient adminClient() {
        Properties config = new Properties();
        config.put("bootstrap.servers", hostName);
        return AdminClient.create(config);
    }
}
