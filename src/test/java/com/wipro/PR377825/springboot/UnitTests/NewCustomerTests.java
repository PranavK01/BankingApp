package com.wipro.PR377825.springboot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wipro.PR377825.springboot.HTML.NewCustomerHTML;
import com.wipro.PR377825.springboot.RestController.NewCustomerRestController;
import com.wipro.PR377825.springboot.repository.CustomerRepo;
import com.wipro.PR377825.springboot.services.NewCustomerService;

@SpringBootTest
//Sorts by method name
@TestMethodOrder(Alphanumeric.class)

public class NewCustomerTests 
{
	@Autowired
	NewCustomerRestController newCustCtrl;
//	@Mock
//	NewCustomerService newCustServ;
//	
//	@InjectMocks
//	NewCustomerService newCustService;
//	@Mock
//	CustomerRepo custRepo;
	

//	@Before
//	public void init() 
//	{
//		MockitoAnnotations.initMocks(this);
//	}
	
	
	
	@Test
	public void createNewCustomerSuccess()
	{
		NewCustomerHTML HTMLobj = new NewCustomerHTML();
		
		HTMLobj.setFirstName("Pranav");	
		HTMLobj.setLastName("Kalra");	
		HTMLobj.setEmail("pranav.kalra1@wipro.com");	
		HTMLobj.setUserId("PK010");	
		HTMLobj.setPassword("123");	
		HTMLobj.setPhone("9717261526");	
		HTMLobj.setAccType("Saving");
		
		ResponseEntity<String> response = newCustCtrl.createCustomer(HTMLobj);
		
		System.out.println("result: "+ response);
		
		System.out.println("checking assertions");
		
		assertEquals(new ResponseEntity<String>("New Customer has been successfully created",HttpStatus.OK), response);
		
		System.out.println("test case ended");
		 
	}
	
	

	@Test
	public void createNewCustomerUniqueContactNumberFailure()
	{
		NewCustomerHTML HTMLobj = new NewCustomerHTML();
		
		HTMLobj.setFirstName("Pranav");	
		HTMLobj.setLastName("Kalra");	
		HTMLobj.setEmail("pranav.kalra2@wipro.com");	
		HTMLobj.setUserId("PK020");	
		HTMLobj.setPassword("123");	
		HTMLobj.setPhone("9717261526");	
		HTMLobj.setAccType("Saving");
		
		ResponseEntity<String> response = newCustCtrl.createCustomer(HTMLobj);
		
		System.out.println("result: "+ response);
		
		System.out.println("checking assertions");
		
		assertEquals(new ResponseEntity<String>("Contact Number must be unique", HttpStatus.BAD_REQUEST), response);
		
		System.out.println("test case ended");
		 
	}
	
	

	@Test
	public void createNewCustomerUniqueEmailFailure()
	{
		NewCustomerHTML HTMLobj = new NewCustomerHTML();
		
		HTMLobj.setFirstName("Pranav");	
		HTMLobj.setLastName("Kalra");	
		HTMLobj.setEmail("pranav.kalra3@wipro.com");	
		HTMLobj.setUserId("PK030");	
		HTMLobj.setPassword("123");	
		HTMLobj.setPhone("9717261006");	
		HTMLobj.setAccType("Saving");
		
		ResponseEntity<String> response = newCustCtrl.createCustomer(HTMLobj);
		
		System.out.println("result: "+ response);
		
		System.out.println("checking assertions");
		
		assertEquals(new ResponseEntity<String>("Email must be unique",HttpStatus.BAD_REQUEST), response);
		
		System.out.println("test case ended");
		 
	}
	
	

	@Test
	public void createNewCustomerUserIDTakenFailure()
	{
		NewCustomerHTML HTMLobj = new NewCustomerHTML();
		
		HTMLobj.setFirstName("Pranav");	
		HTMLobj.setLastName("Kalra");	
		HTMLobj.setEmail("pranav.kalra4@wipro.com");	
		HTMLobj.setUserId("PK01");	
		HTMLobj.setPassword("123");	
		HTMLobj.setPhone("9717223264");	
		HTMLobj.setAccType("Saving");
		
		ResponseEntity<String> response = newCustCtrl.createCustomer(HTMLobj);
		
		System.out.println("result: "+ response);
		
		System.out.println("checking assertions");
		
		assertEquals(new ResponseEntity<String>("UserId already taken",HttpStatus.BAD_REQUEST), response);
		
		System.out.println("test case ended");
		 
	}
	
	
}
