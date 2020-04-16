package com.wipro.PR377825.springboot.services;

import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.PR377825.springboot.entity.Customer;
import com.wipro.PR377825.springboot.repository.CustomerRepo;

@Service
@Transactional
public class ResetPwService 
{
	@Autowired
	CustomerRepo custRepo;	
	
	
	public String getID(String ID) throws EntityNotFoundException
	{ 
		String userID = "";
		Optional<Customer> Userid = custRepo.findById(ID);
		if(Userid.isPresent())
		{
			userID = custRepo.getOne(ID).getUserId();
			System.out.println("userID from Db in getID function: "+Userid);
			return userID;
		}
		else
			return null;		
	}
	
	public String updatePassword(String Id, String password) throws EntityNotFoundException
	{
		Customer DBobj = custRepo.findById(Id).get();
		System.out.println("Password from resetPW controller: "+password);
		DBobj.setPassword(password);
		custRepo.save(DBobj);
		System.out.println("Password updated successfully for "+Id);
		return null;		
	}
}
