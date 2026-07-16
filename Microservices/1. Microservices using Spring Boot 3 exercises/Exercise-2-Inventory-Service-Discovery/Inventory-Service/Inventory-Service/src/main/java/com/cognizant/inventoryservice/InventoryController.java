package com.cognizant.inventoryservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @GetMapping
    public List<Inventory> getInventory() {

        return List.of(
                new Inventory(1L, "Laptop", 10),
                new Inventory(2L, "Mobile", 25),
                new Inventory(3L, "Headphones", 50)
        );
    }
}