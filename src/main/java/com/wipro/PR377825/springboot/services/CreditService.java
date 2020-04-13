package com.wipro.PR377825.springboot.services;

import java.util.Date;

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
public class CreditService 
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


	public String updateDetails(long accNumber, double closingBalance, String remark, double amt, double balance) throws EntityNotFoundException
	{ 
		SavingAccount saveObj = saveRepo.findById(accNumber).get();
		if (saveObj != null)
		{
			Date date = new Date();
			
//			adding entries in saving transaction table
			SavingAccTransaction saveTranObj = new SavingAccTransaction();
			saveTranObj.setSavingAccNumber(saveObj);
			saveTranObj.setAvailableBalance(closingBalance);
			saveTranObj.setDateTime(date);
			saveTranObj.setAmount(amt);
			saveTranObj.setPreviousBal(balance);
			saveTranObj.setDescription(remark);
			saveTranObj.setStatus("Credit Success");
			
			saveTranRepo.save(saveTranObj);

//			updating entry in saving account table
			saveObj.setBalance(closingBalance);
			saveRepo.save(saveObj);

		}
		else
		{
			Date date = new Date();
			CurrentAccount currObj = currentRepo.findById(accNumber).get();
			
//			adding entries in current transaction table
			CurrentAccTransaction currentObj = new CurrentAccTransaction();
			currentObj.setCurrentaccNumber(currObj);
			currentObj.setAvailableBalance(closingBalance);
			currentObj.setDateTime(date);
			currentObj.setAmount(amt);
			currentObj.setPreviousBal(balance);
			currentObj.setDescription(remark);
			currentObj.setStatus("Credit Success");
			
			currentTranRepo.save(currentObj);
			
//			updating balance in current account table
			currObj.setBalance(closingBalance);
			currentRepo.save(currObj);
		}		

		return null;		
	}
}
