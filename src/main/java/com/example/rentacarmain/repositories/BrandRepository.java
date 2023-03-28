package com.example.rentacarmain.repositories;

import com.example.rentacarmain.entities.advertisement.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
    boolean existsByName(String name);
}
