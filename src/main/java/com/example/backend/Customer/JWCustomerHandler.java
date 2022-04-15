package com.example.backend.Customer;

import io.jsonwebtoken.*;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.UUID;


public class JWCustomerHandler {

    public String generateToken(Customer customer) {
        String secret = "adsfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";

        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS256.getJcaName());

        Instant now = Instant.now();

        String jwToken = Jwts.builder()
                .claim("username", customer.getUser_name())
                .setSubject(String.valueOf(customer.getUser_name()))
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(1L, ChronoUnit.MINUTES)))
                .signWith(getKey())
                .compact();

        return jwToken;
    }

    public String validateToken(String token) {
        String s = "";
        try {
            Jws<Claims> jwt = Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token);

            s = jwt.getBody().getSubject();
        } catch (Exception e){
            s = "invalid token";
        }
        return s;

    }

    private Key getKey() {
        String secret = "adsfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS256.getJcaName());
        return hmacKey;
    }
}
