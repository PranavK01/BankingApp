package com.wipro.PR377825.springboot.services;


import java.util.Date;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.PR377825.springboot.Controller.FundTransferController;
import com.wipro.PR377825.springboot.entity.CurrentAccTransaction;
import com.wipro.PR377825.springboot.entity.CurrentAccount;
import com.wipro.PR377825.springboot.entity.SavingAccTransaction;
import com.wipro.PR377825.springboot.entity.SavingAccount;
import com.wipro.PR377825.springboot.repository.CurrentAccRepo;
import com.wipro.PR377825.springboot.repository.CurrentTransactionRepo;
import com.wipro.PR377825.springboot.repository.SavingAccRepo;
import com.wipro.PR377825.springboot.repository.SavingTransactionRepo;



@Service
public class DebitService 
{
	@Autowired
	SavingAccRepo saveRepo;
	@Autowired
	CurrentAccRepo currentRepo;
	@Autowired
	FundTransferController fundCrtl;
	@Autowired
	SavingTransactionRepo saveTranRepo;
	@Autowired
	CurrentTransactionRepo currentTranRepo;


	public String updateDetails(long accNumber, double closingBalance, String remark, double amt, double balance, String type) throws EntityNotFoundException
	{ 
		Optional<SavingAccount> accountNum = saveRepo.findById(accNumber);
		if (accountNum.isPresent())
		{
			Date date = new Date();
			
			SavingAccTransaction saveObj = new SavingAccTransaction();
			saveObj.setAccNumber(accNumber);
			saveObj.setAvailableBalance(closingBalance);
			saveObj.setDateTime(date);
			saveObj.setAmount(amt);
			saveObj.setPreviousBal(balance);
			saveObj.setDescription(remark);
			saveObj.setStatus("Debit Success");
			saveObj.setType(type);

			saveTranRepo.save(saveObj);
			
			SavingAccount obj = saveRepo.findById(accNumber).get();
			obj.setBalance(closingBalance);
			saveRepo.save(obj);

		}
		else
		{
			Date date = new Date();
			
			CurrentAccTransaction currentObj = new CurrentAccTransaction();
			currentObj.setAccNumber(accNumber);
			currentObj.setAvailableBalance(closingBalance);
			currentObj.setDateTime(date);
			currentObj.setAmount(amt);
			currentObj.setPreviousBal(balance);
			currentObj.setDescription(remark);
			currentObj.setStatus("Debit Success");
			currentObj.setType(type);

			currentTranRepo.save(currentObj);
			
			CurrentAccount obj = currentRepo.findById(accNumber).get();
			obj.setBalance(closingBalance);
			currentRepo.save(obj);
		}		

		return null;		
	}
}
