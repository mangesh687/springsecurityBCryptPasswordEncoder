package com.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.entity.Customer;
import com.springsecurity.service.CustoberService;

@RestController
public class CustoberRestContoller {
	@Autowired
	private CustoberService custoberService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Customer c){
		
		//UsernameAndPasswordToken-->set login credentils for validation
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(c.getEmail(), c.getPwd());
	//verify login details vaild or not
		Authentication authentication=	authenticationManager.authenticate(token);
	boolean satus= authentication.isAuthenticated();
	if(satus) {
		return new ResponseEntity<>("welcome",HttpStatus.OK);
		
	}else {
		return new ResponseEntity<String>("Faild",HttpStatus.BAD_REQUEST);
	}
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustober(@RequestBody Customer c){
		boolean status=custoberService.saveCustomer(c);
		if(status) {
		return new ResponseEntity<>("success",HttpStatus.CREATED);	
		}else {
			return new ResponseEntity<>("Faield",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
