package com.example.rentacarmain.managers;

import com.example.rentacarmain.dto.AdvertisementRequest;
import com.example.rentacarmain.entities.advertisement.Advertisements;
import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.entities.advertisement.Location;
import com.example.rentacarmain.entities.advertisement.Model;
import com.example.rentacarmain.entities.elasticsearch.AdvertisementEs;
import com.example.rentacarmain.mapper.AdvertisementMapper;
import com.example.rentacarmain.repositories.AdvertisementRepository;
import com.example.rentacarmain.services.AdvertisementsService;
import com.example.rentacarmain.services.elasticsearch.ElasticsearchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementManager implements AdvertisementsService {

    private final AdvertisementRepository repository;
    private final AdvertisementMapper mapper;
    private final ElasticsearchService elasticsearchService;

    public AdvertisementManager(AdvertisementRepository repository,
                                AdvertisementMapper mapper,
                                ElasticsearchService elasticsearchService) {
        this.repository = repository;
        this.mapper = mapper;
        this.elasticsearchService = elasticsearchService;
    }

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

    @Override
    public void addAdvertisement(AdvertisementRequest request) {
        Advertisements advertisements = mapper.advRequestToAdv(request);

        Advertisements savedAdv = repository.save(advertisements);

        AdvertisementEs advertisementEs = AdvertisementEs
                .builder()
                .id(savedAdv.getId())
                .title(savedAdv.getModel().getName() + " " + savedAdv.getModel().getBrand().getName())
                .brandId(savedAdv.getModel().getBrand().getId())
                .modelId(savedAdv.getModel().getId())
                .locationId(savedAdv.getLocation().getId())
                .price(savedAdv.getPrice().intValue())
                .build();
        elasticsearchService.addAdvertisements(advertisementEs);
    }
}
