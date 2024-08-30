package com.niladri.ShoppingCart.request;

import com.niladri.ShoppingCart.model.Category;
import com.niladri.ShoppingCart.model.Image;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
public class AddProductRequest {
    private Long productId;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private int productQuantity;
    private String productBrand;

    private Category productCategory;
}
