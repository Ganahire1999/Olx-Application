//package com.zensar.controller;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//public class UserControllerTest 
//{	
//	void testLoginUser() 
//	{
//
//	}
//	void testLogoutUser() 
//	{
//
//	}
//	void testGetUser() 
//	{
//		//i want to connect to the other application running and get data from it
//		RestTemplate templ = new RestTemplate();
//		String url = "http://localhost:9000/user";
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Authorization","Auth-Token-Ramsingh");
//		HttpEntity<String> entity = new HttpEntity<>(headers);
//
//		// ResponseEntity<String> result = templ.exchange(url, HttpMethod.POST, entity, String.class);
//		ResponseEntity<String> response = templ.exchange(url, HttpMethod.GET, entity, String.class);
//		String body = response.getBody();
//		System.out.println(body);
//	}
//}
