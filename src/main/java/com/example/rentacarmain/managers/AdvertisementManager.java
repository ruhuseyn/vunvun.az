package com.example.rentacarmain.managers;

import com.example.rentacarmain.dto.AdvertisementRequest;
import com.example.rentacarmain.entities.advertisement.Advertisements;
import com.example.rentacarmain.entities.advertisement.Model;
import com.example.rentacarmain.entities.elasticsearch.AdvertisementEs;
import com.example.rentacarmain.mapper.AdvertisementMapper;
import com.example.rentacarmain.repositories.AdvertisementRepository;
import com.example.rentacarmain.repositories.LocationRepository;
import com.example.rentacarmain.repositories.ModelRepository;
import com.example.rentacarmain.services.AdvertisementsService;
import com.example.rentacarmain.services.elasticsearch.ElasticsearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvertisementManager implements AdvertisementsService {

    private final AdvertisementRepository repository;
    private final AdvertisementMapper mapper;
    private final ElasticsearchService elasticsearchService;

    private final ModelRepository modelRepository;

    private final LocationRepository locationRepository;


    @Override
    public void addAdvertisement(AdvertisementRequest request) {
        Advertisements advertisements = mapper.advRequestToAdv(request);

        Advertisements savedAdv = repository.save(advertisements);

        Model model = modelRepository.findById(request.model().id()).get();

        AdvertisementEs advertisementEs = AdvertisementEs
                .builder()
                .id(savedAdv.getId())
                .title(
                        model.getBrand().getName()
                        +
                        " "
                        + model.getName() )
                .brandId(model.getBrand().getId())
                .modelId(model.getId())
                .locationId(request.location().id())
                .price(savedAdv.getPrice().intValue())
                .build();
        elasticsearchService.addAdvertisements(advertisementEs);
    }
}


