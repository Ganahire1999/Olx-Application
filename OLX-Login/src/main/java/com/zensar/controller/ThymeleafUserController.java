package com.zensar.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zensar.model.Users;
import com.zensar.service.OlxUserService;

@Controller
public class ThymeleafUserController
{
	@Autowired
	OlxUserService userService;

	private static final Logger log = LoggerFactory.getLogger(ThymeleafUserController.class);

	@RequestMapping("/testMvc")
	public String getMvcpage(ModelMap modelMap)
	{
		log.debug("getMvcpage fro testMvc called up");
		//Model
		modelMap.put("name","Ramsingh Patel");

		return "test-mvc"; //assuming name of page  html is added automatically by thymeleaf
	}

	@RequestMapping("/allUsers")
	public String getAllUsers(ModelMap modelMap)
	{
		log.debug("getAllUsers called up");
		//Model
		List<Users> userList = userService.findAll();
		modelMap.put("name","Ramsingh Patel");
		modelMap.put("allusers",userList);

		return "test-mvc"; //assuming name of page  html is added automatically by thymeleaf
	}
	@GetMapping("/mymessage")
	public String showMessages(@RequestParam("username") String name, ModelMap model)
	{
		//call some service to get the message for this user
		List<String> messages = Arrays.asList("You are registered", "meeting at 9am", "saturday is holiday");
		model.put("name", name);
		model.put("time", new Date());
		model.put("message", messages);
		return "show-message"; //name of html page that will show the data
	}
		
}





