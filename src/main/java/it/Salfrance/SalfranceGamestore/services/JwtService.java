package it.Salfrance.SalfranceGamestore.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Service
public class JwtService {
    private final String Secret_key;

    public JwtService(@Value("${SECRET_KEY}") String secretKey) { Secret_key = secretKey; }

    private SecretKey getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(Secret_key);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractUsername(String token) {return extractClaim(token,Claims::getSubject);}

    public Date extractExpiration(String token){return extractClaim(token,Claims::getExpiration);}

    public boolean isTokenExpired(String token) { return extractExpiration(token).before(new Date());}
    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public String generateToken(Map<String, Object> extraClaims,UserDetails userDetails){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+10000))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateToken(UserDetails userDetails){ return generateToken(new HashMap<>(),userDetails);}
}
