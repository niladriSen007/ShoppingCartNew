package com.niladri.ShoppingCart.request;

import com.niladri.ShoppingCart.model.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateProductRequest {
    private Long productId;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private int productQuantity;
    private String productBrand;

    private Category productCategory;
}
