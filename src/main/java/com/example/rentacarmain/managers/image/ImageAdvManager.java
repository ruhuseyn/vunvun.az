package com.example.rentacarmain.managers.image;


import com.example.rentacarmain.entities.image.ImageAdv;
import com.example.rentacarmain.entities.image.ImageUser;
import com.example.rentacarmain.exception.subexceptions.ImageNotFoundException;
import com.example.rentacarmain.repositories.image.ImageAdvRepository;
import com.example.rentacarmain.services.image.ImageService;
import com.example.rentacarmain.util.ImageUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageAdvManager implements ImageService {

    private final ImageAdvRepository imageAdvRepository;
    @Override
    @Transactional
    public byte[] getImage(Long id) {
        Optional<ImageAdv> dbImage = imageAdvRepository.findImageAdvByAdvId(id);
        return ImageUtil.decompressImage(dbImage
                .orElseThrow(() -> new ImageNotFoundException("AdvImage not found for id : " + id))
                .getImageData());
    }

    @Override
    public void uploadImage(Long id, MultipartFile file) throws IOException {

        imageAdvRepository.save(
                new ImageAdv(null,id,
                        file.getContentType(),
                        ImageUtil.compressImage(file.getBytes())));


    }
}
