package com.electronics.store.service;

import com.electronics.store.model.Product;
import com.electronics.store.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product){
        Optional<Product> existingProduct = productRepository.findByProductIdAndDiscountRule(product.getProductId(), product.getDiscountRuleId());
        if (existingProduct.isPresent()) {
            return existingProduct.get();
        } else {
            return productRepository.save(product);
        }
    }

}

