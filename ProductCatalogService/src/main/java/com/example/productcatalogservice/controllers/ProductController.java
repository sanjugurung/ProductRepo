package com.example.productcatalogservice.controllers;

import com.example.productcatalogservice.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        Product product = new Product();
        product.setId(1L);
        product.setName("iphone");
        List<Product> products = new ArrayList<>();
        products.add(product);
        return products;
    }

    @GetMapping("/products/{id}")
    public Product findProductById(Long id){
        return null;
    }

}
