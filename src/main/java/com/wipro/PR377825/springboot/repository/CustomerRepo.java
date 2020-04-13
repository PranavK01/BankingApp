package com.wipro.PR377825.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.PR377825.springboot.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String>
{
	Customer findByPhone(String num);
	
	
	@Query(value = "SELECT email FROM Customer", nativeQuery = true)	
	List<Customer> findAllEmail();
	
	@Query(value = "SELECT contact_num FROM Customer", nativeQuery = true)	
	List<Customer> findAllContact();
}
