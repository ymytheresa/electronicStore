package com.electronics.store.repository;

import com.electronics.store.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    @Query("SELECT s FROM ShoppingCart s WHERE s.customerId = ?1")
    List<ShoppingCart> findByCustomerId(Integer customerId);
}
