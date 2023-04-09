package com.example.rentacarmain.exceptions.subexceptions;

import com.example.rentacarmain.exceptions.superexeptions.MainNotFoundException;

public class LocationNotFoundException extends MainNotFoundException {
    public LocationNotFoundException(String message) {
        super(message);
    }
}
