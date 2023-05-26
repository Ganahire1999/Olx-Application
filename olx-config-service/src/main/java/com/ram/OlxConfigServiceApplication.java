package com.ram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableAutoConfiguration

@EnableWebMvc
public class OlxConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxConfigServiceApplication.class, args);
	}

}
