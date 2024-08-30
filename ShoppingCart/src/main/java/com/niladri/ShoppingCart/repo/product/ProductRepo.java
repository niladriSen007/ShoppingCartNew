package com.niladri.ShoppingCart.repo.product;

import com.niladri.ShoppingCart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.category.categoryName = ?1")
    List<Product> findByCategoryName(String categoryName);

    List<Product> findByBrandName(String brandName);

    List<Product> findByCategoryNameAndBrandName(String categoryName, String brandName);

    List<Product> findByProductName(String productName);

    List<Product> findByProductNameAndBrandName(String productName, String brandName);

    Long countByCategoryName(String categoryName);

    Long countByBrandName(String brand);

    Long countByBrandNameAndProductName(String brandName, String productName);
}
