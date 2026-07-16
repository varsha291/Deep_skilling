package com.cognizant.paymentservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final String PAYMENT_SERVICE = "paymentService";

    @CircuitBreaker(name = PAYMENT_SERVICE, fallbackMethod = "paymentFallback")
    public String processPayment() {

        System.out.println("Calling third-party payment service...");

        throw new RuntimeException("Third-party payment service unavailable");
    }

    public String paymentFallback(Throwable throwable) {

        System.out.println("Fallback method executed");

        return "Payment service is temporarily unavailable. Please try again later.";
    }
}