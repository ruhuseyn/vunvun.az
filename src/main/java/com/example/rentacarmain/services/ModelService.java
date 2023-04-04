package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.request.ModelRequestReviews;

import java.util.List;

public interface ModelService {

    List<ModelRequestReviews> getAllReviews();
}
