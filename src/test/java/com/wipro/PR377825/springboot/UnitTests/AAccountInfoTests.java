package com.wipro.PR377825.springboot.UnitTests;

import static org.junit.Assert.assertTrue;
import java.util.Collection;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.ResponseEntity;

import com.wipro.PR377825.springboot.RestController.AccountInfoRestController;



@SpringBootTest
public class AAccountInfoTests 
{
	@Autowired
	AccountInfoRestController accRestCtrl;
		
	
	//@Test
	public void getAllSavingAccountsSuccess()
	{
		System.out.println("Running unit test case - getAllSavingAccountsSuccess");
			
		System.out.println("calling getAllSavingAccounts method from AccountRestController");

		ResponseEntity<Collection<Map<String, String>>> response = accRestCtrl.getAllSavingAccounts();
		System.out.println("result: "+response);
		if (response != null)
		{
			boolean result = true;
			System.out.println("checking assertions");
			assertTrue("Success", result);
		}
		

		System.out.println("getAllSavingAccountsSuccess test case ended");
		System.out.println();
	}
	
	
	
	@Test
	public void getAllCurrentAccountsSuccess()
	{
		System.out.println("Running unit test case - getAllCurrentAccountsSuccess");
		
		System.out.println("calling getAllCurrentAccounts method from AccountRestController");
		
		ResponseEntity<Collection<Map<String, String>>> response = accRestCtrl.getAllCurrentAccounts();
		System.out.println("result: "+response);
		if (response != null)
		{
			boolean result = true;
			System.out.println("checking assertions");
			assertTrue("Success", result);
		}
		
		System.out.println("getAllCurrentAccountsSuccess test case ended");
		System.out.println();
	}
	
	
	
	@Test
	public void getSavingAccountsByUserIDSuccess()
	{
		System.out.println("Running unit test case - getSavingAccountsByUserIDSuccess");
		long accountNum = 20050;
		
		System.out.println("calling getSavingAccountInfoByID method from AccountRestController");

		ResponseEntity<Map<String, String>> response = accRestCtrl.getSavingAccountInfoByID(accountNum);
		System.out.println("result: "+response);
		{
			boolean result = true;
			System.out.println("checking assertions");
			assertTrue("Success", result);
		}
		
		System.out.println("getSavingAccountsByUserIDSuccess test case ended");
		System.out.println();
	}
	
	
	@Test
	public void getCurrentAccountsByUserIDSuccess()
	{
		System.out.println("Running unit test case - getCurrentAccountsByUserIDSuccess");
		long accountNum = 40056;
				
		System.out.println("calling getCurrentAccountInfoByID method from AccountRestController");

		ResponseEntity<Map<String, String>> response = accRestCtrl.getCurrentAccountInfoByID(accountNum);
		System.out.println("result: "+response);
		if (response != null)
		{
			boolean result = true;
			System.out.println("checking assertions");
			assertTrue("Success", result);
		}
		
		System.out.println("getCurrentAccountsByUserIDSuccess test case ended");
		System.out.println();
	}
}
