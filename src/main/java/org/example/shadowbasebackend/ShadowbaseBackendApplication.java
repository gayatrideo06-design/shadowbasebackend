package org.example.shadowbasebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
@EnableKafka

@SpringBootApplication

public class ShadowbaseBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShadowbaseBackendApplication.class, args);
    }

}
