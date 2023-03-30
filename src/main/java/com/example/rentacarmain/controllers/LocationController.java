package com.example.rentacarmain.controllers;

import com.example.rentacarmain.entities.advertisement.Location;
import com.example.rentacarmain.repositories.LocationRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
@CrossOrigin(origins = "*")
public record LocationController(LocationRepository repository) {

    @GetMapping
    public List<Location> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Location getById(@PathVariable("id") Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public void add(@Valid @RequestBody Location location) {
        repository.save(location);
    }

}
