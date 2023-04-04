package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.request.AdvertisementRequest;
import com.example.rentacarmain.dtos.response.DetailedAdvResponse;

public interface AdvertisementsService {

    Long addAdvertisement(AdvertisementRequest request);

    DetailedAdvResponse getAdvertisementById(Long id);


}
