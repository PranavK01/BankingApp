package com.wipro.PR377825.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.PR377825.springboot.entity.CurrentAccount;
import com.wipro.PR377825.springboot.entity.Customer;

@Repository
public interface CurrentAccRepo extends JpaRepository<CurrentAccount, Long> 
{
	CurrentAccount findByFKuserID(Customer userID);
}
