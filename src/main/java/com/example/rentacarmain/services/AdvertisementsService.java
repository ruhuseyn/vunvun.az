package com.example.rentacarmain.services;

import com.example.rentacarmain.entities.advertisement.Advertisements;
import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.entities.advertisement.Location;
import com.example.rentacarmain.entities.advertisement.Model;

import java.util.List;

public interface AdvertisementsService {

    Advertisements getCarByBrand(Brand brand);

    List<Advertisements> getCarsByModel(Model model);

    List<Advertisements> getCarsByLocation(Location location);




}
