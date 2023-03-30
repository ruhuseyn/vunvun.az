package com.example.rentacarmain.controllers;

import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.managers.BrandManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = BrandController.class)
class BrandControllerTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BrandManager brandManager;

    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void addBrand_Succes() {

    }
}