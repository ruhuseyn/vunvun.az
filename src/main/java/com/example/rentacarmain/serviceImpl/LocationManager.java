package com.example.rentacarmain.serviceImpl;

import com.example.rentacarmain.dtos.location.LocationRequest;
import com.example.rentacarmain.dtos.location.LocationResponse;
import com.example.rentacarmain.entities.advertisement.Location;
import com.example.rentacarmain.exceptions.subexceptions.LocationNotFoundException;
import com.example.rentacarmain.mappers.LocationMapper;
import com.example.rentacarmain.repositories.LocationRepository;
import com.example.rentacarmain.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationManager implements LocationService {

    private final LocationRepository repository;
    private final LocationMapper mapper;

    @Override
    public List<Location> findAll() {
        return repository.findAll();
    }

    @Override
    public LocationResponse findById(Long id) {
        return repository
                .findById(id)
                .map(mapper::toLocationResponse)
                .orElseThrow(() -> new LocationNotFoundException(""));
    }

    @Override
    public void save(LocationRequest request) {
        repository
                .save(mapper.fromLocationRequest(request));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
