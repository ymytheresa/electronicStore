package com.electronics.store.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer shoppingCartId;
    Integer customerId;
    Status status;
    ConcurrentLinkedDeque<CartProduct> cartProducts;
    Double totalPrice;

}
