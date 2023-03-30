package com.example.rentacarmain.exceptions;

import java.time.LocalDateTime;

public record ErrorDetails(
        LocalDateTime timeStamp,
        String message,
        String details

) {

}
