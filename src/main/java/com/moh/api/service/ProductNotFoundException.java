package com.moh.api.service;

public class ProductNotFoundException extends Throwable {
    public ProductNotFoundException(Integer id) {
        super(String.format("Product with id %s not found", id));
    }
}
