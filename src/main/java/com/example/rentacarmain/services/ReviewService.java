package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.ReviewResponse;

public interface ReviewService {

    ReviewResponse getByAdvertisementId(Long id);

}
