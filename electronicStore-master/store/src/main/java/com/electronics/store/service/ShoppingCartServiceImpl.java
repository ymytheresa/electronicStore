package com.electronics.store.service;

import com.electronics.store.model.ShoppingCart;
import com.electronics.store.repository.ShoppingCartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ShoppingCartServiceImpl {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

//    @Autowired
//    private CartProductServiceImpl cartProductService;

    public ShoppingCart createShoppingCart(Integer customerId) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCustomerId(customerId);
        shoppingCart.setCompleted(false);
        shoppingCart.setTotalPrice(0.0);
        shoppingCart.setDiscount(0.0);
        return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart getShoppingCart(Integer shoppingCartId){
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(shoppingCartId);
        //todo, throw exception
        return shoppingCartOptional.orElse(null);
    }

    public List<ShoppingCart> getAllShoppingCarts(){
        return this.shoppingCartRepository.findAll();
    }

    public void deleteShoppingCart(Integer shoppingCartId){
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(shoppingCartId);
        if(shoppingCartOptional.isPresent()){
            shoppingCartRepository.deleteById(shoppingCartId);
        }
        //throw exception?
    }

    public void addDiscount(Integer cartId, Double discount) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(cartId);
        if (shoppingCartOptional.isPresent()) {
            ShoppingCart shoppingCart = shoppingCartOptional.get();
            shoppingCart.setDiscount(shoppingCart.getDiscount() + discount);
            shoppingCartRepository.save(shoppingCart);
        }
    }

    public void addTotalPrice(Integer cartId, Double price) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(cartId);
        if (shoppingCartOptional.isPresent()) {
            ShoppingCart shoppingCart = shoppingCartOptional.get();
            shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() + price);
            shoppingCartRepository.save(shoppingCart);
        }
    }


    public void changeCartPrice(Integer cartId, Double oldPrice, Double price) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(cartId);
        if (shoppingCartOptional.isPresent()) {
            ShoppingCart shoppingCart = shoppingCartOptional.get();
            shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() - oldPrice + price);
            shoppingCartRepository.save(shoppingCart);
        }
    }

    public void changeCartDiscount(Integer cartId, Double oldDiscount, Double discount) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(cartId);
        if (shoppingCartOptional.isPresent()) {
            ShoppingCart shoppingCart = shoppingCartOptional.get();
            shoppingCart.setDiscount(shoppingCart.getDiscount() - oldDiscount + discount);
            shoppingCartRepository.save(shoppingCart);
        }
    }

    public List<ShoppingCart> getShoppingCartsByCustomerId(Integer customerId) {
        return this.shoppingCartRepository.findByCustomerId(customerId);
    }

//    public ShoppingCart updateShoppingCart(Integer shoppingCartId, Integer productId, Integer quantity) {
//        cartProductService.addQuantityCartProduct(shoppingCartId, productId, quantity);
//        return getShoppingCart(shoppingCartId);
//    }

    public ShoppingCart updateShoppingCartStatus(Integer shoppingCartId, String status) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(shoppingCartId);
        if (shoppingCartOptional.isPresent()) {
            ShoppingCart shoppingCart = shoppingCartOptional.get();
            boolean completed = status.equals("completed");
            shoppingCart.setCompleted(completed);
            shoppingCartRepository.save(shoppingCart);
        }
        return getShoppingCart(shoppingCartId);
    }
}
