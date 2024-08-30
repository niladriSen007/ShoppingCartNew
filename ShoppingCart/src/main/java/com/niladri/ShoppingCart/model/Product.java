package com.niladri.ShoppingCart.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private int productQuantity;
    private String productBrand;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_categoryId")
    private Category productCategory;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> productImages;


    public Product(String productName, String productDescription, BigDecimal productPrice, int productQuantity, String productBrand, Category productCategory) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productBrand = productBrand;
        this.productCategory = productCategory;
    }
}
