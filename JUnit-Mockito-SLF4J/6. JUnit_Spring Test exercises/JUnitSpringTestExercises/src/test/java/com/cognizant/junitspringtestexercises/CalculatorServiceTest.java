package com.cognizant;

import com.cognizant.service.CalculatorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    @Test
    void testAdd() {
        CalculatorService service = new CalculatorService();

        int result = service.add(2, 3);

        assertEquals(5, result);
    }
}