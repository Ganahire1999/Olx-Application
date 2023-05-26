package com.zensar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Categories;
import com.zensar.service.CategoryService;

@RestController
public class MasterDataController
{
	@Autowired
	CategoryService catService;

	@Autowired
	MyUserFeignClient userClient;

	@GetMapping("/advertise/category")
	List<Categories> getAllCategories()
	{

		return catService.getCategories();
	}
	@GetMapping("/advertise/status")
	List<Categories> getAllStatus()
	{
		//want to send a request to localhost:9000/user/authenticate (with data userName, password)
		//		RestTemplate restTmp = new RestTemplate();
		//		restTmp.exchange(entity, String.class);
		return catService.getCategories();
	}
	@GetMapping ("/advertise/test-feign")
	public String testFeignClient()
	{
		Map<String,String> map   = new HashMap<>();
		map.put("userName", "Ramsingh");
		map.put("password", "R_123");
		String jwt = userClient.getJwt(map);
		System.out.println("JWT from OLX-LOGIN APP " + jwt);

		//my token= " eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJSYW1zaW5naCIsImV4cCI6MTY1Mjk5MTAzNCwiaWF0IjoxNjUyOTU1MDM0fQ.sAo8fya-jEMUQImcK28hptxqrxAoYIOjLyda6tqkozE"
		String user = userClient.getUser("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJSYW1zaW5naCIsImV4cCI6MTY1Mjk5MTAzNCwiaWF0IjoxNjUyOTU1MDM0fQ.sAo8fya-jEMUQImcK28hptxqrxAoYIOjLyda6tqkozE");
		System.out.println("user data from token :" + user);
		return "Feign Client Tested :" + user;
	}
	@GetMapping("/info2")
	public String getInfo()
	{
		String info2 = userClient.getInfo();
		return "masterdata app got" +info2;
	}
}