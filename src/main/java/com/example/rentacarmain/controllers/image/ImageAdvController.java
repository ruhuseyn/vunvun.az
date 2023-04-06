package com.example.rentacarmain.controllers.image;

import com.example.rentacarmain.serviceImpl.image.ImageAdvManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/advimage")
@CrossOrigin(origins = "*")
public class ImageAdvController {
    private final ImageAdvManager imageAdvManager;

    @GetMapping("/{advid}")
    public ResponseEntity<?> getImageByName(@PathVariable("advid") Long id){
        byte[] image = imageAdvManager.getImage(id);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }

    @PostMapping("/{advid}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Void> saveImage(@PathVariable("advid") Long id, MultipartFile image) throws IOException {
        imageAdvManager.uploadImage(id,image);
        return ResponseEntity.ok().build();
    }
}
