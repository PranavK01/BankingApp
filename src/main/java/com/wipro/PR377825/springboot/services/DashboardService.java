package com.wipro.PR377825.springboot.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.PR377825.springboot.entity.CurrentAccount;
import com.wipro.PR377825.springboot.entity.Customer;
import com.wipro.PR377825.springboot.entity.SavingAccount;
import com.wipro.PR377825.springboot.repository.CustomerRepo;


@Service
public class DashboardService 
{
	@Autowired
	CustomerRepo custRepo;	
		
//	findAll method for Rest API to be accessed from Postman
	
	public List<Customer> getAllCustomers()
	{
		return custRepo.findAll();	
	}
	
	
	
//	methods for non Rest API
	
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
		SavingAccount savingAccNumber = custRepo.getOne(ID).getSaving_accountNum();
		CurrentAccount currentAccNumber = custRepo.getOne(ID).getCurrent_accountNum();
//		Long[] accNumber = {savingAccNumber,currentAccNumber};
		
//		System.out.println("savingAccNumber from db in dashboard service: "+accNumber[0]);
//		System.out.println("currentAccNumber from db in dashboard service: "+accNumber[1]);
		
		System.out.println("savingAccNumber from db in dashboard service: "+savingAccNumber);
		System.out.println("currentAccNumber from db in dashboard service: "+currentAccNumber);
		
		return null;
	
	}
}
