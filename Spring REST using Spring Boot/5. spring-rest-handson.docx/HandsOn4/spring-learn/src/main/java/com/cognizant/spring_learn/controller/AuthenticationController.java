package com.cognizant.spring_learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authorizationHeader) {

        System.out.println("Start");

        // Remove "Basic "
        String encodedCredentials = authorizationHeader.substring(6);

        // Decode Base64
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);

        String credentials = new String(decodedBytes, StandardCharsets.UTF_8);

        System.out.println(credentials);

        // Split username and password
        String[] values = credentials.split(":");

        String username = values[0];

        Map<String, String> map = new HashMap<>();
        map.put("user", username);

        System.out.println("End");

        return map;
    }
}