package com.example.rentacarmain.controllers;

import com.example.rentacarmain.entities.es.AdvertisementEs;
import com.example.rentacarmain.repositories.es.ElasticSearchRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/elasticsearch")
public class ElasticSearchController {
    private final ElasticSearchRepo elasticSearchRepo;


    @GetMapping("/{value}")
    public Iterable<AdvertisementEs> findAll(@PathVariable String value) {
        return elasticSearchRepo.fuzzySearch(value);
    }

    @PostMapping
    public void add(@RequestBody AdvertisementEs advertisementEs){
        elasticSearchRepo.save(advertisementEs);
    }


}
