package com.electronics.store.controller;

import com.electronics.store.service.CartProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.electronics.store.model.CartProduct;

import java.util.List;

// should not be called. for testing only
@RestController
@RequestMapping("/api/cartProduct")
public class CartProductController {
    @Autowired
    private CartProductServiceImpl cartProductService;

    @GetMapping("/all")
    public List<CartProduct> getAllCartProducts(){
        return cartProductService.getAllCartProducts();
    }

    @GetMapping("/cartId/{cartId}/productId/{productId}")
    public CartProduct getCartProductFromCart(@PathVariable Integer cartId,@PathVariable Integer productId){
        return cartProductService.getCartProductFromCart(cartId, productId);
    }

    @PostMapping("/{cartId}/{productId}/{quantity}")
    public CartProduct createCartProduct(@PathVariable Integer cartId ,@PathVariable Integer productId, @PathVariable Integer quantity){
        return cartProductService.createCartProduct(cartId,productId,quantity);
    }

    @PutMapping("/{cartId}/{productId}/{quantity}")
    public CartProduct updateCartProduct(@PathVariable Integer cartId ,@PathVariable Integer productId,@PathVariable Integer quantity){
        return cartProductService.addQuantityCartProduct(cartId,productId,quantity);
    }

    @GetMapping("/cartId/{cartId}")
    public List<CartProduct> getCartProductsByCartId(@PathVariable Integer cartId){
        return cartProductService.getCartProductsByCartId(cartId);
    }

}
