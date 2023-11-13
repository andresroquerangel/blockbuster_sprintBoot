package com.example.modeladov1.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

public class TokenUtil {
    private final static String ACCESS_TOKEN_SECRET = "4qhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud";

    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;

    public static String createToken(String nombre, String email, Collection<? extends GrantedAuthority> roles){
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS*1000;
        Date expirationDate = new Date(System.currentTimeMillis()+expirationTime);
        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre",nombre);
        List<String> rolesAsStrings = roles.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        extra.put("roles", rolesAsStrings);
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();

    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try{
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            List<String> roles = (List<String>) claims.get("roles");

            // Crear una lista de objetos GrantedAuthority a partir de las cadenas de roles
            List<GrantedAuthority> authorities = roles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
            String email = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(email,null, authorities);
        }catch(JwtException e){
            return null;
        }
    }
}
