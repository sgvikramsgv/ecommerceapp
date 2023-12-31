package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
    public GenericProductDto getProductById(long id);

    public List<GenericProductDto> getAllProducts();
    public GenericProductDto deleteProductById(long id);
    public GenericProductDto createProduct(GenericProductDto genericProductDto);
    public void updateProductById();

}
