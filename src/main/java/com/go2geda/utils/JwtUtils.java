package com.go2geda.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.Instant;
import java.util.List;

import static com.go2geda.utils.AppUtils.APP_NAME;

public class JwtUtils {
    public static String generateVerificationToken(String email){
        String token = JWT.create()
                .withClaim("user", email)
                .withIssuer(APP_NAME)
                .withExpiresAt(Instant.now().plusSeconds(3600))
                .sign(Algorithm.HMAC512("null_value"));
        return token;
    }

    public static String generateAccessToken(List<String> authorities){
        String token = JWT.create()
                .withClaim("roles", authorities)
                .withIssuer(APP_NAME)
                .withExpiresAt(Instant.now().plusSeconds(3600*24))
                .sign(Algorithm.HMAC512("secret"));
        return token;
    }
}
