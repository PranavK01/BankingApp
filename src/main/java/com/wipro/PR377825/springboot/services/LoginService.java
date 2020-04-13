package com.wipro.PR377825.springboot.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.PR377825.springboot.entity.Customer;
import com.wipro.PR377825.springboot.repository.CustomerRepo;


@Service
public class LoginService 
{
	@Autowired
	CustomerRepo custRepo;
	
	public String getID(String ID) throws EntityNotFoundException
	{ 
		Optional<Customer> Userid = custRepo.findById(ID);
		if(Userid.isPresent())
		{
			String userID = custRepo.getOne(ID).getUserId();
			System.out.println("userID from Db in getID function: "+userID);
			return userID;
		}
		return null;		
	}
	
	public String getPassword(String ID) throws EntityNotFoundException
	{
		String password = custRepo.getOne(ID).getPassword();
		System.out.println("password from Db in findpassword function: "+password);
		return password;
	}
}
