package com.wipro.PR377825.springboot.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.PR377825.springboot.entity.CurrentAccount;
import com.wipro.PR377825.springboot.entity.SavingAccount;
import com.wipro.PR377825.springboot.repository.CurrentAccRepo;
import com.wipro.PR377825.springboot.repository.SavingAccRepo;


@Service
@Transactional
public class FundTransferService 
{
	@Autowired
	SavingAccRepo saveRepo;
	@Autowired
	CurrentAccRepo currentRepo;
	
//	non Rest API method
	public long checkAccNumber(long ID) throws EntityNotFoundException
	{ 
		long accNumber = 0;
		Optional<SavingAccount> accountNum1 = saveRepo.findById(ID);
		Optional<CurrentAccount> accountNum2 = currentRepo.findById(ID);
		if (accountNum1.isPresent())
		{
			accNumber = saveRepo.getOne(ID).getAccNumber();
			System.out.println("accNumber from db in fund service: "+accNumber);
			return accNumber;
		}
		else if (accountNum2.isPresent())
		{
			accNumber = currentRepo.getOne(ID).getAccNumber();
			System.out.println("Balance from db in enquiry service: "+accNumber);
			return accNumber;
		}
		
		else
		return accNumber;
	
	}
}
