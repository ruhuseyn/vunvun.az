package com.example.rentacarmain.exceptions.subexceptions;

import com.example.rentacarmain.exceptions.superexeptions.MainNotFoundException;

public class BrandNotFoundException extends MainNotFoundException {
    public BrandNotFoundException(String message) {
        super(message);
    }
}
