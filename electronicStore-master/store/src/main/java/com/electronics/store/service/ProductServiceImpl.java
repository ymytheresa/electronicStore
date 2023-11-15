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
        return productRepository.save(product);
    }

    public Product getProduct(Integer productId){
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isPresent()){
            return productOptional.get();
        }
        return null; //todo, throw exception
    }

    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }

    public Product updateProduct(Integer productId,Product product){
        //todo, revisit this and discountrule update logic, like here should be find by id and rule
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isPresent()){
            productRepository.deleteById(productId); //todo, replace instead of remove then add later
            return productRepository.save(product);
        }
        return null; //todo, throw exception
    }

    public Product addAmountToQuantity(Integer productId, Integer amount){
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isPresent()){
            Product product = productOptional.get();
            product.setStockQuantity(product.getStockQuantity() + amount);
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(Integer productId){
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isPresent()){
            productRepository.deleteById(productId);
        }
        //throw exception?
    }


}

