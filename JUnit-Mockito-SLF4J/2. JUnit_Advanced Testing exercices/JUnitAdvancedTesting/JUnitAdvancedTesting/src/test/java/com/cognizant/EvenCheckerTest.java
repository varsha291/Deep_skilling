package com.cognizant;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvenCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testEvenNumbers(int number) {
        EvenChecker checker = new EvenChecker();

        assertTrue(checker.isEven(number));
    }
}