package com.zensar.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenServiceImpl implements AuthTokenService
{
	private static final Logger log = LoggerFactory.getLogger(AuthTokenServiceImpl.class);
	
	@Override
	public String generateToken(OlxUserDetail userDetail)
	{
		return "Auth-Token-" + userDetail.getUserName();
	}

	@Override
	public String getUserName(String authToken)
	{
		String usernameFromToken = authToken.substring("Autho-Token-".length()-1);
		log.debug("username from token =" + usernameFromToken);
		return usernameFromToken;
	}

}