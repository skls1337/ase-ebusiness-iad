package com.ase.ebuss.iad.utils;

public class KafkaConstants {
    public enum KafkaTopics {
        USER("users");

        private String name;

        KafkaTopics(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
