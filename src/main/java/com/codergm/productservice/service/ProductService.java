package com.codergm.productservice.service;

import com.codergm.productservice.model.ProductRequest;

public interface ProductService {
    long addProduct(ProductRequest productRequest);
}
