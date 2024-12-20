package com.gensanitydev.ServerGenSanHotel.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTUtils {

    private static final long EXPIRATION_TIME = 1000 * 60 * 24 * 7; //for 7 days

    private final SecretKey Key;

    public JWTUtils() {
        String secretString = "adc5607c2776089d02b2b186b3f607975387582ed36e58b30aed7558fbf62fc3690d8562c3e31a029acf9cbd263cd9a9b0a689fc49244cf3cb639c2beaaef891b7217a869bfaf2d6f008fa24025665209c8d4b4653ac62a597265e28adf4e9ff912746d891ff5c4f6adae28766d2b4d94866cec902e56b72a4464458927635a0c8580c1ba88ef7ee3a770c13a236c12f3b665cfb9f3cb9abb74b42c786aea35fb38bd51c4307858f5e2ca01a99addd8cb8e7cc21688a87c95f5d6ca510d4f3f9a9aedec1d788e05151be1faaf9d977f49169a423b2b6364f7df43dd91d5439f185837a1fc79d487afccbe8fdbc8cc1ffc9147456a829e1faa316ce9d8f26d8fa";
        byte[] keyBytes = Base64.getDecoder().decode(secretString.getBytes(StandardCharsets.UTF_8));
        this.Key = new SecretKeySpec(keyBytes, "HmacSHA256");
    }

    public String generateToken(UserDetails userDetails){
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Key)
                .compact();

    }

    public String extractUserName(String token){
        return extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction){
        return claimsTFunction.apply(Jwts.parser().verifyWith(Key).build().parseSignedClaims(token).getPayload());
    }

    public boolean isValidToken(String token, UserDetails userDetails){
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token){
        return extractClaims(token, Claims::getExpiration).before(new Date());
    }
}