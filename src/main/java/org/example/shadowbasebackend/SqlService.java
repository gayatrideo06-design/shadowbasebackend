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
            jdbcTemplate.execute(sql);

            producer.sendSql(sql);

            return "Migration Successful";
        } catch (Exception e) {
            e.printStackTrace();
            return "Migration Failed: " + e.getMessage();
        }
    }
}


