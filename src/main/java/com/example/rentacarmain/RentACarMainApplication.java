package com.example.rentacarmain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.util.List;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "*")
public class RentACarMainApplication{


    public static void main(String[] args) {
        SpringApplication.run(RentACarMainApplication.class, args);
    }


}
