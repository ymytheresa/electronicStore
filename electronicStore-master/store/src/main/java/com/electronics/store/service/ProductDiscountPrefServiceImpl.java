package com.electronics.store.service;

import com.electronics.store.model.ProductDiscountPref;
import com.electronics.store.repository.ProductDiscountPrefRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductDiscountPrefServiceImpl {
    @Autowired
    private ProductDiscountPrefRepository productDiscountPrefRepository;

    public ProductDiscountPref createProductDiscountPref(Integer productId, Integer discountRuleId){
        Optional<ProductDiscountPref> productDiscountPrefOptional = productDiscountPrefRepository.findByProductIdAndDiscountRuleId(productId,discountRuleId);
        if(productDiscountPrefOptional.isPresent()){
            return productDiscountPrefOptional.get();
        }
        ProductDiscountPref productDiscountPref = new ProductDiscountPref();
        productDiscountPref.setProductId(productId);
        productDiscountPref.setDiscountRuleId(discountRuleId);
        return productDiscountPrefRepository.save(productDiscountPref);
    }

    public ProductDiscountPref getProductDiscountPref(Integer productDiscountPrefId){
        Optional<ProductDiscountPref> productDiscountPrefOptional = productDiscountPrefRepository.findById(productDiscountPrefId);
        //todo, throw exception
        return productDiscountPrefOptional.orElse(null);
    }

    public List<ProductDiscountPref> getAllProductDiscountPrefs(){
        return this.productDiscountPrefRepository.findAll();
    }

    public ProductDiscountPref updateProductDiscountPref(Integer productDiscountPrefId,ProductDiscountPref productDiscountPref){
        Optional<ProductDiscountPref> productDiscountPrefOptional = productDiscountPrefRepository.findById(productDiscountPrefId);
        if(productDiscountPrefOptional.isPresent()){
            productDiscountPrefRepository.deleteById(productDiscountPrefId); //todo, replace instead of remove then add later
            return productDiscountPrefRepository.save(productDiscountPref);
        }
        return null; //todo, throw exception
    }

    public void deleteProductDiscountPref(Integer productDiscountPrefId) {
        Optional<ProductDiscountPref> productDiscountPrefOptional = productDiscountPrefRepository.findById(productDiscountPrefId);
        if (productDiscountPrefOptional.isPresent()) {
            productDiscountPrefRepository.deleteById(productDiscountPrefId);
        }
        //throw exception?
    }

    public List<ProductDiscountPref> findByProductId(Integer productId) {
        return productDiscountPrefRepository.findByProductId(productId);
    }
}
