package com.niladri.ShoppingCart.service.category;

import com.niladri.ShoppingCart.exception.AlreadyExistsException;
import com.niladri.ShoppingCart.exception.CategoryNotFound;
import com.niladri.ShoppingCart.helperfunc.CategoryHelpers;
import com.niladri.ShoppingCart.model.Category;
import com.niladri.ShoppingCart.repo.category.CategoryRepo;
import com.niladri.ShoppingCart.request.category.AddCategoryRequest;
import com.niladri.ShoppingCart.request.category.UpdateCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public Category addCategory(AddCategoryRequest request) {
        Optional<Category> existingCategory = Optional.ofNullable(categoryRepo.findByName(request.getCategoryName()));
        if (existingCategory.isPresent()) {
            throw new AlreadyExistsException("Category already exists");
        }
        return categoryRepo.save(CategoryHelpers.createCategory(request));
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepo.findById(categoryId).orElseThrow(() -> new CategoryNotFound("Category not found"));
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryRepo.findByName(categoryName);
    }

    @Override
    public Category updateCategory(UpdateCategoryRequest request, Long categoryId) {
        Category updatedCategory = null;
        Optional<Category> existingCategory = Optional.of(categoryRepo.findById(categoryId))
                .orElseThrow(() -> new CategoryNotFound("Category not found"));
        if (existingCategory.isPresent()) {
            updatedCategory = CategoryHelpers.updateCategory(request, existingCategory.get());
            categoryRepo.save(updatedCategory);
            return updatedCategory;
        }
        return null;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepo.findById(categoryId).ifPresentOrElse(categoryRepo::delete, () -> {
            throw new CategoryNotFound("Category not found");
        });
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Long getCategoryCount() {
        return categoryRepo.count();
    }

    @Override
    public Long getCategoryCountByCategoryName(String categoryName) {
        return categoryRepo.countByName(categoryName);
    }
}
