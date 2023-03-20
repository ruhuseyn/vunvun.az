package com.example.rentacarmain.services.elasticsearch;

import com.example.rentacarmain.entities.elasticsearch.AdvertisementEs;
import com.example.rentacarmain.repositories.elasticsearch.ElasticSearchRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServiceES {


    private final ElasticSearchRepo elasticSearchRepo;

        public List<AdvertisementEs> findAdvertisements(String title,int pageSize) {
        Page<AdvertisementEs> findAdvertisements = elasticSearchRepo.findByTitleLike(title, Pageable.ofSize(pageSize));
            return findAdvertisements.get().toList();
    }

    public void addAdvetisements(AdvertisementEs advertisementEs){
            elasticSearchRepo.save(advertisementEs);
    }


}
