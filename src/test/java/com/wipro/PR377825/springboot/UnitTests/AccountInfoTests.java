package com.wipro.PR377825.springboot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wipro.PR377825.springboot.RestController.AccountInfoRestController;
import com.wipro.PR377825.springboot.entity.CurrentAccount;
import com.wipro.PR377825.springboot.entity.SavingAccount;



@SpringBootTest
public class AccountInfoTests 
{
	@Autowired
	AccountInfoRestController accRestCtrl;
		
	@Ignore
//	@Test
	public void getAllSavingAccountsSuccess()
	{
		System.out.println("Running unit test case - getAllSavingAccountsSuccess");
//		
		Collection<Map<String, String>> maps = new HashSet<Map<String, String>>();
//		
//		for (SavingAccount tempSaveAccount : account) 
//		{
//			System.out.println(tempSaveAccount);
//			Map<String, String> tempMap = new HashMap<String, String>();
//			tempMap.put("Account Number", ""+tempSaveAccount.getAccNumber());
//			tempMap.put("Account Type", ""+tempSaveAccount.getAccountType());
//			tempMap.put("Balance", ""+tempSaveAccount.getBalance());
//			tempMap.put("Currency", ""+tempSaveAccount.getCurrency());
//			tempMap.put("Status", ""+tempSaveAccount.getStatus());
//			tempMap.put("UserId", ""+tempSaveAccount.getFKuserID().getUserId());
//
//			maps.add(tempMap);
//		}
		
		System.out.println("fetching all customer details");
		
		System.out.println("calling getAllSavingAccounts method from AccountRestController");

		ResponseEntity<Collection<Map<String, String>>> response = accRestCtrl.getAllSavingAccounts();
		System.out.println("result: "+response);

		System.out.println("checking assertions");
		assertEquals(new ResponseEntity<>(maps, HttpStatus.OK), response);

		System.out.println("getAllSavingAccountsSuccess test case ended");
		System.out.println();
	}
	
	
	@Ignore
//	@Test
	public void getAllCurrentAccountsSuccess()
	{
		System.out.println("Running unit test case - getAllCurrentAccountsSuccess");
		System.out.println("fetching all customer details");

		System.out.println("calling getAllCurrentAccounts method from AccountRestController");
		
		ResponseEntity<Collection<Map<String, String>>> response = accRestCtrl.getAllCurrentAccounts();
		System.out.println("result: "+response);

		Collection<Map<String, String>> maps = new HashSet<Map<String, String>>();

		System.out.println("checking assertions");
		assertEquals(new ResponseEntity<>(maps, HttpStatus.OK), response);

		System.out.println("getAllCurrentAccountsSuccess test case ended");
		System.out.println();
	}
	
	
	@Ignore
//	@Test
	public void getSavingAccountsByUserIDSuccess()
	{
		System.out.println("Running unit test case - getSavingAccountsByUserIDSuccess");
		long accountNum = 20050;
		Collection<Map<String, String>> maps = new HashSet<Map<String, String>>();
		System.out.println("fetching all customer details");
			
		System.out.println("calling getSavingAccountInfoByID method from AccountRestController");

		ResponseEntity<Optional<SavingAccount>> response = accRestCtrl.getSavingAccountInfoByID(accountNum);
		System.out.println("result: "+response);
		System.out.println("checking assertions");
		assertEquals(new ResponseEntity<>(maps, HttpStatus.OK), response);

		System.out.println("getSavingAccountsByUserIDSuccess test case ended");
		System.out.println();
	}
	
	
	@Ignore
//	@Test
	public void getCurrentAccountsByUserIDSuccess()
	{
		System.out.println("Running unit test case - getCurrentAccountsByUserIDSuccess");
		long accountNum = 40056;
		
		System.out.println("fetching all customer details");
		
		
		System.out.println("calling getCurrentAccountInfoByID method from AccountRestController");

		ResponseEntity<Optional<CurrentAccount>> response = accRestCtrl.getCurrentAccountInfoByID(accountNum);
		System.out.println("result: "+response);

		Collection<Map<String, String>> maps = new HashSet<Map<String, String>>();
		System.out.println("checking assertions");
		assertEquals(new ResponseEntity<>(maps, HttpStatus.OK), response);

		System.out.println("getCurrentAccountsByUserIDSuccess test case ended");
		System.out.println();
	}
}
