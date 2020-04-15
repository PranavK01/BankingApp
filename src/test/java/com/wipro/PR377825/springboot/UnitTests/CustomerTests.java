package com.wipro.PR377825.springboot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wipro.PR377825.springboot.RestController.CustomerRestController;
import com.wipro.PR377825.springboot.entity.Customer;
import com.wipro.PR377825.springboot.repository.CustomerRepo;
import com.wipro.PR377825.springboot.services.DashboardService;


@SpringBootTest
public class CustomerTests 
{
	@Autowired
	CustomerRestController custRestCtrl;
//	@Mock
//	DashboardService dashServ;
//
//	@InjectMocks
//	DashboardService dashService;
//	@Mock
//	CustomerRepo custRepo;


//	@Before
//	public void init() 
//	{
//		MockitoAnnotations.initMocks(this);
//	}


	
	@Test
	public void getAllCustomersSuccess()
	{
		System.out.println("Running unit test case");
		System.out.println("fetching all customer details");

		ResponseEntity<List<Customer>> response = custRestCtrl.getAllCustomers();
		System.out.println("result: "+response);

		Customer obj = new Customer("PK01","123","Pranav","Kalra","pranav.k.com","6321432148");
		List<Customer> customer = new ArrayList<Customer>(4);
		customer.add(0,obj);

		assertEquals(new ResponseEntity<>(customer, HttpStatus.OK), response);

		System.out.println("test case ended");
	}
	
	
	@Test
	public void deleteCustomerByIDSuccess()
	{
		System.out.println("Running unit test case");
		System.out.println("Deleting customer details by userID");
		
		String userID ="PK01"; 

		ResponseEntity<String> response = custRestCtrl.deleteById(userID);
		System.out.println("result: "+response);

		assertEquals(new ResponseEntity<>("Customer details deleted for UserID "+userID, HttpStatus.OK), response);

		System.out.println("test case ended");
	}
	
	
	@Test
	public void deleteAllCustomersSuccess()
	{
		System.out.println("Running unit test case");
		System.out.println("Deleting all customer details ");
		
		ResponseEntity<String> response = custRestCtrl.deleteAll();
		System.out.println("result: "+response);

		assertEquals(new ResponseEntity<>("All Customer details deleted", HttpStatus.OK), response);

		System.out.println("test case ended");
	}
	
	
	


}

