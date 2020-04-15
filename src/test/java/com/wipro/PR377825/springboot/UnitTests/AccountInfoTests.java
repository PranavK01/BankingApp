package com.wipro.PR377825.springboot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wipro.PR377825.springboot.RestController.AccountInfoRestController;
import com.wipro.PR377825.springboot.entity.CurrentAccount;
import com.wipro.PR377825.springboot.entity.SavingAccount;
import com.wipro.PR377825.springboot.repository.CurrentAccRepo;
import com.wipro.PR377825.springboot.repository.SavingAccRepo;
import com.wipro.PR377825.springboot.services.EnquiryService;

@SpringBootTest
public class AccountInfoTests 
{
	@Autowired
	AccountInfoRestController accRestCtrl;
	
//	@Mock
//	EnquiryService enqService;
//	
//	@InjectMocks
//	EnquiryService enqServ;
//	@Mock
//	SavingAccRepo saveRepo;
//	@Mock
//	CurrentAccRepo currRepo;
	
	
	@Test
	public void getAllSavingAccountsTest()
	{
		System.out.println("Running unit test case");
		System.out.println("fetching all customer details");

		ResponseEntity<Collection<Map<String, String>>> response = accRestCtrl.getAllSavingAccounts();
		System.out.println("result: "+response);

		Collection<Map<String, String>> maps = new HashSet<Map<String, String>>();

		assertEquals(new ResponseEntity<>(maps, HttpStatus.OK), response);

		System.out.println("test case ended");
	}
	
	
	@Test
	public void getAllCurrentAccountsTest()
	{
		System.out.println("Running unit test case");
		System.out.println("fetching all customer details");

		ResponseEntity<Collection<Map<String, String>>> response = accRestCtrl.getAllCurrentAccounts();
		System.out.println("result: "+response);

		Collection<Map<String, String>> maps = new HashSet<Map<String, String>>();

		assertEquals(new ResponseEntity<>(maps, HttpStatus.OK), response);

		System.out.println("test case ended");
	}
	
	
	@Test
	public void getSavingAccountsByIDTest()
	{
		System.out.println("Running unit test case");
		System.out.println("fetching all customer details");
		long accountNum = 20050;

		ResponseEntity<Optional<SavingAccount>> response = accRestCtrl.getSavingAccountInfoByID(accountNum);
		System.out.println("result: "+response);

		Collection<Map<String, String>> maps = new HashSet<Map<String, String>>();

		assertEquals(new ResponseEntity<>(maps, HttpStatus.OK), response);

		System.out.println("test case ended");
	}
	
	
	@Test
	public void getCurrentAccountsByIDTest()
	{
		System.out.println("Running unit test case");
		System.out.println("fetching all customer details");
		long accountNum = 20050;

		ResponseEntity<Optional<CurrentAccount>> response = accRestCtrl.getCurrentAccountInfoByID(accountNum);
		System.out.println("result: "+response);

		Collection<Map<String, String>> maps = new HashSet<Map<String, String>>();

		assertEquals(new ResponseEntity<>(maps, HttpStatus.OK), response);

		System.out.println("test case ended");
	}
}
