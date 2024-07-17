package com.alura.foro_hub.infra.security;

import com.alura.foro_hub.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;


@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generateToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("foro_hub")
                    .withSubject(usuario.getNombre()) //this is the username, name in this case
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(expiryDate())
                    .sign(algorithm); //this is the token

        } catch (JWTCreationException exception) {
            throw new RuntimeException(); //just not to leave it empty
        }
    }

    public String getSubject(String token) {
        if (token == null) {
            throw new RuntimeException("Token invalido");
        }
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("foro_hub")
                    .build()
                    .verify(token);
            verifier.getSubject();

        } catch (JWTVerificationException exception){
            System.out.println(exception.toString());
        }
        if (verifier.getSubject() == null) {
            throw new RuntimeException("verificacion invalida");
        }
        return verifier.getSubject();
    }
    public Instant expiryDate() {
        return LocalDateTime.now()
                .plusHours(2)
                .atZone(ZoneId.of("America/Mexico_City"))
                .toInstant();
    }
}