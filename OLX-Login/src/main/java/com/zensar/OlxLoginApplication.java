package com.zensar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
public class OlxLoginApplication 
{
//	private static final Logger Log = LoggerFactory.getLogger("com.zensar");
    private static final Logger Log = LoggerFactory.getLogger(OlxLoginApplication.class.getName());
    
	public static void main(String[] args) 
	{
		Log.trace("Trace message : lease priority");
        Log.debug("Method called with args" + args);
        Log.info("Application started");
        Log.warn("using unsecure connection");
        Log.error("complete details of the error");
		
		SpringApplication.run(OlxLoginApplication.class, args);
	}

}
