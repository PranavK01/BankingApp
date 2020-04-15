package com.wipro.PR377825.springboot.UnitTests;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.wipro.PR377825.springboot.HTML.NewCustomerHTML;
import com.wipro.PR377825.springboot.RestController.NewCustomerRestController;
import com.wipro.PR377825.springboot.repository.CustomerRepo;
import com.wipro.PR377825.springboot.services.NewCustomerService;

@SpringBootTest
public class NewCustomerTest 
{
	@InjectMocks
	NewCustomerRestController newCustCtrl;
	@Mock
	NewCustomerService newCustServ;
	
	@InjectMocks
	NewCustomerService newCustService;
	@Mock
	CustomerRepo custRepo;
	

	@Before
	public void init() 
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createNewCustomertest()
	{
		NewCustomerHTML HTMLobj = new NewCustomerHTML();
		
		HTMLobj.setFirstName("Pranav");	
		System.out.println("firstName from HTML input:" + HTMLobj.getFirstName());
		
		HTMLobj.setLastName("Kalra");	
		System.out.println("firstName from HTML input:" + HTMLobj.getLastName());
		
		HTMLobj.setEmail("pranav.kalra3@wipro.com");	
		System.out.println("firstName from HTML input:" + HTMLobj.getEmail());
		
		HTMLobj.setUserId("PK01");	
		System.out.println("firstName from HTML input:" + HTMLobj.getUserId());
		
		HTMLobj.setPassword("123");	
		System.out.println("firstName from HTML input:" + HTMLobj.getPassword());
		
		HTMLobj.setPhone("9717261526");	
		System.out.println("firstName from HTML input:" + HTMLobj.getPhone());
		
		HTMLobj.setAccType("Current");	
		System.out.println("firstName from HTML input:" + HTMLobj.getAccType());
		
		ResponseEntity<String> result = newCustCtrl.createCustomer(HTMLobj);
		
		System.out.println("result: "+ result);
		
		 
	}
}
