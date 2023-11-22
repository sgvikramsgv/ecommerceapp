package com.ecommerce.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    //DTO - Data Transfer Objects.
    private long id;
    private String title;
    private int price;
    private String category;
    private String description;
    private String image;

}
