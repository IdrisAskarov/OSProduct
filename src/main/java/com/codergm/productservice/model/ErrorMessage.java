package com.codergm.productservice.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorMessage {
    private String message;
    private String errorCode;
    private Integer statusCode;
}
