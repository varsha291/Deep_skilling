package com.cognizant.exercise3jwt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    private final JwtTokenProvider jwtTokenProvider;

    public JwtController(
            JwtTokenProvider jwtTokenProvider) {

        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping("/token/{username}")
    public String generateToken(
            @PathVariable String username) {

        return jwtTokenProvider.createToken(username);
    }

    @GetMapping("/secure")
    public String secure() {

        return "JWT Secure Endpoint Accessed Successfully";
    }
}