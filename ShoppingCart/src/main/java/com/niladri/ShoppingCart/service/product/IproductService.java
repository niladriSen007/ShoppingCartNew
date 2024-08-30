package com.niladri.ShoppingCart.service.product;

import com.niladri.ShoppingCart.model.Product;
import com.niladri.ShoppingCart.request.AddProductRequest;
import com.niladri.ShoppingCart.request.UpdateProductRequest;

import java.util.List;

public interface IproductService {
    public Product addProduct(AddProductRequest request);

    public Product getProductById(Long productId);

    public Product updateProduct(UpdateProductRequest request, Long productId);

    public void deleteProduct(Long productId);

    public List<Product> getAllProducts();

    public List<Product> getProductsByCategory(String categoryName);

    public List<Product> getProductsByBrand(String brand);

    public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice);

    public List<Product> getProductsByPriceRangeAndCategory(Double minPrice, Double maxPrice, String categoryName);

    public List<Product> getProductsByPriceRangeAndBrand(Double minPrice, Double maxPrice, String brand);

    public List<Product> getProductsByPriceRangeAndCategoryAndBrand(Double minPrice, Double maxPrice, String categoryName, String brand);

    public List<Product> getProductsByCategoryAndBrand(String categoryName, String brand);

    public List<Product> getProductsByNameAndBrand(String productName, String brand);

    public List<Product> getProductByNames(String productName);

    public Long getProductCount();

    public Long getProductCountByCategory(String categoryName);

    public Long getProductCountByBrand(String brand);

    public Long getProductCountByBrandAndName(String brand, String productName);

//    public Long getProductCountByPriceRange(Double minPrice, Double maxPrice);
//
//    public Long getProductCountByPriceRangeAndCategory(Double minPrice, Double maxPrice, String categoryName);

}
