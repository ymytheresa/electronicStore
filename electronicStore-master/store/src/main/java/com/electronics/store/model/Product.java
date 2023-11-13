package com.electronics.store.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productEntityId;

    @Column(name = "productId")
    Integer productId;

    @Column(name = "productName")
    String productName;
    @Column(name = "productPrice")
    Double productPrice;
    @Column(name = "stockQuantity")
    Integer stockQuantity;

    @Column(name = "discountRuleId")
    String discountRuleId;

    public Integer getProductEntityId() {
        return productEntityId;
    }

    public void setProductEntityId(Integer productEntityId) {
        this.productEntityId = productEntityId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getDiscountRuleId() {
        return discountRuleId;
    }

    public void setDiscountRuleId(String discountRuleId) {
        this.discountRuleId = discountRuleId;
    }
}