package com.example.rentacarmain.controllers;

import com.example.rentacarmain.entities.advertisement.Brand;
import com.example.rentacarmain.managers.BrandManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BrandController.class)
class BrandControllerTest {

    private static String BRAND_PATH = "/brands";
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BrandManager brandManager;

    @Test
    void addBrand_Succes() throws Exception {
        var request = new Brand(1L,"Mercedes");

        doNothing().when(brandManager).addBrand(request);

        mockMvc.perform(post(BRAND_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());

        verifyNoInteractions(brandManager);
    }

    @Test
    void addBrand_WhenNameIsBlank_BadRequest() throws Exception{
        var request = new Brand(1L,"");

        doNothing().when(brandManager).addBrand(request);

        mockMvc.perform(post(BRAND_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(brandManager);
    }
    @Test
    void getBrandById_Succes() throws Exception{
        var response = new Brand(1L,"Rufet");
        when(brandManager.getById(1L)).thenReturn(response);

        mockMvc.perform(get(BRAND_PATH + "/{id}",1L))
                .andExpect(status().isOk());

        verifyNoInteractions(brandManager);
    }

}