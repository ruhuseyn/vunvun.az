package com.example.rentacarmain.managers.image;

import com.example.rentacarmain.entities.image.ImageUser;
import com.example.rentacarmain.exception.subexceptions.ImageNotFoundException;
import com.example.rentacarmain.repositories.image.ImageUserRepository;
import com.example.rentacarmain.services.image.ImageUserService;
import com.example.rentacarmain.util.ImageUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageUserManager implements ImageUserService {

    private final ImageUserRepository imageUserRepository;


    @Override
    @Transactional
    public byte[] getImage(Long id) {
        Optional<ImageUser> dbImage = imageUserRepository.findImageUserByUserId(id);
        return ImageUtil.decompressImage(dbImage
                .orElseThrow(() -> new ImageNotFoundException("Image not found for id : " + id))
                .getImageData());
    }

    public void uploadImage(Long id, MultipartFile file) throws IOException {

        imageUserRepository.save(
                new ImageUser(null,id,
                        file.getContentType(),
                        ImageUtil.compressImage(file.getBytes())));


    }
}
