package com.wipro.PR377825.springboot.services;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.PR377825.springboot.repository.CustomerRepo;


@Service
public class DashboardService 
{
	@Autowired
	CustomerRepo custRepo;	
		
	
	public String findUserName(String ID) throws EntityNotFoundException
	{ 
		String firstName = custRepo.getOne(ID).getFirstName();
		String lastName = custRepo.getOne(ID).getLastName();
		String customerName = firstName + " " + lastName;
		System.out.println("UserName from db in dashboard service: "+customerName);
		return customerName;
	
	}

	public Long[] findAccountNumber(String ID) throws EntityNotFoundException
	{ 
		Long savingAccNumber = custRepo.getOne(ID).getSavingAccNum();
		Long currentAccNumber = custRepo.getOne(ID).getCurrentAccNum();
		Long[] accNumber = {savingAccNumber,currentAccNumber};
		
		System.out.println("savingAccNumber from db in dashboard service: "+accNumber[0]);
		System.out.println("currentAccNumber from db in dashboard service: "+accNumber[1]);
		
		return accNumber;
	
	}
}
