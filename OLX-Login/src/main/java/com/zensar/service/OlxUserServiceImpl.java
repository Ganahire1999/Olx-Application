package com.zensar.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.zensar.model.Users;
import com.zensar.repo.UsersRepository;

@Service
public class OlxUserServiceImpl implements OlxUserService 
{
	private static final Logger log = LoggerFactory.getLogger(OlxUserServiceImpl.class);
	@Autowired
	UsersRepository usersRepository;

	@Override
	public String loginUser(OlxUserDetail userDetail) 
	{
		log.info("returing auth token for {}", userDetail);
		return "Auth-Token-" + userDetail.getUserName();
	}

	@Override
	public boolean logout(String authToken)
	{
		log.info(authToken, "{} logged out");
		return true;
	}

	@Override
	public Users registerUser(Users user)
	{
		// use repository to add a new user to the database

		return null;
	}

	@Override
	public Users getUser(String authToken)
	{
		String username = getUserName(authToken);
		return usersRepository.findByUsername(username).get(0);
	}

	private String getUserName(String authToken)
	{
		return authToken.substring("Auth-Token-".length());
	}

	@Override
	public boolean validateToken(String authToken)
	{
		log.info("validating {}", authToken);
		return true;
	}

	@Override
	
	public Users findByUserName(String username) 
	{
		return usersRepository.findByUsername(username).get(0);
	}

	@Override
	public List<Users> findAll() {
		return usersRepository.findAll();
	}

	@Override
	public List<Users> allusers() 
	{
		List<Users> allusers = usersRepository.findByUsername(getUserName(null));
		log.info("user in service {}", allusers);
		if(allusers.size()>0)
		return (List<Users>) allusers.get(0);
		else return null;
		
	}

	@Override
	public String loginUser1(OlxUserDetail userDetail) {
		return null;
	}

}