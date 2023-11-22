package com.ecommerce.productservice.services;

import org.springframework.stereotype.Service;

@Service("SelfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {
    @Override
    public String getProductById(long id) {
        return "Scaler SelfService || Product  ID: " + id;
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
