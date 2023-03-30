package com.example.rentacarmain.exceptions;

import com.example.rentacarmain.exceptions.superexeptions.MainAlreadyExist;
import com.example.rentacarmain.exceptions.superexeptions.MainNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MainNotFoundException.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MainAlreadyExist.class)
    public final ResponseEntity<Object> handleAllException2(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
