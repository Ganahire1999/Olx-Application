package com.zensar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zensar.model.Users;
import com.zensar.service.AuthTokenService;
import com.zensar.service.OlxUserDetail;
import com.zensar.service.OlxUserService;
@RestController
public class UserController 
{
	// private static logger log = LoggerFactory.getLogger("com.zensar");
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	OlxUserService userService;

	@Autowired
	AuthTokenService authService;

	@PostMapping(path="/user/add", consumes="multipart/form-data")
	public String getUser(@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("pic") MultipartFile file )
	{
		//convert file to Blob using java.sql.SimpleBlob
		//save it in user object
		//use user repo to save in db.

		System.out.println("received " + username + "," + password + ", " + file.getOriginalFilename());
		return "data received ";
	}

	//1
	@PostMapping(path = "/user/authenticate", consumes = "application/json")
	public String loginUser(@RequestBody OlxUserDetail userDetail)
	{
		//System.out.println("Controller loginUser  for {}", userDetail);
		log.info("Controller loginUser  for {}", userDetail);
		return userService.loginUser(userDetail);
	}

	//2. 
	@DeleteMapping("/user/logout")
	public Boolean logoutUser(@RequestHeader("Authorization") String authToken)
	{
		log.info("Logout request for {}", authToken);
		return userService.logout(authToken);
	}

	//3.
	@PostMapping(path = "/user", consumes = "application/json")
	public String registerUser(@RequestBody Users user)
	{
		log.info("Controller registerUser  for {}", user);
		Users authToken = userService.registerUser(user);
		return null;
	}

	//4
	@GetMapping("/user")
	public Users getUser(@RequestHeader("Authorization") String authToken) throws Exception
	{
		String username = authService.getUserName(authToken);
		log.info("token received {}", authToken);
		Users user = userService.findByUserName(username);

		if(user == null)
			throw new Exception("User does not Exist");

		log.info("user in controller {}",user);
		return user;
	}
	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex)
	{
		return ex.getMessage();
	}

	//5
	@GetMapping("/token/validate")
	public boolean validateToken(@RequestHeader("Authorization") String authToken)
	{
		log.info("Validating request for {}", authToken);
		return userService. validateToken(authToken);
	}
	@GetMapping("/info")
	public String getInfo()
	{
		return "login app is running";
	}
}
