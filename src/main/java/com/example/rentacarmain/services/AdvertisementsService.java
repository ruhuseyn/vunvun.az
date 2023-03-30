package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.AdvertisementRequest;
import com.example.rentacarmain.dtos.AdvertisementResponse;

public interface AdvertisementsService {

    void addAdvertisement(AdvertisementRequest request);

    AdvertisementResponse getAdvertisementById(Long id);


}
