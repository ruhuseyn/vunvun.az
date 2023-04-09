package com.example.rentacarmain.services.serviceImpl;

import com.example.rentacarmain.dtos.ReviewResponse;
import com.example.rentacarmain.exceptions.ReviewNotFoundException;
import com.example.rentacarmain.dtos.mappers.ReviewMapper;
import com.example.rentacarmain.repositories.ReviewRepository;
import com.example.rentacarmain.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewManager implements ReviewService {

    private final ReviewRepository repository;

    private final ReviewMapper mapper;

    @Override
    public ReviewResponse getByAdvertisementId(Long advertisementId) {
        return repository
                .findByAdvertisements_Id(advertisementId)
                .map(mapper::reviewToReviewResponse)
                .orElseThrow(
                        () ->
                               new ReviewNotFoundException("Review not found for adv id : " + advertisementId));
    }
}
