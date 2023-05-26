package com.zensar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class OlxSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	UserDetailsService userDetailsService;
	
	//Authentication ? where is user and password
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService);
//		auth.inMemoryAuthentication()
//		.withUser("Ramsingh").password("R_123").roles("ADMIN")
//		.and()
//		.withUser("Harish").password("Hr123").roles("User");
	}

	//Authorization(who is allowed to access what?
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{	
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/user").hasAnyRole("USER", "ADMIN")
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user/authenticate").permitAll()
		.antMatchers("/authenticate").permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/actuator/**").permitAll()
		.antMatchers("/status").permitAll()
		.and().formLogin();
	}
	
	@Bean
	PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
}
