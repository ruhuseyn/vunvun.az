package com.example.rentacarmain.security.exception;

public class ExpiredVerificationCodeException extends RuntimeException {
    public ExpiredVerificationCodeException(String message) {
        super(message);
    }
}
