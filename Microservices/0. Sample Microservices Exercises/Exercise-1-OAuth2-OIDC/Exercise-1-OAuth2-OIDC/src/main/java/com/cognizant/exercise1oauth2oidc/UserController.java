package com.cognizant.exercise1oauth2oidc;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String home() {
        return "<h2>OAuth2 Login</h2><br><a href='/oauth2/authorization/google'>Login with Google</a>";
    }

    @GetMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }
}