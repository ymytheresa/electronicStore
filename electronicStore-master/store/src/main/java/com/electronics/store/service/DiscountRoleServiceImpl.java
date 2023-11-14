package com.electronics.store.service;

import com.electronics.store.model.DiscountRule;
import com.electronics.store.repository.DiscountRuleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class DiscountRoleServiceImpl {
    @Autowired
    private DiscountRuleRepository discountRuleRepository;

    public DiscountRule createDiscountRule(DiscountRule discountRule) {
        Optional<DiscountRule> existingRule = discountRuleRepository.findByQtyAndDisRate(discountRule.getItemQuantity(), discountRule.getDiscountRate());
        if (existingRule.isPresent()) {
            return existingRule.get();
        } else {
            return discountRuleRepository.save(discountRule);
        }
    }

    public DiscountRule getDiscountRule(Integer discountRuleId){
        Optional<DiscountRule> discountRuleOptional = discountRuleRepository.findById(discountRuleId);
        if(discountRuleOptional.isPresent()){
            return discountRuleOptional.get();
        }
        return null; //todo, throw exception
    }

    public List<DiscountRule> getAllDiscountRules(){
        return this.discountRuleRepository.findAll();
    }

    public DiscountRule updateDiscountRule(DiscountRule discountRule){
        Optional<DiscountRule> discountRuleOptional = discountRuleRepository.findById(discountRule.getDiscountRuleId());
        if(discountRuleOptional.isPresent()){
            discountRuleRepository.deleteById(discountRule.getDiscountRuleId()); //todo, replace instead of remove then add later
            return discountRuleRepository.save(discountRule);
        }
        return null; //todo, throw exception
    }

    public void deleteDiscountRule(Integer discountRuleId){
        Optional<DiscountRule> discountRuleOptional = discountRuleRepository.findById(discountRuleId);
        if(discountRuleOptional.isPresent()){
            discountRuleRepository.deleteById(discountRuleId);
        }
        //throw exception?
    }

}
