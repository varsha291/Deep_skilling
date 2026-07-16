package com.cognizant.exercise1userordermanagement;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderController(
            OrderRepository orderRepository,
            UserRepository userRepository) {

        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {

        User user = userRepository
                .findById(order.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return orderRepository.save(order);
    }
}