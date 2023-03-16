package com.stockmarket.auth.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.stockmarket.auth.exception.StockAuthException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;


@Component
public class JwtUtil {
	
	@Value("${jwt.secret}")
	private String jwtSecret;

//	@Value("${jwt.token.validity}")
	private final long tokenValidity = 180000;

	public Claims getClaims(final String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
			return body;
		} catch (Exception e) {
			System.out.println(e.getMessage() + " => " + e);
		}
		return null;
	}

	public String generateToken(String userName) {
		Claims claims = Jwts.claims().setSubject(userName);
		long nowMillis = System.currentTimeMillis();
		long expMillis = nowMillis + tokenValidity;
		Date exp = new Date(expMillis);
		jwtSecret = jwtSecret==null?"secret":jwtSecret;
		return Jwts.builder().setClaims(claims).setIssuedAt(new Date(nowMillis)).setExpiration(exp)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public void validateToken(final String token) throws StockAuthException, Exception {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
		} catch (SignatureException ex) {
			throw new StockAuthException("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			throw new StockAuthException("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			throw new StockAuthException("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			throw new StockAuthException("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			throw new StockAuthException("JWT claims string is empty.");
		} catch (Exception e) {
			throw new StockAuthException(e.getMessage());
		}

	}
}
