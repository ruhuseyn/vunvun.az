//package com.example.rentacarmain.mappers;
//
//import com.example.rentacarmain.dtos.owner.OwnerRequest;
//import com.example.rentacarmain.dtos.owner.OwnerResponse;
//import com.example.rentacarmain.dtos.user.PatchUserRequest;
//import com.example.rentacarmain.entities.Owners;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//class OwnerMapperTest {
//
//    private final OwnerMapper ownerMapper = new OwnerMapperImpl();
//
//    @Test
//    void ownerRequestToOwners() {
//
//        var ownerRequest = new OwnerRequest(1L);
//
//        var expected = Owners.builder().id(1L).build();
//
//        //Act
//        Owners actual = ownerMapper.ownerRequestToOwners(ownerRequest);
//
//        //ASSERT
//        Assertions.assertThat(actual).isEqualTo(expected);
//    }
//
//    @Test
//    void ownerToOwnerResponse() {
////        PatchUserRequest patchUserRequest = new PatchUserRequest(1L);
//
//        var owner = Owners.builder().id(1L).phoneNumber("055-555-55-55").build();
//
//        var expected = new OwnerResponse(1L,"055-555-55-55");
//
//        //Act
//        OwnerResponse actual = ownerMapper.ownerToOwnerResponse(owner);
//
//        //ASSERT
//        Assertions.assertThat(actual).isEqualTo(expected);
//    }
//
//    @Test
//    void ownerResponseToOwner() {
//
//        var ownerResponse = new OwnerResponse(1L,"055-555-55-55");
//
//        var expected =  Owners.builder().id(1L).phoneNumber("055-555-55-55").build();
//
//        //Act
//        Owners actual = ownerMapper.ownerResponseToOwner(ownerResponse);
//
//        //Assert
//        Assertions.assertThat(actual).isEqualTo(expected);
//    }
//}