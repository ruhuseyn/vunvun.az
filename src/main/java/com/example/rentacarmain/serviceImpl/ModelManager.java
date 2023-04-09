package com.example.rentacarmain.serviceImpl;

import com.example.rentacarmain.dtos.model.AddModelRequest;
import com.example.rentacarmain.dtos.model.ModelRequestReviews;
import com.example.rentacarmain.entities.advertisement.Model;
import com.example.rentacarmain.mappers.AllStructuredMapper;
import com.example.rentacarmain.mappers.ModelMapper;
import com.example.rentacarmain.repositories.ModelRepository;
import com.example.rentacarmain.services.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelManager implements ModelService {

    private final ModelRepository repository;

    private final ModelMapper mapper;

    @Override
    public List<Model> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Model> getAllByBrandId(Long brandId) {
        return repository.findAllByBrand_Id(brandId);
    }

    @Override
    public void add(AddModelRequest request) {
        repository.save(mapper.fromAddModelRequest(request));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
