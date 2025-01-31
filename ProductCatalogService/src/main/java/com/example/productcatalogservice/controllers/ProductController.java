package com.example.productcatalogservice.controllers;

import com.example.productcatalogservice.dtos.CategoryDto;
import com.example.productcatalogservice.dtos.ProductDto;
import com.example.productcatalogservice.models.Category;
import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        Product product = new Product();
        product.setId(1L);
        product.setName("iphone");
        List<Product> products = new ArrayList<>();
        products.add(product);
        return products;
    }

    @GetMapping("/products/{prodid}")
    public ProductDto findProductById(@PathVariable("prodid") Long id){
        Product product = productService.getProductById(id);
        return from(product);
    }

    private ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null) {
            CategoryDto productCategoryDto = new CategoryDto();
            productCategoryDto.setId(product.getCategory().getId());
            productCategoryDto.setName(product.getCategory().getName());
            productCategoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(productCategoryDto);
        }
        return productDto;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return product;
    }
}
