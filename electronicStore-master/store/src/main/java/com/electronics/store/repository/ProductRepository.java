package com.electronics.store.repository;

import com.electronics.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
//    @Query("SELECT product FROM Product product WHERE product.productId = ?1 AND product.discountRuleId = ?2")
//    Optional<Product> findByProductIdAndDiscountRule(Integer productId, Integer discountRuleId);
}
