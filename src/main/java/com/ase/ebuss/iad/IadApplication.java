package com.ase.ebuss.iad;

import org.apache.kafka.clients.admin.AdminClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
public class IadApplication {

    public static void main(String[] args) {
        SpringApplication.run(IadApplication.class, args);
    }
}
