package com.example.rentacarmain.services;

import com.example.rentacarmain.dto.AdvertisementRequest;
import com.example.rentacarmain.dto.AdvertisementResponse;
import com.example.rentacarmain.entities.advertisement.Advertisements;
import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.entities.advertisement.Location;
import com.example.rentacarmain.entities.advertisement.Model;
import java.util.List;

public interface AdvertisementsService {

    void addAdvertisement(AdvertisementRequest request);

    AdvertisementResponse getAdvertisementById(Long id);


}
