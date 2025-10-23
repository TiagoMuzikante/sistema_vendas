package space.vendas.sistema.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

  private String secret = "umaChaveSuperSecretaDeNoMinimo32Caracteres!";

  private final Key key = Keys.hmacShaKeyFor(secret.getBytes());

  public boolean isTokenValid(String token){
    try {
      getClaims(token);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  public String tokenGenerator(String email){
    return Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4))
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
  }

  public String extractEmail(String token){
    return getClaims(token).getBody().getSubject();
  }

  private Jws<Claims> getClaims(String token){
    return Jwts.parserBuilder()
        .setSigningKey(key)
        .build()
        .parseClaimsJws(token);
  }



}
