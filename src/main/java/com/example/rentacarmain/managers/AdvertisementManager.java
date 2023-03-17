package com.example.rentacarmain.managers;

import com.example.rentacarmain.entities.advertisement.Advertisements;
import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.entities.advertisement.Location;
import com.example.rentacarmain.entities.advertisement.Model;
import com.example.rentacarmain.repositories.AdvertisementRepository;
import com.example.rentacarmain.services.AdvertisementsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record AdvertisementManager(AdvertisementRepository advertisementRepository) implements AdvertisementsService {
    @Override
    public Advertisements getCarByBrand(Brand brand) {
        return null;
    }

    @Override
    public List<Advertisements> getCarsByModel(Model model) {
        return null;
    }

    @Override
    public List<Advertisements> getCarsByLocation(Location location) {
        return null;
    }
}
