package com.electronics.store;

import com.electronics.store.controller.*;
import com.electronics.store.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StoreApplication.class)
@WebAppConfiguration
public class StoreApplicationTests {
	private static final Logger logger = LoggerFactory.getLogger(StoreApplicationTests.class);

	@Autowired
	private CustomerController customerController;
	@Autowired
	private ProductController productController;
	@Autowired
	private ShoppingCartController shoppingCartController;
	@Autowired
	private DiscountRuleController discountRuleController;
	@Autowired
	private ProductDiscountPrefController productDiscountPrefController;
	@Autowired
	private CartProductController cartProductController;

	/*
	Existing resources :
			customerRepository.save(new Customer("John", "email", "password"));
			productRepository.save(new Product("TV", 1000.0, 100));
			discountRuleRepository.save(new DiscountRule(10, 0.1));
			discountRuleRepository.save(new DiscountRule(20, 0.2));
			productDiscountPrefRepository.save(new ProductDiscountPref(1, 1));
			productDiscountPrefRepository.save(new ProductDiscountPref(1, 2));
	 */

	@Test
	public void customerBuy1Product(){
		ShoppingCart cart = shoppingCartController.createShoppingCart(1);
		assertEquals(0.0, cart.getTotalPrice(), 0.0);
		logger.info("Total price : " + cart.getTotalPrice());

		shoppingCartController.updateShoppingCart(1, 1, 1);
		assertEquals(1000.0, shoppingCartController.getShoppingCart(1).getTotalPrice(), 0.0);
		assertEquals(0.0, shoppingCartController.getShoppingCart(1).getDiscount(), 0.0);
		logger.info("After buying one product: Total price : " + shoppingCartController.getShoppingCart(1).getTotalPrice());
	}

	@Test
	public void customerBuy3ProductWithDiscount(){
		ShoppingCart cart = shoppingCartController.createShoppingCart(1);
		assertEquals(0.0, cart.getTotalPrice(), 0.0);
		logger.info("Total price : " + cart.getTotalPrice());

		shoppingCartController.updateShoppingCart(1, 1, 1);
		assertEquals(1000.0, shoppingCartController.getShoppingCart(1).getTotalPrice(), 0.0);
		assertEquals(0.0, shoppingCartController.getShoppingCart(1).getDiscount(), 0.0);
		logger.info("After buying one product: Total price : " + shoppingCartController.getShoppingCart(1).getTotalPrice());

		shoppingCartController.updateShoppingCart(1, 1, 1);
		assertEquals(1500.0, shoppingCartController.getShoppingCart(1).getTotalPrice(), 0.0);
		assertEquals(500.0, shoppingCartController.getShoppingCart(1).getDiscount(), 0.0);
		logger.info("After buying two identical product: Total price : " + shoppingCartController.getShoppingCart(1).getTotalPrice());

		shoppingCartController.updateShoppingCart(1, 1, 1);
		assertEquals(2400.0, shoppingCartController.getShoppingCart(1).getTotalPrice(), 0.0);
		assertEquals(600.0, shoppingCartController.getShoppingCart(1).getDiscount(), 0.0);
		logger.info("After buying three identical product: Total price : " + shoppingCartController.getShoppingCart(1).getTotalPrice());
	}

	@Test
	public void customerRemoveProduct(){
		ShoppingCart cart = shoppingCartController.createShoppingCart(1);
		assertEquals(0.0, cart.getTotalPrice(), 0.0);
		logger.info("Total price : " + cart.getTotalPrice());

		shoppingCartController.updateShoppingCart(1, 1, 10);
		assertEquals(9400, shoppingCartController.getShoppingCart(1).getTotalPrice(), 0.0);
		logger.info("After adding 10 product: Total price : " + shoppingCartController.getShoppingCart(1).getTotalPrice());

		shoppingCartController.updateShoppingCart(1, 1, -9);
		assertEquals(1000, shoppingCartController.getShoppingCart(1).getTotalPrice(), 0.0);
		logger.info("After removing 9 product: Total price : " + shoppingCartController.getShoppingCart(1).getTotalPrice());

		shoppingCartController.updateShoppingCart(1, 1, -10);
		assertEquals(0, shoppingCartController.getShoppingCart(1).getTotalPrice(), 0.0);
		logger.info("After removing 10 product: Total price : " + shoppingCartController.getShoppingCart(1).getTotalPrice());
	}


}
