package com.electronics.store.controller;

import com.electronics.store.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.electronics.store.model.Product;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable Integer productId){
        return productService.getProduct(productId);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Integer productId,@RequestBody Product product){
        return productService.updateProduct(productId,product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Integer productId){
        productService.deleteProduct(productId);
    }

    @PutMapping("/{productId}/{amount}")
    public Product updateProduct(@PathVariable Integer productId, @PathVariable Integer amount){
        return productService.addAmountToQuantity(productId,amount);
    }
}
