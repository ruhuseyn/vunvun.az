package com.example.rentacarmain.exceptions.subexceptions;

import com.example.rentacarmain.exceptions.superexeptions.MainAlreadyExist;

public class BrandAlreadyExistException extends MainAlreadyExist {
    public BrandAlreadyExistException(String message) {
        super(message);
    }
}
