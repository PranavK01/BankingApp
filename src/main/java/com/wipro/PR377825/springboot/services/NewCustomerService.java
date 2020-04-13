package com.wipro.PR377825.springboot.services;

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
public class NewCustomerService 
{
	@Autowired
	CustomerRepo custRepo;
	@Autowired
	SavingAccRepo saveRepo;
	@Autowired
	CurrentAccRepo saveRepo2;


	public String checkUserID(String ID) throws EntityNotFoundException
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

	public String checkEmail(String email) throws EntityNotFoundException
	{ 
		System.out.println("Entered checkEmail");
		Customer obj = custRepo.findByEmail(email);
		if (obj!=null)
		{
			return email;
		}
		return null;
	}
	
	
	public String checkContactNumber(String phone) throws EntityNotFoundException
	{ 
		Customer obj = custRepo.findByPhone(phone);
		if (obj != null)
		{
			return phone;
		}
		return null;
	}
	

	public String addNewCustomer(String a, String b, String c, String d, String e, String f, String g)
	{
		long currentAccountNum, savingAccountNum;

		if (g.equals("Current"))
		{
			Customer DBobj = new Customer(e, f, a, b, c, d);
			custRepo.save(DBobj);
			
			CurrentAccount saveObj2 = new CurrentAccount("Current", 1000.00, "INR", "Active", DBobj);
			saveRepo2.save(saveObj2);

			currentAccountNum = saveObj2.getAccNumber();
			System.out.println("Account number after saving in new customer service: "+currentAccountNum);

			
		}
		else
		{
			Customer DBobj = new Customer(e, f, a, b, c, d);
			custRepo.save(DBobj);
			
			SavingAccount saveObj = new SavingAccount("Saving", 10000.00, "INR", "Active", DBobj);
			saveRepo.save(saveObj);

			savingAccountNum = saveObj.getAccNumber();
			System.out.println("Account number after saving in new customer service: "+savingAccountNum);

			
		}			

		return null;
	}
}
