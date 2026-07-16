package com.cognizant;

import com.cognizant.service.CalculatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorParameterizedTest {

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "2, 3, 5",
            "5, 5, 10"
    })
    void testAdd(int a, int b, int expected) {
        CalculatorService service =
                new CalculatorService();

        assertEquals(
                expected,
                service.add(a, b)
        );
    }
}