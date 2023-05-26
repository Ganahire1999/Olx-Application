package com.zensar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnpredictedController {

	int count = 0;

	@GetMapping("/unpredicted")
	public String getData()
	{
		System.out.println("Request to unpredicted for " + count);
		count++;
		if(count > 40)
		{
			return "Service Running : olx-user-service2";
		}
		if(count > 50) count = 0;
		if(count > 35) 
		{ 
			try {	Thread.sleep(5000);	} catch (InterruptedException e) {	}
		} 
		if(count > 10)
		{
			if(count %5 == 0)
				return "Service Running : olx-user-service2";
			else throw new RuntimeException("Sorry service not running ");
		}
		if(count %3 == 0)
			return "Service Running : olx-user-service2";
		else throw new RuntimeException("Sorry service not running ");
	}

}
