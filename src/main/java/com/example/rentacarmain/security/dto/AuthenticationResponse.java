package com.example.rentacarmain.security.dto;

import lombok.Builder;

@Builder
public record AuthenticationResponse(String token) {
}
