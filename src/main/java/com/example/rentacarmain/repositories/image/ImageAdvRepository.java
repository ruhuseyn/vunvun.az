package com.example.rentacarmain.repositories.image;

import com.example.rentacarmain.entities.image.ImageAdv;
import com.example.rentacarmain.entities.image.ImageUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageAdvRepository extends JpaRepository<ImageAdv,Long> {

    Optional<ImageAdv> findImageAdvByAdvId(Long advId);
}
