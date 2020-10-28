package com.misolab.core.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class JwtTest {

    private static final String SUBJECT = "JwtTest";
    private static final String NAME = "claim";
    private static final Integer VALUE = 100;
    private static final String SECRET = "MISOLAB";
    private static final long EXPIRATION_TIME = 1000 * 1;    //  1 min

    JwtProperties jwtProperties = new JwtProperties() {
        @Override
        public Algorithm algorithm() {
            return Algorithm.HMAC512(SECRET.getBytes());
        }

        @Override
        public Date expirationTime() {
            return new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        }
    };

    @Test
    void jwtTest() throws InterruptedException {
        String token = JWT.create()
                .withSubject(SUBJECT)
                .withClaim(NAME, VALUE)
                .withExpiresAt(jwtProperties.expirationTime())
                .sign(jwtProperties.algorithm());
        assertNotNull(token);

        DecodedJWT decode = JWT.require(jwtProperties.algorithm())
                .build()
                .verify(token);

        assertNotNull(decode);
        assertEquals(decode.getSubject(), SUBJECT);
        assertEquals(decode.getClaim(NAME).asInt(), VALUE);

        Thread.sleep(EXPIRATION_TIME * 2);

        assertThrows(TokenExpiredException.class, () -> {
            JWT.require(jwtProperties.algorithm())
                    .build()
                    .verify(token);
        });
    }

}
