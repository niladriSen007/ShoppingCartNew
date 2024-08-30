package com.niladri.ShoppingCart.repo.category;

import com.niladri.ShoppingCart.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    Category findByName(String categoryName);
}
