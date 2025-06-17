package com.appointment.server.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.HashAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private final SecretKey key = new SecretKeySpec("dskvjndkfjvnsklvndslkvsndklvdsnvkldsnvkdvdsklv".getBytes(),0,"dskvjndkfjvnsklvndslkvsndklvdsnvkldsnvkdvdsklv".getBytes().length, Jwts.SIG.RS256.toString());

    public String getJwtToken(String username){
        Map<String,Object> map = new HashMap<>();
        return Jwts.builder().claims(map).subject(username).signWith(key).issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+3600000))
                .compact();
    }

    public Claims getClaims(String token){
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
    }

    public <T> T getClaim(String token, Function<Claims,T> claimsTFunction){
        Claims claims = getClaims(token);
        return claimsTFunction.apply(claims);
    }

    public String getUsername(String token){
        return getClaim(token,Claims::getSubject);
    }

    public Date getExpiry(String token){
        return getClaim(token,Claims::getExpiration);
    }

    public Boolean isTokenExpire(String token){
        return getExpiry(token).before(new Date());
    }

    public Boolean isTokenVerified(String token , UserDetails userDetails){
        return (userDetails.getUsername().equals(getUsername(token)) && !isTokenExpire(token));
    }
}
