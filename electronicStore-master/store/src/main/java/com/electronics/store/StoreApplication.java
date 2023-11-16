package com.electronics.store;


import com.electronics.store.model.*;
import com.electronics.store.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class StoreApplication {

	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(StoreApplication.class);

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DiscountRuleRepository discountRuleRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductDiscountPrefRepository productDiscountPrefRepository;

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
		logger.info("Electronics App Started Successfully");
	}

	@Bean
	public CommandLineRunner cmd(){
		return args ->{
			customerRepository.save(new Customer("John", "email", "password"));
			productRepository.save(new Product("TV", 1000.0, 100));
			discountRuleRepository.save(new DiscountRule(1, 50.0));
			discountRuleRepository.save(new DiscountRule(2, 60.0));
			productDiscountPrefRepository.save(new ProductDiscountPref(1, 1));
			productDiscountPrefRepository.save(new ProductDiscountPref(1, 2));
		};
	}

}
