package com.example.rentacarmain.exception.subexceptions;

import com.example.rentacarmain.exception.superexeptions.MainNotFoundException;

public class UserNotFoundException extends MainNotFoundException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
