package com.example.rentacarmain.managers;

import com.example.rentacarmain.dtos.ModelRequestReviews;
import com.example.rentacarmain.entities.advertisement.Model;
import com.example.rentacarmain.mappers.AllStructuredMapper;
import com.example.rentacarmain.repositories.ModelRepository;
import com.example.rentacarmain.services.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelManager implements ModelService {

    private final ModelRepository modelRepository;
    private final AllStructuredMapper advertisementMapper;

    @Override
    public List<ModelRequestReviews> getAllReviews() {
        List<Model> modelReviews =  modelRepository.findAll();

        return advertisementMapper.modelToModelReviewsList(modelReviews);
    }
}
