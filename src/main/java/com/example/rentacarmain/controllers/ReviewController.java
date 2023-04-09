package com.example.rentacarmain.controllers;

import com.example.rentacarmain.dtos.mappers.AllStructuredMapper;
import com.example.rentacarmain.repositories.ModelRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public record ReviewController (
        ModelRepository repository,
        AllStructuredMapper mapper) {
}
