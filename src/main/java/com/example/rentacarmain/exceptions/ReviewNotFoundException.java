package com.example.rentacarmain.exceptions;

import com.example.rentacarmain.exceptions.superexeptions.MainNotFoundException;

public class ReviewNotFoundException extends MainNotFoundException {
    public ReviewNotFoundException(String message) {
        super(message);
    }
}
