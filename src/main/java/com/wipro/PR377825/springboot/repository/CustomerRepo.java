package com.wipro.PR377825.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.PR377825.springboot.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, String> {

}
