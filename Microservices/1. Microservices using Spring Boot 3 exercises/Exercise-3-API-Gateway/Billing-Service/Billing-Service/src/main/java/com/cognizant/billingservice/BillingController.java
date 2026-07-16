package com.cognizant.billingservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @GetMapping
    public Map<String, Object> getBilling() {
        return Map.of(
                "billId", 101,
                "customerId", 1,
                "amount", 5000
        );
    }
}