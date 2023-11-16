package com.electronics.store.model;

import jakarta.persistence.*;

@Entity
public class ProductDiscountPref {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productDiscountPrefId;

    @Column(name = "productId")
    Integer productId;

    @Column(name = "discountRuleId")
    Integer discountRuleId;

    public ProductDiscountPref() {}

    public ProductDiscountPref(Integer productId, Integer discountRuleId) {
        this.productId = productId;
        this.discountRuleId = discountRuleId;
    }

    public Integer getProductDiscountPrefId() {
        return productDiscountPrefId;
    }

    public void setProductDiscountPrefId(Integer productDiscountPrefId) {
        this.productDiscountPrefId = productDiscountPrefId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getDiscountRuleId() {
        return discountRuleId;
    }

    public void setDiscountRuleId(Integer discountRuleId) {
        this.discountRuleId = discountRuleId;
    }
}
