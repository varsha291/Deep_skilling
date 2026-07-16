package com.cognizant;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class PerformanceTesterTest {

    @Test
    void testPerformance() {
        PerformanceTester tester = new PerformanceTester();

        assertTimeout(
                Duration.ofSeconds(1),
                tester::performTask
        );
    }
}