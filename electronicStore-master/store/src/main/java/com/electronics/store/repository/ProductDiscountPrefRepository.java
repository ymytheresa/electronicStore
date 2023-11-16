package com.electronics.store.repository;

import com.electronics.store.model.ProductDiscountPref;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductDiscountPrefRepository extends JpaRepository<ProductDiscountPref, Integer> {
    @Query("SELECT pdf FROM ProductDiscountPref pdf WHERE pdf.productId = ?1")
    List<ProductDiscountPref> findByProductId(Integer productId);

    @Query("SELECT pdf FROM ProductDiscountPref pdf WHERE pdf.productId = ?1 AND pdf.discountRuleId = ?2")
    Optional<ProductDiscountPref> findByProductIdAndDiscountRuleId(Integer productId, Integer discountRuleId);
}
