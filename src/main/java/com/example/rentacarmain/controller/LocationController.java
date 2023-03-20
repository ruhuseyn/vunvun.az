package com.example.rentacarmain.controller;

import com.example.rentacarmain.entities.advertisement.Location;
import com.example.rentacarmain.repositories.LocationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
public record LocationController(LocationRepository repository) {

    @GetMapping
    public List<Location> getAll(){
        return repository.findAll();
    }

}
