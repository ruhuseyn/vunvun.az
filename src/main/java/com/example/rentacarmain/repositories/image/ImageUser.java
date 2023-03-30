package com.example.rentacarmain.repositories.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageUser extends JpaRepository<ImageUser,Long> {

//    Optional<ImageData> findImageDataByProductId(Long id);
//
//    void deleteImageDataByProductId(Long productId);

}
