package com.wipro.PR377825.springboot.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.PR377825.springboot.entity.CurrentAccount;
import com.wipro.PR377825.springboot.entity.Customer;
import com.wipro.PR377825.springboot.entity.SavingAccount;
import com.wipro.PR377825.springboot.repository.CurrentAccRepo;
import com.wipro.PR377825.springboot.repository.CustomerRepo;
import com.wipro.PR377825.springboot.repository.SavingAccRepo;


@Service
public class DashboardService 
{
	@Autowired
	CustomerRepo custRepo;
	@Autowired
	SavingAccRepo saveRepo;
	@Autowired
	CurrentAccRepo currentRepo;
		
//	findAll method for Rest API to be tested from Postman
	
	public List<Customer> getAllCustomers()
	{
		return custRepo.findAll();	
	}
	
//	deleteByUserID method for Rest API to be tested from Postman
	public void deleteByUserID(String ID)
	{
		Optional<Customer> userID = custRepo.findById(ID);
		if (userID.isPresent())
		{
			custRepo.deleteById(ID);
		}
	}
	
//	deleteAll method for Rest API to be tested from Postman
	public void deleteAllCustomers()
	{
		custRepo.deleteAll();
	}
	
	
	
//	non Rest API methods
	
	public String findUserName(String ID) throws EntityNotFoundException
	{ 
		String firstName = custRepo.getOne(ID).getFirstName();
		String lastName = custRepo.getOne(ID).getLastName();
		String customerName = firstName + " " + lastName;
		System.out.println("UserName from db in dashboard service: "+customerName);
		return customerName;
	
	}

	
	public long findAccountNumber(String ID)
	{ 
		long accNum;
		
		System.out.println("inside findAccNumber in dash service, checking saving account table");
		
		Customer obj = custRepo.getOne(ID);
		
		SavingAccount DBobj = saveRepo.findByFKuserID(obj);		
			
		if (DBobj != null)
		{
			accNum = DBobj.getAccNumber();
			System.out.println("accNum from db in dashboard service: "+accNum);		
		}
		else
		{
			System.out.println("account number does not present in saving account table, checking in current account table");
			CurrentAccount currObj = currentRepo.findByFKuserID(obj);
			
			accNum = currObj.getAccNumber();
			System.out.println("accNum from db in dashboard service: "+accNum);
		}		
		return accNum;
	}
	
	public String findAccType(long accNumber)
	{
		String type = "";
		Optional<SavingAccount> obj = saveRepo.findById(accNumber);
		if (obj.isPresent())
		{
			type = saveRepo.getOne(accNumber).getAccountType();
		}
		else 
		{
			type = currentRepo.getOne(accNumber).getAccountType();			
		}
		return type;
	}
	
}
