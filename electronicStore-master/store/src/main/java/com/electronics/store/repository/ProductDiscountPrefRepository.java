package com.electronics.store.repository;

import com.electronics.store.model.ProductDiscountPref;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDiscountPrefRepository extends JpaRepository<ProductDiscountPref, Integer> {
    @Query("SELECT pdf FROM ProductDiscountPref pdf WHERE pdf.productId = ?1")
    List<ProductDiscountPref> findByProductId(Integer productId);
}
