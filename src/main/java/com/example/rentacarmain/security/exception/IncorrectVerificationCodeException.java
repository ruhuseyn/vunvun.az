package com.example.rentacarmain.security.exception;

public class IncorrectVerificationCodeException extends RuntimeException {
    public IncorrectVerificationCodeException(String message) {
        super(message);
    }
}
