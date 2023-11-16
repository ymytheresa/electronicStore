package com.electronics.store.repository;

import com.electronics.store.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {
    @Query("SELECT c FROM CartProduct c WHERE c.productId = ?1")
    Optional<CartProduct> findByProductId(Integer productId);

    @Query("SELECT c FROM CartProduct c WHERE c.productId = ?1 AND c.shoppingCartId = ?2")
    Optional<CartProduct> findByProductIdAndShoppingCartId(Integer cartId, Integer productId);

    @Query("SELECT c FROM CartProduct c WHERE c.shoppingCartId = ?1")
    List<CartProduct> findByShoppingCartId(Integer cartId);
}
