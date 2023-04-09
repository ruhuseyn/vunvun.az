package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.location.LocationRequest;
import com.example.rentacarmain.dtos.location.LocationResponse;
import com.example.rentacarmain.entities.advertisement.Location;

import java.util.List;

public interface LocationService {
    List<Location> findAll();

   LocationResponse findById(Long id);

    void save(LocationRequest request);

    void deleteById(Long id);
}
