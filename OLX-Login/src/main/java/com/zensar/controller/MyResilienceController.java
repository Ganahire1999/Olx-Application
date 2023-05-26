//package com.zensar.controller;
//
//import java.util.HashMap;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
////import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
////import io.github.resilience4j.retry.annotation.Retry;
//
////how many times to retry 
////how much time to wait
//// %age of failed attempts : Totally Failed 
//// after how much time to check to the totally failed service ? 
//// time i should some test ping ? Are you up?
//
//@RestController
//public class MyResilienceController {
//	int attempt = 1;
//	int breakAttempt = 1;
//
//	@Autowired
//	private OlxUserServiceClient client;
//
//	@Autowired
//	OlxUserFeignClient client2;
//
//	@GetMapping("/test")
//	public String getTestReportNormal()
//	{
//		System.out.println("Attempt number = " + attempt++);
//		String response = client.getResponse(); //unpredicted 
//		String token = client2.getToken(new HashMap<>());
//		return "test :" + token + " , " + response;
//	}
//
//
//	@GetMapping("/testretry")
//	@Retry(fallbackMethod = "onErrorMethod", name="myretry")
//	public String getTestReport()
//	{
//		System.out.println("Attempt number = " + attempt++);
//		String response = client.getResponse(); //unpredicted 
//		String token = client2.getToken(new HashMap<>());
//		return "test :" + token + " , " + response;
//	}
//
//	@GetMapping("/testbreaker")
//	@Retry(fallbackMethod = "onErrorMethod",name="myretry")
//	@CircuitBreaker(name="mycustombreaker", fallbackMethod = "onErrorMethod")
//	public String getTestReportBreaker()
//	{
//		System.out.println("break Attempt number = " + breakAttempt++);
//		String response = client.getResponse();
//		String token = client2.getToken(new HashMap<>());
//		return "breaker test :" + token + " , " + response;
//	}
//
//
//	public String onErrorMethod(Exception e)
//	{
//		return " Some other microservice is not responding : Fallback Respose ";
//	}
//
//}
