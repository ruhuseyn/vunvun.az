package com.example.rentacarmain.exception.subexceptions;

import com.example.rentacarmain.exception.superexeptions.MainNotFoundException;

public class ImageNotFoundException extends MainNotFoundException {
    public ImageNotFoundException(String message) {
        super(message);
    }
}
