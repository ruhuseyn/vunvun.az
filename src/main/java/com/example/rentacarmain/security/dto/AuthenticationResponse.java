package com.example.rentacarmain.security.dto;

import lombok.Builder;

@Builder
public record AuthenticationResponse(
        Long userId,
        String token) {
}
