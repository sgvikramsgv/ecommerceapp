package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.exceptions.ProductNotFoundException;
import com.ecommerce.productservice.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.attach.AgentInitializationException;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
@WebMvcTest(ProductController.class)
public class ProductControllerWebMvcTest {

    @MockBean
    private ProductService productService;

    @Inject
    private MockMvc mockMvc;

    @Inject
    private ObjectMapper objectMapper;

    @Test
    void testGetAllProductsReturnsEmptyList() throws Exception {

        when(productService.getAllProducts())
                .thenReturn(new ArrayList<>());


        mockMvc.perform(get("/products"))
                .andExpect(status().is(400))
                .andExpect(content().string("[]"));
    }

    @Test
    void testGetAllProductsReturnsValidList() throws Exception {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        genericProductDtos.add(new GenericProductDto());
        genericProductDtos.add(new GenericProductDto());
        genericProductDtos.add(new GenericProductDto());

        when(productService.getAllProducts())
                .thenReturn(new ArrayList<>());


        mockMvc.perform(get("/products"))
                .andExpect(status().is(400))
                .andExpect(content().string(objectMapper.writeValueAsString(genericProductDtos)));
    }

    @Test
    void testGetAllProductsCreateValidNewProduct() throws Exception {

        GenericProductDto productToCreate = new GenericProductDto();
        productToCreate.setTitle("MacBook");;
        productToCreate.setPrice(300000);
        productToCreate.setDescription("Fastest Mac");
        productToCreate.setCategory("laptop");

        GenericProductDto outputGenericDto = new GenericProductDto();
        outputGenericDto.setCategory(productToCreate.getCategory());
        outputGenericDto.setTitle(productToCreate.getTitle());
        outputGenericDto.setDescription(productToCreate.getDescription());
        outputGenericDto.setPrice(productToCreate.getPrice());
        outputGenericDto.setId(1000L);

        when(productService.createProduct(productToCreate))
                .thenReturn(outputGenericDto);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productToCreate)))
                .andExpect(
                        content().string(objectMapper.writeValueAsString(outputGenericDto)))
                .andExpect(status().is(200));

    }

}
