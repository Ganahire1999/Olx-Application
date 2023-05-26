package com.zensar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class AllExceptionHandler extends ResponseEntityExceptionHandler
{
	private static final Logger Log = LoggerFactory.getLogger(AllExceptionHandler.class); 
	
	@ExceptionHandler(UserNotFoundException.class)
	public String handleUserNotFound()
	{
		Log.error("User not found");
		return "This user does not exist";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleSomeException(Exception ex)
	{
		Log.error("{}", ex);
		return "some error occured";
	}

}
