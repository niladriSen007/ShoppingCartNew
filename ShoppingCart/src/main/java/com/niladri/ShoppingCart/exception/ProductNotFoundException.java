package com.niladri.ShoppingCart.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException (String productNotFound) {
        super(productNotFound);
    }
}
