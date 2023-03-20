package com.example.rentacarmain;

import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.entities.advertisement.Location;
import com.example.rentacarmain.entities.advertisement.Model;
import com.example.rentacarmain.repositories.BrandRepository;
import com.example.rentacarmain.repositories.LocationRepository;
import com.example.rentacarmain.repositories.ModelRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.util.List;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "*")
public class RentACarMainApplication {

    private BrandRepository brandRepository;

    private ModelRepository modelRepository;

    private LocationRepository locationRepository;

    public static void main(String[] args) {
        SpringApplication.run(RentACarMainApplication.class, args);
    }

    @PostConstruct
    public void initialize() {
        initializeBrands();
        initializeLocations();
        initializeModels();
    }

    private void initializeBrands() {
        for (int i = 0; i < 10; i++) {
            brandRepository.save(new Brand(null, "brand" + i));
        }
    }


    private void initializeLocations() {
        for (int i = 0; i < 10; i++) {
            locationRepository.save(new Location(null, "location" + i));
        }
    }

    private void initializeModels() {
        for (int i = 0; i < 5; i++) {
            modelRepository.save(new Model(null, "model" + i, new Brand(1L, null)));
        }
        for (int i = 5; i < 10; i++) {
            modelRepository.save(new Model(null, "model" + i, new Brand(2L, null)));
        }
    }


}
