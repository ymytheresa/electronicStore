package com.electronics.store.controller;

import com.electronics.store.service.DiscountRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.electronics.store.model.DiscountRule;

import java.util.List;

@RestController
@RequestMapping("/api/discountRule")
public class DiscountRuleController {
    @Autowired
    private DiscountRoleServiceImpl discountRuleService;

    @GetMapping("/all")
    public List<DiscountRule> getAllDiscountRules(){
        return discountRuleService.getAllDiscountRules();
    }

    @GetMapping("/{discountRuleId}")
    public DiscountRule getDiscountRule(@PathVariable Integer discountRuleId){
        return discountRuleService.getDiscountRule(discountRuleId);
    }

    @PostMapping
    public DiscountRule createDiscountRule(@RequestBody DiscountRule discountRule){
        return discountRuleService.createDiscountRule(discountRule);
    }

    @PutMapping
    public DiscountRule updateDiscountRule(@RequestBody DiscountRule discountRule){
        return discountRuleService.updateDiscountRule(discountRule);
    }

    @DeleteMapping("/{discountRuleId}")
    public void deleteDiscountRule(@PathVariable Integer discountRuleId){
        discountRuleService.deleteDiscountRule(discountRuleId);
    }



}
