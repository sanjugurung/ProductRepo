package com.example.productcatalogservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    //all these are present in fakestore product
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;
}
