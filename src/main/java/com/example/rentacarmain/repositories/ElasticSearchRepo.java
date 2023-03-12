package com.example.rentacarmain.repositories;

import com.example.rentacarmain.entities.elasticsearch.ElasticSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElasticSearchRepo extends JpaRepository<ElasticSearch,Long> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"ad\": \"?0\"}}]}}")
    List<ElasticSearch> getCustomQuery(String value);
}
