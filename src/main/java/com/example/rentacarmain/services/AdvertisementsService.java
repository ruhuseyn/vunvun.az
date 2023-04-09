package com.example.rentacarmain.services;

import com.example.rentacarmain.dtos.adv.AdvertisementRequest;
import com.example.rentacarmain.dtos.adv.DetailedAdvResponse;

public interface AdvertisementsService {

    Long add(AdvertisementRequest request);

    DetailedAdvResponse getById(Long id);

    void deleteById(Long id);


    void patchById(Long id, String process);
}
