package org.example.shadowbasebackend;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final JdbcTemplate jdbcTemplate;

    public KafkaConsumerService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void init() {
        System.out.println("Kafka Consumer Started...");
    }

    @KafkaListener(topics = "shadow-topic", groupId = "shadow-test-group")
    public void replay(String sql) {

        System.out.println("========== Traffic Replay ==========");
        System.out.println("Received SQL: " + sql);

        try {
            jdbcTemplate.execute(sql);
            System.out.println("SQL executed successfully");
        } catch (Exception e) {
            System.out.println("SQL execution failed");
            e.printStackTrace();
        }

        System.out.println("====================================");
    }
}