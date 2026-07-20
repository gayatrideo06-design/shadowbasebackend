package org.example.shadowbasebackend;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SqlService {

    private final JdbcTemplate jdbcTemplate;

    public SqlService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Object execute(String sql) {

        try {

            if (sql.trim().toLowerCase().startsWith("select")) {
                List<Map<String, Object>> result =
                        jdbcTemplate.queryForList(sql);

                return result;
            }

            jdbcTemplate.execute(sql);
            return "Migration Successful";

        } catch (Exception e) {
            e.printStackTrace();
            return "Migration Failed: " + e.getMessage();
        }
    }
}