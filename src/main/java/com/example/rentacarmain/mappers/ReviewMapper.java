package com.example.rentacarmain.mappers;

import com.example.rentacarmain.dtos.ReviewResponse;
import com.example.rentacarmain.entities.Reviews;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewResponse reviewToReviewResponse(Reviews reviews);

}
