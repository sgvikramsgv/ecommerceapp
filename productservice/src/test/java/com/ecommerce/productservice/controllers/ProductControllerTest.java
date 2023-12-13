package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.exceptions.ProductNotFoundException;
import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;
    @Test
    @DisplayName("Testing 1+1 is 2")
    void testOnePlusOneIsTwoOrNot(){
        assertEquals (11, 10+1, "1+1 should be 2");
        //checks the expected value (2) vs the output of the expression.
        //if assert is TRUE, test case succeeds else fails
    }
    @Test
    void testGetProductByIdNegativeTest(){
        assertThrows(ProductNotFoundException.class, () -> productController.getProductById(1000L));
    }

    void testGetProductByIdMocking(){
        when(productService.getProductById(100L)).thenReturn(null);

        assertNull(productController.getProductById(100L));
    }
}
