package com.example.rentacarmain.exceptions.subexceptions;

import com.example.rentacarmain.exceptions.superexeptions.MainNotFoundException;

public class ImageNotFoundException extends MainNotFoundException {
    public ImageNotFoundException(String message) {
        super(message);
    }
}
