package com.example.rentacarmain.controller;

import com.example.rentacarmain.entities.elasticsearch.ElasticSearch;
import com.example.rentacarmain.repositories.ElasticSearchRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/elasticsearch")
public class ElasticSearchController {
    private final ElasticSearchRepo elasticSearchRepo;

    @GetMapping("/{value}")
    public ResponseEntity<List<ElasticSearch>> getAll(@PathVariable String value) {
        List<ElasticSearch> values = elasticSearchRepo.getCustomQuery(value);
        return ResponseEntity.ok(values);
    }


}
