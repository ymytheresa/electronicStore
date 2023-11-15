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
}
