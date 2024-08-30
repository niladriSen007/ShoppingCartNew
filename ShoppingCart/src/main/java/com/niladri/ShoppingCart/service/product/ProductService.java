package com.niladri.ShoppingCart.service.product;

import com.niladri.ShoppingCart.exception.ProductNotFoundException;
import com.niladri.ShoppingCart.helperfunc.ProductHelpers;
import com.niladri.ShoppingCart.model.Category;
import com.niladri.ShoppingCart.model.Product;
import com.niladri.ShoppingCart.repo.category.CategoryRepo;
import com.niladri.ShoppingCart.repo.product.ProductRepo;
import com.niladri.ShoppingCart.request.product.AddProductRequest;
import com.niladri.ShoppingCart.request.product.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IproductService {

    //    @Autowired
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    @Override
    public Product addProduct(AddProductRequest request) {

        //if product category is there then create product
        Category newCategory = Optional.ofNullable(categoryRepo.findByName(request.getProductCategory().getCategoryName())).orElseGet(() -> {
            Category category = new Category(request.getProductCategory().getCategoryName());
            return categoryRepo.save(category);
        });

        request.setProductCategory(newCategory);
        Product newProduct = ProductHelpers.createProduct(request, newCategory);
        return productRepo.save(newProduct);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepo.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Override
    public Product updateProduct(UpdateProductRequest request, Long productId) {
        Optional<Product> existingProduct = Optional.of(productRepo.findById(productId))
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        if (existingProduct.isPresent()) {
            Product updatedProduct = ProductHelpers.updateProduct(request, existingProduct.get());
            productRepo.save(updatedProduct);
            return updatedProduct;
        }
            return null;
        
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepo.findById(productId).ifPresentOrElse(product -> productRepo.delete(product), () -> {
            throw new ProductNotFoundException("Product not found");
        });
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {
        return productRepo.findByCategoryName(categoryName);
    }

    @Override
    public List<Product> getProductsByBrand(String brandName) {
        return productRepo.findByBrandName(brandName);
    }

    @Override
    public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByPriceRangeAndCategory(Double minPrice, Double maxPrice, String categoryName) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByPriceRangeAndBrand(Double minPrice, Double maxPrice, String brand) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByPriceRangeAndCategoryAndBrand(Double minPrice, Double maxPrice, String categoryName, String brand) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String categoryName, String brandName) {
        return productRepo.findByCategoryNameAndBrandName(categoryName, brandName);
    }

    @Override
    public List<Product> getProductsByNameAndBrand(String productName, String brandName) {
        return productRepo.findByProductNameAndBrandName(productName, brandName);
    }

    @Override
    public List<Product> getProductByNames(String productName) {
        return productRepo.findByProductName(productName);
    }

    @Override
    public Long getProductCount() {
        return productRepo.count();
    }

    @Override
    public Long getProductCountByCategory(String categoryName) {
        return productRepo.countByCategoryName(categoryName);
    }

    @Override
    public Long getProductCountByBrand(String brand) {
        return productRepo.countByBrandName(brand);
    }

    @Override
    public Long getProductCountByBrandAndName(String brandName, String productName) {
        return productRepo.countByBrandNameAndProductName(brandName, productName);
    }

//    @Override
//    public Long getProductCountByPriceRange(Double minPrice, Double maxPrice) {
//        return Long.valueOf(0);
//    }
//
//    @Override
//    public Long getProductCountByPriceRangeAndCategory(Double minPrice, Double maxPrice, String categoryName) {
//        return Long.valueOf(0);
//    }
}
