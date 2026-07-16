package com.cognizant.customerservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping
    public Map<String, Object> getCustomer() {
        return Map.of(
                "id", 1,
                "name", "Ishu",
                "email", "ishu@gmail.com"
        );
    }
}