package com.cognizant.exercise3jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final JwtConfig jwtConfig;

    public JwtTokenProvider(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(
                jwtConfig.getSecret().getBytes(StandardCharsets.UTF_8)
        );
    }

    public String createToken(String username) {

        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000);

        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(validity)
                .signWith(getKey())
                .compact();
    }

    public boolean validateToken(String token) {

        try {
            Jwts.parser()
                    .verifyWith(getKey())
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public Authentication getAuthentication(String token) {

        String username = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

        return new UsernamePasswordAuthenticationToken(
                username,
                null,
                new ArrayList<>()
        );
    }
}