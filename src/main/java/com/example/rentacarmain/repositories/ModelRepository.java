package com.example.rentacarmain.repositories;

import com.example.rentacarmain.entities.advertisement.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model,Long> {

    List<Model> findAllByBrand_Id(Long brandId);

}
