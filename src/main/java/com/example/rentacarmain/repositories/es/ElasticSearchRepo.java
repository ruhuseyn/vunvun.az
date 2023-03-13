package com.example.rentacarmain.repositories.es;

import com.example.rentacarmain.entities.es.AdvertisementEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticSearchRepo extends ElasticsearchRepository<AdvertisementEs,Long> {


}
