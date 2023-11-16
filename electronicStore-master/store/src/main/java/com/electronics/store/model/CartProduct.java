package com.electronics.store.model;

import jakarta.persistence.*;

@Entity
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer cartProductId;

    @Column(name = "productId")
    Integer productId;

    @Column(name = "shoppingCartId")
    Integer shoppingCartId;
    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "price")
    Double price;

    @Column(name = "discount")
    Double discount;

    public CartProduct() {
    }

    public CartProduct(Integer productId, Integer shoppingCartId, Integer quantity, Double price, Double discount) {
        this.productId = productId;
        this.shoppingCartId = shoppingCartId;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    public Integer getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(Integer cartProductId) {
        this.cartProductId = cartProductId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Integer shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
