package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.AdvertisementRequest;
import com.example.rentacarmain.dtos.AdvertisementResponse;
import com.example.rentacarmain.dtos.DetailedAdvResponse;

public interface AdvertisementsService {

    Long addAdvertisement(AdvertisementRequest request);

    DetailedAdvResponse getAdvertisementById(Long id);


}
