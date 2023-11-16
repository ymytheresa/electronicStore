package com.electronics.store.controller;

import com.electronics.store.service.ProductDiscountPrefServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.electronics.store.model.ProductDiscountPref;

import java.util.List;
@RestController
@RequestMapping("/api/productDiscountPref")
public class ProductDiscountPrefController {
    @Autowired
    private ProductDiscountPrefServiceImpl productDiscountPrefService;

    @GetMapping("/all")
    public List<ProductDiscountPref> getAllProductDiscountPrefs() {
        return productDiscountPrefService.getAllProductDiscountPrefs();
    }

    @GetMapping("/{productDiscountPrefId}")
    public ProductDiscountPref getProductDiscountPref(@PathVariable Integer productDiscountPrefId) {
        return productDiscountPrefService.getProductDiscountPref(productDiscountPrefId);
    }

    @PostMapping("/productId/{productId}/ruleid/{discountRuleId}/")
    public ProductDiscountPref createProductDiscountPref(@PathVariable Integer productId, @PathVariable Integer discountRuleId) {
        return productDiscountPrefService.createProductDiscountPref(productId, discountRuleId);
    }

    @PutMapping("/{productDiscountPrefId}")
    public ProductDiscountPref updateProductDiscountPref(@PathVariable Integer productDiscountPrefId, @RequestBody ProductDiscountPref productDiscountPref) {
        return productDiscountPrefService.updateProductDiscountPref(productDiscountPrefId, productDiscountPref);
    }

    @DeleteMapping("/{productDiscountPrefId}")
    public void deleteProductDiscountPref(@PathVariable Integer productDiscountPrefId) {
        productDiscountPrefService.deleteProductDiscountPref(productDiscountPrefId);
    }
}
