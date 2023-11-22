package com.ecommerce.productservice.services;

import org.springframework.stereotype.Service;

@Service("FakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl implements ProductService{
    @Override
    public String getProductById(long id) {
        return "Scaler || Product  ID: " + id;
    }

    @Override
    public void getAllProducts() {

    }

    @Override
    public void deleteProductById() {

    }

    @Override
    public void createProduct() {

    }

    @Override
    public void updateProductById() {

    }
}
