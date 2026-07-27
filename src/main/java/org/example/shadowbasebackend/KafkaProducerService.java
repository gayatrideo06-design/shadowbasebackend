package org.example.shadowbasebackend;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendSql(String sql) {
        try {
            kafkaTemplate.send("shadow-topic", sql).get();
            System.out.println("Kafka message sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Kafka send failed", e);
        }
    }
}