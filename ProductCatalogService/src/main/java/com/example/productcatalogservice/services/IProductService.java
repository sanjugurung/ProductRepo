package com.example.productcatalogservice.services;

import com.example.productcatalogservice.models.Product;

public interface IProductService {
    public Product getProductById(Long productId);
}
