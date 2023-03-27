package com.example.rentacarmain.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(IncorrectVerificationCodeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public final ResponseEntity<String> handleIncorrectVerificationCodeException(IncorrectVerificationCodeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExpiredVerificationCodeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public final ResponseEntity<String> handleExpiredVerificationCodeException(ExpiredVerificationCodeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IncorrectEmailException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public final ResponseEntity<String> handleIncorrectEmailException(IncorrectEmailException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailAlreadyTakenException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public final ResponseEntity<String> handleIncorrectEmailException(EmailAlreadyTakenException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public final ResponseEntity<String> handleBadCredentialsException(BadCredentialsException ex) {
        return new ResponseEntity<>("Email və ya şifrə yanlışdır!", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public final ResponseEntity<String> handleIncorrectEmailException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }



}