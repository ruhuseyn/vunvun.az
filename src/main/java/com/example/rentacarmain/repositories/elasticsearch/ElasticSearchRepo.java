package com.example.rentacarmain.repositories.elasticsearch;

import com.example.rentacarmain.entities.elasticsearch.AdvertisementEs;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ElasticSearchRepo extends ElasticsearchRepository<AdvertisementEs,Long> {

    Page<AdvertisementEs> findByTitleLike(String title, Pageable pageable);

//    @Query("{\"multi_match\": {\"query\": \"?0\", \"fields\": [\"firstName\", \"lastName\"], \"fuzziness\": \"AUTO\"}}")
//    @Query("{\"match\": {\"title\": {\"query\": \"?0\",\"fuzziness\": \"1\", \"operator\": \"or\"}}}")
    @Query("{\"multi_match\": {\"query\": \"?0\", \"fields\": [\"title\"], \"fuzziness\": \"AUTO\"}}")
    Page<AdvertisementEs> justFind(@Param(value = "title") String title, Pageable pageable);


    Page<AdvertisementEs> findAllByLocationId(Long locationId,Pageable pageable);
    Page<AdvertisementEs> findAllByBrandId(Long brandId,Pageable pageable);


    Page<AdvertisementEs> findAllByBrandIdAndLocationId(Long brandId, Long locationId, PageRequest pageRequest);
}
