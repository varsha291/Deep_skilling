package com.cognizant;

import com.cognizant.exception.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandlerTest {

    @Test
    void testHandleNotFound() {
        GlobalExceptionHandler handler =
                new GlobalExceptionHandler();

        ResponseEntity<String> response =
                handler.handleNotFound(
                        new NoSuchElementException());

        assertEquals(404,
                response.getStatusCode().value());

        assertEquals("User not found",
                response.getBody());
    }
}