package com.wipro.PR377825.springboot.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.PR377825.springboot.entity.CurrentAccount;
import com.wipro.PR377825.springboot.entity.SavingAccount;
import com.wipro.PR377825.springboot.repository.CurrentAccRepo;
import com.wipro.PR377825.springboot.repository.SavingAccRepo;


@Service
public class EnquiryService {
	@Autowired
	SavingAccRepo saveRepo;
	@Autowired
	CurrentAccRepo currentRepo;
	
	// methods for Rest APIs to be accessed from Postman
	
	public List<SavingAccount> getAllSavingAccounts()
	{
		return saveRepo.findAll();	
	}
	
	public List<CurrentAccount> getAllCurrentAccounts()
	{
		return currentRepo.findAll();	
	}
	
	public Optional<SavingAccount> findByAccountNumber1(long ID)
	{ 
		Optional<SavingAccount> accountNum = saveRepo.findById(ID);

		return accountNum;
	
	}

	public Optional<CurrentAccount> findByAccountNumber2(long ID)
	{ 
		Optional<CurrentAccount> accountNum = currentRepo.findById(ID);

		return accountNum;
	
	}
	
	// methods for non Rest APIs 
	
	public double findBalance(long ID) throws EntityNotFoundException
	{ 
		double balance = 0;
		Optional<SavingAccount> accountNum = saveRepo.findById(ID);
		if (accountNum.isPresent())
		{
			balance = saveRepo.getOne(ID).getBalance();
			System.out.println("Balance from db in enquiry service: "+balance);		
		}
		else
		{
			balance = currentRepo.getOne(ID).getBalance();
			System.out.println("Balance from db in enquiry service: "+balance);
		}		
		
		return balance;
	
	}

	public String findCurrency(long ID) throws EntityNotFoundException
	{ 
		String currency = "";
		Optional<SavingAccount> accountNum = saveRepo.findById(ID);
		if (accountNum.isPresent())
		{
			currency = saveRepo.getOne(ID).getCurrency();
			System.out.println("currency from db in enquiry service: "+currency);
		}
		else
		{
			currency = currentRepo.getOne(ID).getCurrency();
			System.out.println("currency from db in enquiry service: "+currency);
		}		
		return currency;
	
	}
	
	public String findStatus(long ID) throws EntityNotFoundException
	{ 
		String status = "";
		Optional<SavingAccount> accountNum = saveRepo.findById(ID);
		if (accountNum.isPresent())
		{
			status = saveRepo.getOne(ID).getStatus();
			System.out.println("status from db in enquiry service: "+status);
		}
		else
		{
			status = currentRepo.getOne(ID).getStatus();
			System.out.println("status from db in enquiry service: "+status);
		}		
		return status;
	
	}
}
