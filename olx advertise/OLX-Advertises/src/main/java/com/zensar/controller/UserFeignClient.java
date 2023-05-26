package com.zensar.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="OLX-LOGIN")
public interface UserFeignClient 
{	
	@GetMapping(path="/token/validate")
	public boolean validateToken(@RequestHeader("Authorization") String jwt);
	
	@GetMapping("/user")
	public String getUser(@RequestHeader("Authorization") String jwt);
	
}
