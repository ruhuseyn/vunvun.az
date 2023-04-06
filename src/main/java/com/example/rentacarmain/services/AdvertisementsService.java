package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.adv.AdvertisementRequest;
import com.example.rentacarmain.dtos.adv.DetailedAdvResponse;

public interface AdvertisementsService {

    Long addAdvertisement(AdvertisementRequest request);

    DetailedAdvResponse getAdvertisementById(Long id);


}
