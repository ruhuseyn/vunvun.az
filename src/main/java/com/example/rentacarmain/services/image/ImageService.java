package com.example.rentacarmain.services.image;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    byte[] getImage(Long id);
    void uploadImage(Long id, MultipartFile file) throws IOException;
}
