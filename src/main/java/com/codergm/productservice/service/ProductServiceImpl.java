package com.codergm.productservice.service;

import com.codergm.productservice.entity.Product;
import com.codergm.productservice.exception.ProductServiceException;
import com.codergm.productservice.model.ProductRequest;
import com.codergm.productservice.model.ProductResponse;
import com.codergm.productservice.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product..");
        Product product = Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        productRepository.save(product).getProductId();
        log.info("Product created..");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(Long productId) {
        log.info("Get the product for productId: {}", productId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceException("Product with given id not found", "PRODUCT_NOT_FOUND"));
        ProductResponse response = new ProductResponse();
        BeanUtils.copyProperties(product, response);
        return response;
    }
}
