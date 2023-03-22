package com.example.rentacarmain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
public record PageableAdvResponse(
        List<AllAdvResponse> advResponses,

        Long total,

        int totalPages,

        boolean hasNextPage
) {



}
