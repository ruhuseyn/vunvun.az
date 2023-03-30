package com.example.rentacarmain.exceptions.subexceptions;

import com.example.rentacarmain.exceptions.superexeptions.MainNotFoundException;

public class AdvertisementNotFoundException extends MainNotFoundException {

    public AdvertisementNotFoundException(String message) {
        super(message);
    }
}
