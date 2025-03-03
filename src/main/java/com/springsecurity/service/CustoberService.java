package com.springsecurity.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.Customer;
import com.springsecurity.repository.CustoberRepository;

@Service
public class CustoberService implements UserDetailsService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private CustoberRepository customerRepo;

	
	public boolean saveCustomer(Customer c) {
	String encodeped=	bCryptPasswordEncoder.encode(c.getPwd());
	c.setPwd(encodeped);
		Customer savedCustober=customerRepo.save(c);
		return savedCustober.getCid() != null;
	}


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
	Customer c=customerRepo.findByEmail(email);
		return new User(c.getEmail(),c.getPwd(),Collections.emptyList());
	}

}
