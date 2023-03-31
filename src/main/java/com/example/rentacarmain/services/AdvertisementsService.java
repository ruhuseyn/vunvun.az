package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.AdvertisementRequest;
import com.example.rentacarmain.dtos.AdvertisementResponse;

public interface AdvertisementsService {

    Long addAdvertisement(AdvertisementRequest request);

    AdvertisementResponse getAdvertisementById(Long id);


}
