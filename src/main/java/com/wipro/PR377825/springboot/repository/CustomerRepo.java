package com.wipro.PR377825.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.PR377825.springboot.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String>
{
	Customer findByPhone(String num);
	
	Customer findByEmail(String email);
		
}
