package com.lovestoblog.vitornatal.eletronicraffle.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lovestoblog.vitornatal.eletronicraffle.model.UserModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(UserModel userModel){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withClaim("userId", userModel.getId())
                    .withSubject(userModel.getEmail())
                    .withExpiresAt(genExpirationDate())
                    .withIssuedAt(Instant.now())
                    .withIssuer("API ERaffle")
                    .sign(algorithm);
        }catch(JWTCreationException exception){
            throw new RuntimeException("Error while creating the token", exception);
        }
    }

    public Optional<JWTUserData> validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            DecodedJWT decode = JWT.require(algorithm)
                    .build()
                    .verify(token);

            return Optional.of(JWTUserData.builder()
                    .email(decode.getSubject())
                    .userId(decode.getClaim("userId").asLong())
                    .build());

        } catch (JWTVerificationException ex) {
            return Optional.empty();
        }
    }

    public Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
