package com.example.rentacarmain.controllers.image;

import com.example.rentacarmain.serviceImpl.image.ImageUserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/userimage")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ImageUserController {

    private final ImageUserManager imageUserManager;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getImageByName(@PathVariable("userId") Long id){
        byte[] image = imageUserManager.getImage(id);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }

    @PostMapping("/{userId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Void> saveImage(@PathVariable("userId") Long id, MultipartFile image) throws IOException {
        imageUserManager.uploadImage(id,image);
        return ResponseEntity.ok().build();
    }
}
