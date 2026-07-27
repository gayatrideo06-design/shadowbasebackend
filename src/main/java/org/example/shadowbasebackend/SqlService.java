package org.example.shadowbasebackend;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SqlService {

    private final JdbcTemplate jdbcTemplate;
    private final KafkaProducerService producer;

    public SqlService(JdbcTemplate jdbcTemplate,
                      KafkaProducerService producer) {
        this.jdbcTemplate = jdbcTemplate;
        this.producer = producer;
    }

    public String execute(String sql) {
        try {
            System.out.println("Sending SQL to Kafka...");
            producer.sendSql(sql);
            System.out.println("SQL sent to Kafka.");


            return "SQL sent to Kafka.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Kafka send failed: " + e.getMessage();
        }
    }
    }




