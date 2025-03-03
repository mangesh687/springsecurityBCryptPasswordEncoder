package com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.entity.Customer;
@Repository
public interface CustoberRepository extends JpaRepository<Customer, Integer> {
public Customer findByEmail(String email);


}
