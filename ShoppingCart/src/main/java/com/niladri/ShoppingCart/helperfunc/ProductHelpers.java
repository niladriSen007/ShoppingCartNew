package com.niladri.ShoppingCart.helperfunc;

import com.niladri.ShoppingCart.model.Category;
import com.niladri.ShoppingCart.model.Product;
import com.niladri.ShoppingCart.request.AddProductRequest;
import com.niladri.ShoppingCart.request.UpdateProductRequest;

public class ProductHelpers {
    public static Product createProduct(AddProductRequest request, Category category) {
        return new Product(
                request.getProductName(),
                request.getProductDescription(),
                request.getProductPrice(),
                request.getProductQuantity(),
                request.getProductBrand(),
                category
        );
    }

    public static Product updateProduct(UpdateProductRequest request, Product existingProduct) {
        existingProduct.setProductName(request.getProductName());
        existingProduct.setProductDescription(request.getProductDescription());
        existingProduct.setProductPrice(request.getProductPrice());
        existingProduct.setProductQuantity(request.getProductQuantity());
        existingProduct.setProductBrand(request.getProductBrand());
        existingProduct.setProductCategory(request.getProductCategory());
        return existingProduct;
    }
}
