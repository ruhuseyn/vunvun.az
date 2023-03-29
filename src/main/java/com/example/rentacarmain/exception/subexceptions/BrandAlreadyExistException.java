package com.example.rentacarmain.exception.subexceptions;

import com.example.rentacarmain.exception.superexeptions.MainAlreadyExist;

public class BrandAlreadyExistException extends MainAlreadyExist {
    public BrandAlreadyExistException(String message) {
        super(message);
    }
}
