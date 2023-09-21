package com.go2geda.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.Instant;

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
}
