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
		List<Customer> obj = custRepo.findAll();
		String result = obj.toString();
		System.out.println("result is: "+result);
		return null;
	}

	public String create(String a, String b, String c, String d, String e, String f, String g)
	{
		long currentAccountNum, savingAccountNum;

		if (g.equals("Yes"))
		{
			SavingAccount saveObj = new SavingAccount("Saving", 10000.00, "INR", "Active", e);
			saveRepo.save(saveObj);

			CurrentAccount saveObj2 = new CurrentAccount("Current", 1000.00, "INR", "Active", e);
			saveRepo2.save(saveObj2);

			savingAccountNum = saveObj.getAccNumber();
			System.out.println("Account number after saving in new customer service: "+savingAccountNum);

			currentAccountNum = saveObj2.getAccNumber();
			System.out.println("Account number after saving in new customer service: "+currentAccountNum);

			Customer DBobj = new Customer(e, f, a, b, c, d, currentAccountNum, savingAccountNum);
			custRepo.save(DBobj);
		}
		else
		{
			SavingAccount saveObj = new SavingAccount("Saving", 10000.00, "INR", "Active", e);
			saveRepo.save(saveObj);

			savingAccountNum = saveObj.getAccNumber();
			System.out.println("Account number after saving in new customer service: "+savingAccountNum);

			Customer obj = new Customer(e, f, a, b, c, d,null, savingAccountNum);
			custRepo.save(obj);
		}			

		return null;
	}
}
