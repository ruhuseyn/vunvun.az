package com.example.rentacarmain.dtos;


import java.sql.Date;

public record ReviewResponse(
        Date date,

        Double rate,

        String text,

        UserReviewResponse user
) {
}
