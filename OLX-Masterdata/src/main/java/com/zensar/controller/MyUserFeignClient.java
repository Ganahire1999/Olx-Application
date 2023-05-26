package com.zensar.controller;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

//@FeignClient (name="OLX-LOGIN", url = "http://localhost:9000")

@FeignClient (name="OLX-LOGIN")
public interface MyUserFeignClient
{
	@PostMapping("/user/authenticate")
	public String getJwt(@RequestBody Map<String, String> map);
	
	@GetMapping("/user")
	public String getUser(@RequestHeader("Authorization") String jwt);
	
//	eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkaW5lc2giLCJleHAiOjE2NTI3MTE0NDYsImlhdCI6MTY1MjY3NTQ0Nn0.-7BswYR62EQsRvuJK9liicVqoSWA45g3q6Cp3-g4e0Q
	
	@GetMapping("/token/validate")
	public String getValidatoinStatus(@RequestHeader("Authorization") String jwt);
	
	@GetMapping("/info")
	public String getInfo();
	
	

}
