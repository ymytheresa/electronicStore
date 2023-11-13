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

}
