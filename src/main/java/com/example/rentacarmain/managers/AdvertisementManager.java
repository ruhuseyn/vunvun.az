package com.example.rentacarmain.managers;

import com.example.rentacarmain.dtos.AdvertisementRequest;
import com.example.rentacarmain.dtos.AdvertisementResponse;
import com.example.rentacarmain.entities.advertisement.Advertisements;
import com.example.rentacarmain.entities.advertisement.Model;
import com.example.rentacarmain.entities.elasticsearch.AdvertisementEs;
import com.example.rentacarmain.exceptions.subexceptions.AdvertisementNotFoundException;
import com.example.rentacarmain.mappers.AllStructuredMapper;
import com.example.rentacarmain.repositories.AdvertisementRepository;
import com.example.rentacarmain.repositories.LocationRepository;
import com.example.rentacarmain.repositories.ModelRepository;
import com.example.rentacarmain.services.AdvertisementsService;
import com.example.rentacarmain.services.elasticsearch.ElasticsearchService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

@Service
@RequiredArgsConstructor
public class AdvertisementManager implements AdvertisementsService {

    private final AdvertisementRepository repository;
    private final AllStructuredMapper mapper;
    private final ElasticsearchService elasticsearchService;

    private final ModelRepository modelRepository;

    private final LocationRepository locationRepository;

    private static final Logger logger = LoggerFactory.getLogger(AdvertisementManager.class);


    @Override
    public Long addAdvertisement(AdvertisementRequest request) {
        logger.debug("Advertisements added");
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

        return savedAdv.getId();
    }

    @Override
    public AdvertisementResponse getAdvertisementById(Long id) {
        Advertisements advertisements = repository.findById(id)
                .orElseThrow(()-> new AdvertisementNotFoundException("Advertisement is not found" + id));

        return mapper.advToAdvResponse(advertisements);

    }

}


