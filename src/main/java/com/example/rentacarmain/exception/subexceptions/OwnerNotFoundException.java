package com.example.rentacarmain.exception.subexceptions;

import com.example.rentacarmain.exception.superexeptions.MainNotFoundException;

public class OwnerNotFoundException extends MainNotFoundException {
    public OwnerNotFoundException(String message) {
        super(message);
    }
}
