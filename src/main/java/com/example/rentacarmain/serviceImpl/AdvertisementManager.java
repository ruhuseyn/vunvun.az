package com.example.rentacarmain.serviceImpl;

import com.example.rentacarmain.dtos.adv.AdvertisementRequest;
import com.example.rentacarmain.dtos.adv.DetailedAdvResponse;
import com.example.rentacarmain.entities.Owners;
import com.example.rentacarmain.entities.advertisement.Advertisements;
import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.entities.advertisement.Location;
import com.example.rentacarmain.entities.advertisement.Model;
import com.example.rentacarmain.entities.elasticsearch.AdvertisementEs;
import com.example.rentacarmain.exceptions.subexceptions.AdvertisementNotFoundException;
import com.example.rentacarmain.mappers.AllStructuredMapper;
import com.example.rentacarmain.mappers.BrandMapper;
import com.example.rentacarmain.mappers.OwnerMapper;
import com.example.rentacarmain.repositories.AdvertisementRepository;
import com.example.rentacarmain.repositories.LocationRepository;
import com.example.rentacarmain.repositories.ModelRepository;
import com.example.rentacarmain.services.AdvertisementsService;
import com.example.rentacarmain.services.BrandService;
import com.example.rentacarmain.services.elasticsearch.ElasticsearchService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

@Service
@RequiredArgsConstructor
public class AdvertisementManager implements AdvertisementsService {

    private final AdvertisementRepository repository;
    private final AllStructuredMapper mapper;

    private final BrandMapper brandMapper;
    private final ElasticsearchService elasticsearchService;

    private final ModelRepository modelService;

    private final OwnerMapper ownerMapper;

    private static final Logger logger = LoggerFactory.getLogger(AdvertisementManager.class);


    @Override
    public Long add(AdvertisementRequest request) {
        logger.debug("Advertisements added");
        Advertisements advertisements = mapper.advRequestToAdv(request);

        Advertisements savedAdv = repository.save(advertisements);

        Model model = modelService.findById(request.model().id()).get();

        AdvertisementEs advertisementEs = AdvertisementEs
                .builder()
                .id(savedAdv.getId())
                .title(model.getBrand().getName() + " " + model.getName())
                .brandId(model.getBrand().getId())
                .modelId(model.getId())
                .locationId(request.location().id())
                .price(savedAdv.getPrice().intValue())
                .build();
        elasticsearchService.addAdvertisements(advertisementEs);

        return savedAdv.getId();
    }

    @Override
    public DetailedAdvResponse getById(Long id) {
        Advertisements advertisements = repository.findById(id)
                .orElseThrow(() -> new AdvertisementNotFoundException("Advertisement is not found" + id));

        Model model = advertisements.getModel();
        Brand brand = model.getBrand();
        Owners owner = advertisements.getOwner();
        Location location = advertisements.getLocation();

        System.out.println(advertisements.getLocation().getId());

        return DetailedAdvResponse.builder()
                .price(advertisements.getPrice())
                .creationTime(advertisements.getCreationTime())
                .description(advertisements.getDescription())
                .model(mapper.modelToModelResponse(model))
                .brand(brandMapper.toBrandDTO(brand))
                .owner(ownerMapper.ownerToOwnerResponse(owner))
                .location(mapper.locationToLocationResponse(location))
                .build();

    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void patchById(Long id, @NotBlank String process) {
        if (process.equals("activate")) {
            repository.activateById(id);
        } else if (process.equals("deactivate")) {
            repository.deactivateById(id);
        }

    }

}


