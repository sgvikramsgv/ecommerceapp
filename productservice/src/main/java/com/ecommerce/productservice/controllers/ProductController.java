package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    //Constructor Injection
    ProductController(@Qualifier("FakeStoreProductServiceImpl") ProductService productService){
        this.productService = productService;
    }

    //localhost:8080/products/123
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") long id){
        //return "Scaler || Product fetched with ID: " + id;
        //RetTemplate

        return productService.getProductById(id);
    }
    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }
    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") long id){
        return productService.deleteProductById(id);
    }
    @PostMapping()
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }

    @PatchMapping("/{id}")
    public void updateProductById(@PathVariable("id") long id){
        //home work
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