package com.wipro.PR377825.springboot.services;

import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.PR377825.springboot.Controller.ResetPWContoller;
import com.wipro.PR377825.springboot.entity.Customer;
import com.wipro.PR377825.springboot.repository.CustomerRepo;

@Service
public class ResetPwService 
{
	@Autowired
	CustomerRepo custRepo;	
	@Autowired
	ResetPWContoller resetCtrl;
	
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
	
	public String updatePassword(String Id) throws EntityNotFoundException
	{
		Customer DBobj = custRepo.findById(Id).get();
		System.out.println("Password from resetPW controller: "+resetCtrl.getPassword());
		DBobj.setPassword(resetCtrl.getPassword());
		custRepo.save(DBobj);
		System.out.println("Password updated successfully for "+Id);
		return null;		
	}
}
