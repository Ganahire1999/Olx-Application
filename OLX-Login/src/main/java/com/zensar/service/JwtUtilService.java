package com.zensar.service;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtilService {
	private static final Logger log = LoggerFactory.getLogger(JwtUtilService.class);

//	@Value("${olx-login.logintime")
//	Long logintime;
	
	private final String secretKey  = "mysecret";

	public String generateToken(Map<String,Object> claims, String username)
	{
		//set username , issuetime, expiration time,
		//sign it
		log.info("Generating token for user "  + username + " with data " + claims);
		String token = Jwts.builder().setClaims(claims)
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 10 * 3600 * 1000))
				.signWith(SignatureAlgorithm.HS256,secretKey)
				.compact();
		log.debug("token = {}", token);
		return token;

	}
	public Claims getClaims(String token)
	{
		Claims claims = Jwts.parser().setSigningKey(secretKey)
				.parseClaimsJws(token).getBody();
		log.debug("claims = {}", claims);
		return claims;
	}
	public boolean validateToken(String token, String username)
	{
		String subject = getClaims(token).getSubject();
		Date expiration = getClaims(token).getExpiration();
		if(subject.equals(username) || ! expiration.before(new Date()))
			return true;
		return false;
	}
	public String getUserName(String token)
	{
		return getClaims(token).getSubject();
	}
	public Date getExpiration(String token)
	{
		return getClaims(token).getExpiration();
	}

}