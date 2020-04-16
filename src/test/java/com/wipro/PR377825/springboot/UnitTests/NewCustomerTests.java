package com.wipro.PR377825.springboot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wipro.PR377825.springboot.HTML.NewCustomerHTML;
import com.wipro.PR377825.springboot.RestController.NewCustomerRestController;



@SpringBootTest
//Sorts by order
@TestMethodOrder(OrderAnnotation.class)

public class NewCustomerTests 
{
	@Autowired
	NewCustomerRestController newCustCtrl;

	
	@Order(1)
	@Test
	public void createNewCustomerSuccess()
	{
		System.out.println("Running unit test cases - createNewCustomerSuccess");
		
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
		
		System.out.println("createNewCustomerSuccess test case ended");
		System.out.println();
		 
	}
	
	

	@Order(2)
	@Test
	public void createNewCustomerUniqueContactNumberFailure()
	{
		System.out.println("Running unit test cases - createNewCustomerUniqueContactNumberFailure");
		
		NewCustomerHTML HTMLobj = new NewCustomerHTML();		
		HTMLobj.setFirstName("Pranav");	
		HTMLobj.setLastName("Kalra");	
		HTMLobj.setEmail("pranav.kalra2@wipro.com");	
		HTMLobj.setUserId("PK020");	
		HTMLobj.setPassword("123");	
		HTMLobj.setPhone("9717261526");	
		HTMLobj.setAccType("Saving");
		
		System.out.println("calling createCustomer method from newCustomerRestController");
		
		ResponseEntity<String> response = newCustCtrl.createCustomer(HTMLobj);
		
		System.out.println("result: "+ response);
		
		System.out.println("checking assertions");
		
		assertEquals(new ResponseEntity<String>("Contact Number must be unique", HttpStatus.BAD_REQUEST), response);
		
		System.out.println("createNewCustomerUniqueContactNumberFailure test case ended");
		System.out.println();
		
	}
	
	

	@Order(3)
	@Test
	public void createNewCustomerUniqueEmailFailure()
	{
		System.out.println("Running unit test cases - createNewCustomerUniqueEmailFailure");
		
		NewCustomerHTML HTMLobj = new NewCustomerHTML();		
		HTMLobj.setFirstName("Pranav");	
		HTMLobj.setLastName("Kalra");	
		HTMLobj.setEmail("pranav.kalra3@wipro.com");	
		HTMLobj.setUserId("PK030");	
		HTMLobj.setPassword("123");	
		HTMLobj.setPhone("9717261006");	
		HTMLobj.setAccType("Saving");
		
		System.out.println("calling createCustomer method from newCustomerRestController");
		
		ResponseEntity<String> response = newCustCtrl.createCustomer(HTMLobj);
		
		System.out.println("result: "+ response);
		
		System.out.println("checking assertions");
		
		assertEquals(new ResponseEntity<String>("Email must be unique",HttpStatus.BAD_REQUEST), response);
		
		System.out.println("createNewCustomerUniqueEmailFailure test case ended");
		System.out.println();
		
	}
	
	

	@Order(4)
	@Test
	public void createNewCustomerUserIDTakenFailure()
	{
		System.out.println("Running unit test cases - createNewCustomerUserIDTakenFailure");
		
		NewCustomerHTML HTMLobj = new NewCustomerHTML();		
		HTMLobj.setFirstName("Pranav");	
		HTMLobj.setLastName("Kalra");	
		HTMLobj.setEmail("pranav.kalra4@wipro.com");	
		HTMLobj.setUserId("PK01");	
		HTMLobj.setPassword("123");	
		HTMLobj.setPhone("9717223264");	
		HTMLobj.setAccType("Saving");
		
		System.out.println("calling createCustomer method from newCustomerRestController");
		
		ResponseEntity<String> response = newCustCtrl.createCustomer(HTMLobj);
		
		System.out.println("result: "+ response);
		
		System.out.println("checking assertions");
		
		assertEquals(new ResponseEntity<String>("UserId already taken",HttpStatus.BAD_REQUEST), response);
		
		System.out.println("createNewCustomerUserIDTakenFailure test case ended");
		System.out.println();
		 
	}
	
	
}
