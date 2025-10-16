package com.lovestoblog.vitornatal.eletronicraffle.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.lovestoblog.vitornatal.eletronicraffle.model.UserModel;
import org.flywaydb.core.internal.license.FlywayJWTValidationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(UserModel userModel){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("auth.api")
                    .withSubject(userModel.getEmail())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
        }catch(JWTCreationException exception){
            throw new RuntimeException("Error while creating the token", exception);
        }
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth.api")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch(FlywayJWTValidationException exception){
            return "";
        }
    }

    public Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
