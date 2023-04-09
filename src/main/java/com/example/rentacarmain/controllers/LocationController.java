package com.example.rentacarmain.controllers;

import com.example.rentacarmain.dtos.location.LocationResponse;
import com.example.rentacarmain.entities.advertisement.Location;
import com.example.rentacarmain.services.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public record LocationController(LocationService service) {

    @GetMapping
    public List<Location> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public LocationResponse getById(@PathVariable("id") Long id) {
        return service.findById(id);
    }



}
