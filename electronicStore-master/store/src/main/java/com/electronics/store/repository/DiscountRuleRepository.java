package com.electronics.store.repository;

import com.electronics.store.model.DiscountRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface DiscountRuleRepository extends JpaRepository<DiscountRule, Integer> {
    @Query("SELECT rule FROM DiscountRule rule WHERE rule.itemQuantity = ?1 AND rule.discountRate = ?2")
    Optional<DiscountRule> findByQtyAndDisRate(Integer itemQuantity, Double discountRate);
}