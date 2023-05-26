package com.zensar.service;
import java.util.List;

import com.zensar.model.Users;

public interface OlxUserService
{
	// will accept user details user is and password and return JWT / Auth token
	public String loginUser(OlxUserDetail userDetail);
	public boolean logout(String authToken);
	public Users registerUser(Users user);
	public Users getUser(String authToken);
	public boolean validateToken(String authToken);
	public String loginUser1(OlxUserDetail userDetail);
	public Users findByUserName(String username);
	public  List<Users> findAll();
	List<Users> allusers();
	
}