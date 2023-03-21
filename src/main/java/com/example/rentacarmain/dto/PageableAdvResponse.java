package com.example.rentacarmain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageableAdvResponse {

    List<AllAdvResponse> advResponses;

    Long total;

    int totalPages;

    boolean hasNextPage;

}
