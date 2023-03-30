package com.example.rentacarmain.exceptions.subexceptions;

import com.example.rentacarmain.exceptions.superexeptions.MainNotFoundException;

public class UserNotFoundException extends MainNotFoundException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
