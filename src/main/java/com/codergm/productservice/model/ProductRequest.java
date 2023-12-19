package com.codergm.productservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {
    private String name;
    private Double price;
    private Long quantity;
}
