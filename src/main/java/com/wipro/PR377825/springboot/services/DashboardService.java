package com.wipro.PR377825.springboot.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.PR377825.springboot.entity.CurrentAccTransaction;
import com.wipro.PR377825.springboot.entity.CurrentAccount;
import com.wipro.PR377825.springboot.entity.Customer;
import com.wipro.PR377825.springboot.entity.SavingAccTransaction;
import com.wipro.PR377825.springboot.entity.SavingAccount;
import com.wipro.PR377825.springboot.repository.CurrentAccRepo;
import com.wipro.PR377825.springboot.repository.CurrentTransactionRepo;
import com.wipro.PR377825.springboot.repository.CustomerRepo;
import com.wipro.PR377825.springboot.repository.SavingAccRepo;
import com.wipro.PR377825.springboot.repository.SavingTransactionRepo;


@Service
@Transactional
public class DashboardService 
{
	@Autowired
	CustomerRepo custRepo;
	@Autowired
	SavingAccRepo saveRepo;
	@Autowired
	CurrentAccRepo currRepo;
	@Autowired
	SavingTransactionRepo saveTranRepo;
	@Autowired
	CurrentTransactionRepo currTranRepo;


	//	findAll method for Rest API to be tested from Postman

	public List<Customer> getAllCustomers()
	{
		return custRepo.findAll();	
	}

	//	deleteByUserID method for Rest API to be tested from Postman
	public void deleteByUserID(String ID)
	{
		//		Customer custObj = custRepo.findById(ID);		
		Customer custObj = custRepo.getOne(ID);
		if (custObj != null)
		{
			SavingAccount saveObj = saveRepo.findByFKuserID(custObj);

			if (saveObj != null)
			{
				List<SavingAccTransaction> saveTranObj = saveTranRepo.findBysavingAccNumber(saveObj);

				saveTranRepo.deleteAll(saveTranObj);

				saveRepo.delete(saveObj);

				custRepo.delete(custObj);
			}
			else
			{
				CurrentAccount currObj = currRepo.findByFKuserID(custObj);
				List<CurrentAccTransaction> currTranObj = currTranRepo.findBycurrentaccNumber(currObj);

				currTranRepo.deleteAll(currTranObj);

				currRepo.delete(currObj);

				custRepo.delete(custObj);

			}
		}

	}

	//	deleteAll method for Rest API to be tested from Postman
	public void deleteAllCustomers()
	{
		//			deleting all records from saving and current transaction table
		saveTranRepo.deleteAll();
		currTranRepo.deleteAll();

		//			deleting all records from saving account and current account tables
		saveRepo.deleteAll();
		currRepo.deleteAll();

		//			deleting all records from customer table
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
			CurrentAccount currObj = currRepo.findByFKuserID(obj);

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
			type = currRepo.getOne(accNumber).getAccountType();			
		}
		return type;
	}

}
