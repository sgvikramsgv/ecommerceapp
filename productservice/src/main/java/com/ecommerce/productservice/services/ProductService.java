package com.ecommerce.productservice.services;

public interface ProductService {
    public String getProductById(long id);

    public void getAllProducts();
    public void deleteProductById();
    public void createProduct();
    public void updateProductById();

}
