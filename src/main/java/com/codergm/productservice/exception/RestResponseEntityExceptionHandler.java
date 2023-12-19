package com.codergm.productservice.exception;

import com.codergm.productservice.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(ProductServiceException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleProductServiceException(ProductServiceException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorMessage
                .builder()
                .message(exception.getMessage())
                .errorCode(exception.getErrorCode())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build());
    }
}
