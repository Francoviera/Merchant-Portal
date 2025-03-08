package com.backOffice_electric_cooperative.demo.application.services;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@NoArgsConstructor
public class JwtService {

    private static final String SECRET_KEY = "DC21FC9719CBBD9F74C51A84B1E78";

    public String extractEmail(String Jwt){
        return "";
    }

    public String extractUserName(String token){
        return extractClaims(token, Claims::getSubject); // how it you can extract others claims that token contains
    }

    public <T> T extractClaims(String token, Function<Claims,T> claimsResolvers){
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token){
        return extractClaims(token, Claims::getExpiration);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        return Jwts
                .builder()                              // 1️⃣ Create a JWT builder
                .setClaims(extraClaims)                // 2️⃣ Add extra custom claims
                .setSubject(userDetails.getUsername()) // 3️⃣ Set the subject (username)
                .setIssuedAt(new Date(System.currentTimeMillis())) // 4️⃣ Set the token creation time
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) // 5️⃣ Set expiration (24 minutes)
                .signWith(getSignInKey(), SignatureAlgorithm.HS256) // 6️⃣ Sign with secret key using HS256
                .compact();                             // 7️⃣ Convert to a compact JWT string
    }


    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder() // Creates a JWT parser
                .setSigningKey(getSignInKey()) // Sets the secret key to validate the token, it verify that the message doesnt change
                .build()//  Builds the JWT parser
                .parseClaimsJws(token) // Parses the token and verifies its signature
                .getBody(); // Extracts the claims (payload)
    }

    private Key getSignInKey(){
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
