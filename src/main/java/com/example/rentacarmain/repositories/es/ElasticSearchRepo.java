package com.example.rentacarmain.repositories.es;

import com.example.rentacarmain.entities.es.AdvertisementEs;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElasticSearchRepo extends ElasticsearchRepository<AdvertisementEs,Long> {

    @Query("{\"multi_match\": {\"query\": \"?0\", \"fields\": [\"title\"], \"fuzziness\": \"AUTO\"}}")
    List<AdvertisementEs> fuzzySearch(String title);

}
