package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {



    private ProductService productService;

    @Autowired
    //Constructor Injection
    ProductController(@Qualifier("SelfProductServiceImpl") ProductService productService){
        this.productService = productService;
    }

    //localhost:8080/products/123
    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") long id){
//        return "Scaler || Product fetched with ID: " + id;
        return productService.getProductById(id);
    }
    @GetMapping
    public void getAllProducts(){

    }
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") long id){

    }
    @PostMapping("/")
    public void createProduct(){

    }

    @PutMapping("/{id}")
    public void updateProductById(@PathVariable("id") long id){

    }

}


/*

3 ways of Dependency Injection:
    1. Constructor Injection
        This is what is implemented in above code
        @Autowired
        //Constructor Injection
        ProductController(@Qualifier("SelfProductServiceImpl") ProductService productService){
            this.productService = productService;
        }

    2. Field Injection
        We can inject the object when we create the variable in the code
        @Autowired
        @Qualifier("SelfProductServiceImpl")
        private ProductService productService;

    3. Setter Injection
        Create a Setter method for the class variable and Autowire it.
        @Autowired
        @Qualifier("SelfProductServiceImpl")
        public void setProductService(ProductService productService) {
            this.productService = productService;
        }


 */