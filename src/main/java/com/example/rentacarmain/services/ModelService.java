package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.model.AddModelRequest;
import com.example.rentacarmain.entities.advertisement.Model;

import java.util.List;

public interface ModelService {

    List<Model> getAllByBrandId(Long brandId);

    void add(AddModelRequest request);

    void deleteById(Long id);

    List<Model> getAll();
}
