package com.zensar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zensar.controller.UserNotFoundException;
import com.zensar.model.Users;
import com.zensar.repo.UsersRepository;

@Service
@Primary
public class UserDetailsServiceImplJpa implements UserDetailsService
{
	
	/*
	 * class in db : Users username, password, roles
	 */
	@Autowired
	private UsersRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		List<Users> list = userRepo.findByUsername(username);
		if(list.size() == 0)
			throw new UserNotFoundException("User not found Username : " + username);
		Users user = list.get(0);
		return new UserDetailsWrapper(user);
	}

}