package com.citi.ewi.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DataService {

//    @Value("${kafka.topic.name}")
//    private String topicName;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public DataService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage( Object message) {
        kafkaTemplate.send("my-topic", message);
    }
}
