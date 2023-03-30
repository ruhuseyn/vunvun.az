package com.example.rentacarmain.exception.subexceptions;

import com.example.rentacarmain.exception.superexeptions.MainNotFoundException;

public class AdvertisementNotFoundException extends MainNotFoundException {

    public AdvertisementNotFoundException(String message) {
        super(message);
    }
}
