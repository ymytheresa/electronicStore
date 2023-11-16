package com.electronics.store.model;

import jakarta.persistence.*;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer shoppingCartId;
    @Column(name = "customerId")
    Integer customerId;
    @Column(name = "completed")
    Boolean completed;
    @Column(name = "totalPrice")
    Double totalPrice;

    @Column(name = "discount")
    Double discount;

    public ShoppingCart() {}

    public ShoppingCart(Integer customerId, Boolean completed, Double totalPrice, Double discount) {
        this.customerId = customerId;
        this.completed = completed;
        this.totalPrice = totalPrice;
        this.discount = discount;
    }

    public Integer getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Integer shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

}
