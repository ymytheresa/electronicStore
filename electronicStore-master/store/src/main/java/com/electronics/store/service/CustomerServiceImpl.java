package com.electronics.store.service;

import com.electronics.store.model.Customer;
import com.electronics.store.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Integer customerId){
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isPresent()){
            return customerOptional.get();
        }
        return null; //todo, throw exception
    }

    public List<Customer> getAllCustomers(){
        return this.customerRepository.findAll();
    }
    public Customer updateCustomer(Integer customerId, Customer customer){
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isPresent()){
            customerRepository.deleteById(customerId); //todo, replace instead of remove then add later
            return customerRepository.save(customer);
        }
        return null; //todo, throw exception
    }

    public void deleteCustomer(Integer customerId){
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isPresent()){
            customerRepository.deleteById(customerId);
        }
        //throw exception?
    }

}
