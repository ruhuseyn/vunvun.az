package com.example.rentacarmain.exceptions.subexceptions;

import com.example.rentacarmain.exceptions.superexeptions.MainNotFoundException;

public class OwnerNotFoundException extends MainNotFoundException {
    public OwnerNotFoundException(String message) {
        super(message);
    }
}
