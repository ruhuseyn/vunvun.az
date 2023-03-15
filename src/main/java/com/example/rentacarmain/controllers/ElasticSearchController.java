package com.example.rentacarmain.controllers;

import com.example.rentacarmain.entities.es.AdvertisementEs;
import com.example.rentacarmain.repositories.es.ElasticSearchRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/elasticsearch")
public class ElasticSearchController {
    private final ElasticSearchRepo elasticSearchRepo;

    @GetMapping("/{value}")
    public Iterable<AdvertisementEs> findAll(@PathVariable String value) {
        return elasticSearchRepo.findAll();
    }


}
