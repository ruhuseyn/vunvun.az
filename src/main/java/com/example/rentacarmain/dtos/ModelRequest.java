package com.example.rentacarmain.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;


public record ModelRequest(
        @NotBlank(message = "Id is mandatory")
        Long id
) {
}
