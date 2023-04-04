package com.example.rentacarmain.dtos.response;

import lombok.*;

import java.util.List;

@Builder
public record PageableAdvResponse(
        List<AllAdvResponse> advResponses,

        Long total,

        int totalPages,

        boolean hasNextPage
) {



}
