package com.zensar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerTestController
{
	@GetMapping("swagger-test")
	public String getMessage()
	{
		return "This is message from swagger test controller";
	}
	
	@GetMapping("/exception-test")
	public void testException()
	{
		throw new UserNotFoundException("No user from swagger");
	}
}
