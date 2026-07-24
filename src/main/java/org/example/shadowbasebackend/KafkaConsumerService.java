package org.example.shadowbasebackend;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "shadow-topic", groupId = "shadowbase-group")
    public void replay(String sql) {

        System.out.println("========== Traffic Replay ==========");
        System.out.println("Received SQL: " + sql);
        System.out.println("====================================");
    }
}