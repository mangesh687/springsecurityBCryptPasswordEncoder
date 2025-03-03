package com.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.springsecurity.service.CustoberService;

import lombok.SneakyThrows;

@Configuration
@EnableWebSecurity
public class Appconfig {
	
	@Autowired
	private CustoberService custoberService;
	
	//passowrd encyprtion
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		//to load the custober table form put to origanl password 
		//to load user record and give to auth manager
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		authenticationProvider.setUserDetailsService(custoberService);
		
		return authenticationProvider;
	}
	
	@Bean
	public 	AuthenticationManager authManager(AuthenticationConfiguration cofigs) throws Exception {
		// perform authentication
		return cofigs.getAuthenticationManager();
	} 
	
	
	@Bean
	@SneakyThrows
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		//logic 
		
		http.authorizeHttpRequests(req->req.requestMatchers("/register","/login")
				.permitAll()
				.anyRequest().authenticated());
		
		return http.csrf().disable().build();
	}
	
	
	
	

}
