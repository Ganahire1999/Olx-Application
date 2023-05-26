package com.zensar.service;

public interface AuthTokenService 
{
	public String generateToken(OlxUserDetail userDetail);
	String getUserName(String authToken);

}
