package com.electronics.store.service;

import com.electronics.store.model.*;
import com.electronics.store.repository.CartProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartProductServiceImpl {
    @Autowired
    private CartProductRepository cartProductRepository;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private DiscountRuleServiceImpl discountRuleService;

    @Autowired
    private ProductDiscountPrefServiceImpl discountPrefService;

    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;


    public CartProduct createCartProduct(Integer cartId, Integer productId, Integer quantity){
        boolean productExists = productService.getProduct(productId) != null && productService.getProduct(productId).getStockQuantity() >= quantity;
        if (!productExists) {
            return null;
        }
        CartProduct cartProduct = new CartProduct();
        cartProduct.setShoppingCartId(cartId);
        cartProduct.setProductId(productId);
        cartProduct.setQuantity(quantity);
        Double price = getPrice(productId, quantity);
        Double discount = getDiscount(price, productId, quantity);
        cartProduct.setPrice(price);
        cartProduct.setDiscount(discount);
        productService.addAmountToQuantity(productId, -quantity);
        shoppingCartService.addTotalPrice(cartId, price);
        shoppingCartService.addDiscount(cartId,discount);
        return cartProductRepository.save(cartProduct);
    }

    private Double getPrice(Integer productId, Integer quantity) {
        if(quantity <= 1) return productService.getProduct(productId).getProductPrice();
        List<ProductDiscountPref> discountPrefs= discountPrefService.findByProductId(productId);
        DiscountRule lastrule = null;
        for (ProductDiscountPref discountPref : discountPrefs) {
            DiscountRule rule = discountRuleService.getDiscountRule(discountPref.getDiscountRuleId());
            if(rule.getItemQuantity() < quantity){
                lastrule = rule;
            }
        }
        double origPrice = productService.getProduct(productId).getProductPrice();
        return (lastrule != null) ? origPrice * (quantity - 1) + (100-lastrule.getDiscountRate())/100 * origPrice : origPrice * quantity;
    }

    private Double getDiscount(Double price, Integer productId, Integer quantity){
        Double origPrice = productService.getProduct(productId).getProductPrice() * quantity;
        return origPrice - price;
    }


    public List<CartProduct> getAllCartProducts(){
        return this.cartProductRepository.findAll();
    }

    public CartProduct getCartProduct(Integer cartProductId){
        Optional<CartProduct> cartProductOptional = cartProductRepository.findById(cartProductId);
        //todo, throw exception
        return cartProductOptional.orElse(null);
    }

    public CartProduct addQuantityCartProduct(Integer cartId, Integer productId, Integer quantity) {
        Optional<CartProduct> cartProductOptional = cartProductRepository.findByProductId(productId);
        if(cartProductOptional.isPresent()){
            CartProduct cartProduct = cartProductOptional.get();
            int totalQuantity = cartProduct.getQuantity() + quantity;
            Double oldPrice = cartProduct.getPrice();
            Double oldDiscount = cartProduct.getDiscount();
            Double price = getPrice(productId, totalQuantity);
            Double discount = getDiscount(price, productId, totalQuantity);
            cartProduct.setPrice(price);
            cartProduct.setDiscount(discount);
            productService.addAmountToQuantity(productId, -quantity);
            shoppingCartService.changeCartPrice(cartId, oldPrice, price);
            shoppingCartService.changeCartDiscount(cartId,oldDiscount,discount);
            return cartProductRepository.save(cartProduct);
        }
        return null;
    }

    public void deleteCartProduct(Integer cartProductId){
        Optional<CartProduct> cartProductOptional = cartProductRepository.findById(cartProductId);
        if(cartProductOptional.isPresent()){
            cartProductRepository.deleteById(cartProductId);
        }
        //throw exception?
    }
}
