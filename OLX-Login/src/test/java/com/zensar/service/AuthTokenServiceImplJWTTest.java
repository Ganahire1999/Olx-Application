package com.zensar.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthTokenServiceImplJWTTest
{
	@Autowired
	AuthTokenServiceImplJWT authTokenServiceImplJWT;

	@Test
	void testGenerateToken()
	{
		OlxUserDetail userA = new OlxUserDetail();
		userA.setUserName("Ramsingh");
		userA.setPassword("R_123");
		String token = authTokenServiceImplJWT.generateToken(userA);
		assertNotNull(token);
	}

	@Test
	void testGetUserName()
	{

	}
}