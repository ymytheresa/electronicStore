package com.electronics.store.model;

import jakarta.persistence.*;

@Entity
public class DiscountRule {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer discountRuleId;

    @Column(name = "itemQuantity")
    Integer itemQuantity;

    @Column(name = "discountRate")
    Double discountRate;

    public DiscountRule() {
    }

    public DiscountRule(Integer itemQuantity, Double discountRate) {
        this.itemQuantity = itemQuantity;
        this.discountRate = discountRate;
    }

    public Integer getDiscountRuleId() {
        return discountRuleId;
    }

    public void setDiscountRuleId(Integer discountRuleId) {
        this.discountRuleId = discountRuleId;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }
}

