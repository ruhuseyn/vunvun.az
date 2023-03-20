package com.example.rentacarmain.repositories.elasticsearch;

import com.example.rentacarmain.entities.elasticsearch.AdvertisementEs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ElasticSearchRepo extends ElasticsearchRepository<AdvertisementEs,String> {

    Page<AdvertisementEs> findByTitleLike(String title, Pageable pageable);

//    @Query("{\"multi_match\": {\"query\": \"?0\", \"fields\": [\"firstName\", \"lastName\"], \"fuzziness\": \"AUTO\"}}")
//    @Query("{\"match\": {\"title\": {\"query\": \"?0\",\"fuzziness\": \"1\", \"operator\": \"or\"}}}")
    @Query("{\"multi_match\": {\"query\": \"?0\", \"fields\": [\"title\"], \"fuzziness\": \"AUTO\"}}")
    Page<AdvertisementEs> justFind(String title, Pageable pageable);

}
