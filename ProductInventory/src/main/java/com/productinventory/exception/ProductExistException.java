package com.productinventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProductExistException extends RuntimeException {
    public ProductExistException(String message) {
        super(message);
    }
}
