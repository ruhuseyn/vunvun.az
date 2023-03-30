package com.example.rentacarmain.mappers;

import com.example.rentacarmain.dtos.*;
import com.example.rentacarmain.entities.Owners;
import com.example.rentacarmain.entities.advertisement.Advertisements;
import com.example.rentacarmain.entities.advertisement.Location;
import com.example.rentacarmain.entities.advertisement.Model;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.matcher.StringMatcher;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllStructuredMapperTest {

    private final AllStructuredMapper allStructuredMapper = new AllStructuredMapperImpl();

    @Test
    void advRequestToAdvTest() {
        ModelRequest modelRequest = new ModelRequest(1L);
        OwnerRequest ownerRequest = new OwnerRequest(1L);
        LocationRequest locationRequest = new LocationRequest(1L);

        var advertisement = new AdvertisementRequest("Tekerinde problem var",
                BigDecimal.valueOf(3000), LocalDate.of(2020, 12, 23),
                "2.5 Turbo", modelRequest, ownerRequest, locationRequest);

        var expected = new Advertisements(
                null, "Tekerinde problem var",
                BigDecimal.valueOf(3000), LocalDate.of(2020, 12, 23),
                "2.5 Turbo", Location.builder().id(1L).build(), Model.builder().id(1L).build(),
                Owners.builder().id(1L).build()
        );

        //ACT(Actual)
        Advertisements actual = allStructuredMapper.advRequestToAdv(advertisement);

        //Assert
        Assertions.assertThat(actual).isEqualTo(expected);

    }

    @Test
    void modelRequestToModelTest() {

        var request = new ModelRequest(1L);

        var expected = Model.builder().id(1L).build();

        //ACT( Actual)
        Model actual = allStructuredMapper.modelRequestToModel(request);

        //Assert
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void advToAdvResponseTest() {
        ModelRequest modelRequest = new ModelRequest(1L);
        OwnerRequest ownerRequest = new OwnerRequest(1L);
        LocationRequest locationRequest = new LocationRequest(1L);

        var advertisement = new Advertisements(null, "Tekerinde problem var",
                BigDecimal.valueOf(3000), LocalDate.of(2020, 12, 23),
                "2.5 Turbo", Location.builder().id(1L).build(), Model.builder().id(1L).build(),
                Owners.builder().id(1L).build());

        var expected = new AdvertisementResponse("Tekerinde problem var",
                BigDecimal.valueOf(3000), LocalDate.of(2020, 12, 23),
                "2.5 Turbo", modelRequest, ownerRequest, locationRequest);

        //ACT( Actual)
        AdvertisementResponse actual = allStructuredMapper.advToAdvResponse(advertisement);

        //Assert
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void modelToModelReviewsListTest() {
        ReviewsRequest reviewsRequest1 = new ReviewsRequest(1L);
        ReviewsRequest reviewsRequest2 = new ReviewsRequest(1L);

        var model = new ArrayList<Model>();
        model.add(Model.builder().id(1L).build());
        model.add(Model.builder().id(2L).build());

        var expected = new ArrayList<ModelRequestReviews>();
        expected.add(new ModelRequestReviews(reviewsRequest1));
        expected.add(new ModelRequestReviews(reviewsRequest2));

        //ACT( Acual)
        List<ModelRequestReviews> actual = allStructuredMapper.modelToModelReviewsList(model);

        //Assert
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}