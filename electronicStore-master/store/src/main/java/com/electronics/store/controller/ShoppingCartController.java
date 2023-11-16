package com.electronics.store.controller;

import com.electronics.store.model.ShoppingCart;
import com.electronics.store.service.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shoppingCart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;

    @Autowired
    private CartProductController cartProductController;

    @GetMapping("/all")
    public List<ShoppingCart> getAllShoppingCarts(){
        return shoppingCartService.getAllShoppingCarts();
    }

    @GetMapping("/{shoppingCartId}")
    public ShoppingCart getShoppingCart(@PathVariable Integer shoppingCartId){
        return shoppingCartService.getShoppingCart(shoppingCartId);
    }

    @GetMapping("/customer/{customerId}")
    public List<ShoppingCart> getShoppingCartsByCustomerId(@PathVariable Integer customerId){
        return shoppingCartService.getShoppingCartsByCustomerId(customerId);
    }

    @PostMapping("/customer/{customerId}")
    public ShoppingCart createShoppingCart(@PathVariable Integer customerId){
        return shoppingCartService.createShoppingCart(customerId);
    }

    @PutMapping("/cart/{shoppingCartId}/product/{productId}/quantity/{quantity}")
    public ShoppingCart updateShoppingCart(@PathVariable Integer shoppingCartId, @PathVariable Integer productId, @PathVariable Integer quantity){
        cartProductController.updateCartProduct(shoppingCartId,productId,quantity);
        return shoppingCartService.getShoppingCart(shoppingCartId);
    }

    @PutMapping("/{shoppingCartId}/status/{status}")
    public ShoppingCart updateShoppingCartStatus(@PathVariable Integer shoppingCartId, @PathVariable String status){
        return shoppingCartService.updateShoppingCartStatus(shoppingCartId,status);
    }


    @DeleteMapping("/{shoppingCartId}")
    public void deleteShoppingCart(@PathVariable Integer shoppingCartId){
        shoppingCartService.deleteShoppingCart(shoppingCartId);
    }
}
