package com.example.rentacarmain.services.elasticsearch;

import com.example.rentacarmain.dto.AllAdvResponse;
import com.example.rentacarmain.dto.PageableAdvResponse;
import com.example.rentacarmain.entities.elasticsearch.AdvertisementEs;
import com.example.rentacarmain.repositories.elasticsearch.ElasticSearchRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ServiceES {

    private final ElasticSearchRepo elasticSearchRepo;

    Logger logger = LoggerFactory.getLogger(ServiceES.class);

    public PageableAdvResponse findAdvertisements(int page, int count) {
        logger.info("get all payments started");

        var pageRequest = PageRequest.of(page, count);
        Page<AdvertisementEs> esPage = elasticSearchRepo.findAll(pageRequest);

        return getPageableAdvResponse(esPage);
    }

    public void addAdvertisements(AdvertisementEs advertisementEs) {
        logger.info("add advertisement started");
        elasticSearchRepo.save(advertisementEs);
        logger.info("add advertisement finished");

    }
    public void deleteAll(){
        elasticSearchRepo.deleteAll();
        logger.warn("all data removed");
    }


    public PageableAdvResponse findAdvertisementsFuzzy(String title,int page, int count) {

        Page<AdvertisementEs> pageableAdvertisementEs = elasticSearchRepo.justFind(title, PageRequest.of(page, count));
        logger.info("get all payments by title fuzzy finished");
        return getPageableAdvResponse(pageableAdvertisementEs);
    }

    private PageableAdvResponse getPageableAdvResponse(Page<AdvertisementEs> pageableAdvertisementEs) {
        List<AllAdvResponse> allAdvResponses = pageableAdvertisementEs
                .getContent()
                .stream()
                .map(advertisementEs ->
                        AllAdvResponse
                                .builder()
                                .id(advertisementEs.getId())
                                .price(BigDecimal.valueOf(advertisementEs.getPrice()))
                                .title(advertisementEs.getTitle())
                                .build())
                .toList();


        return PageableAdvResponse
                .builder()
                .advResponses(allAdvResponses)
                .total(pageableAdvertisementEs.getTotalElements())
                .totalPages(pageableAdvertisementEs.getTotalPages())
                .hasNextPage(pageableAdvertisementEs.hasNext())
                .build();
    }
}
