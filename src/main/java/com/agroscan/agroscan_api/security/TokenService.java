package com.agroscan.agroscan_api.security;

import com.agroscan.agroscan_api.model.UsuarioApp;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private static final String SECRET = "agroscan-secret-key";

    public String gerarToken(UsuarioApp usuario) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        return JWT.create()
                .withIssuer("agroscan-api")
                .withSubject(usuario.getEmail())
                .withExpiresAt(gerarExpiracao())
                .sign(algorithm);
    }

    public String validarToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        return JWT.require(algorithm)
                .withIssuer("agroscan-api")
                .build()
                .verify(token)
                .getSubject();
    }

    private Instant gerarExpiracao() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}