package com.niladri.ShoppingCart.service.product;

import com.niladri.ShoppingCart.model.Product;
import com.niladri.ShoppingCart.request.product.AddProductRequest;
import com.niladri.ShoppingCart.request.product.UpdateProductRequest;

import java.util.List;

public interface IproductService {
    Product addProduct(AddProductRequest request);

    Product getProductById(Long productId);

    Product updateProduct(UpdateProductRequest request, Long productId);

    void deleteProduct(Long productId);

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String categoryName);

    List<Product> getProductsByBrand(String brand);

    List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice);

    List<Product> getProductsByPriceRangeAndCategory(Double minPrice, Double maxPrice, String categoryName);

    List<Product> getProductsByPriceRangeAndBrand(Double minPrice, Double maxPrice, String brand);

    List<Product> getProductsByPriceRangeAndCategoryAndBrand(Double minPrice, Double maxPrice, String categoryName, String brand);

    List<Product> getProductsByCategoryAndBrand(String categoryName, String brand);

    List<Product> getProductsByNameAndBrand(String productName, String brand);

    List<Product> getProductByNames(String productName);

    Long getProductCount();

    Long getProductCountByCategory(String categoryName);

    Long getProductCountByBrand(String brand);

    Long getProductCountByBrandAndName(String brand, String productName);

//    public Long getProductCountByPriceRange(Double minPrice, Double maxPrice);
//
//    public Long getProductCountByPriceRangeAndCategory(Double minPrice, Double maxPrice, String categoryName);

}
