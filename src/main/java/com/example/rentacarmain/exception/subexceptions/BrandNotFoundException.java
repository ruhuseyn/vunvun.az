package com.example.rentacarmain.exception.subexceptions;

import com.example.rentacarmain.exception.superexeptions.MainNotFoundException;

public class BrandNotFoundException extends MainNotFoundException {
    public BrandNotFoundException(String message) {
        super(message);
    }
}
