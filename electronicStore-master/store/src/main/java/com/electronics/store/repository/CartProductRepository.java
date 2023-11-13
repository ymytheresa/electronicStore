package com.electronics.store.repository;

import com.electronics.store.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {
}
