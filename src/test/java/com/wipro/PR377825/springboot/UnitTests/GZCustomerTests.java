package com.wipro.PR377825.springboot.UnitTests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wipro.PR377825.springboot.RestController.CustomerRestController;
import com.wipro.PR377825.springboot.entity.Customer;


@SpringBootTest
public class GZCustomerTests 
{
	@Autowired
	CustomerRestController custRestCtrl;


	
	@Test
	public void getAllCustomersSuccess()
	{
		System.out.println("Running unit test case - getAllCustomersSuccess");

		System.out.println("calling getAllCustomers method from CustomerRestController");

		ResponseEntity<List<Customer>> response = custRestCtrl.getAllCustomers();
		System.out.println("result: "+response);
		
		if (response != null)
		{
			boolean result = true;
			System.out.println("checking assertions");
			assertTrue("Success", result);
		}
		
		System.out.println("getAllCustomersSuccess test case ended");
		System.out.println();
	}


	@Test
	public void deleteCustomerByIDSuccess()
	{
		System.out.println("Running unit test case - deleteCustomerByIDSuccess");

		String userID ="PK01";		

		System.out.println("calling deleteById method from CustomerRestController");

		ResponseEntity<String> actual = custRestCtrl.deleteById(userID);

		System.out.println("actual: "+actual);

		String expected = "Customer details deleted for UserID "+userID;

		System.out.println("checking assertions");
		assertEquals(new ResponseEntity<>(expected, HttpStatus.OK), actual);

		System.out.println("deleteCustomerByIDSuccess test case ended");
		System.out.println();
	}


	@Test
	public void deleteAllCustomersSuccess()
	{
		System.out.println("Running unit test case - deleteAllCustomersSuccess");

		System.out.println("calling deleteAll method from CustomerRestController");

		ResponseEntity<String> actual = custRestCtrl.deleteAll();

		System.out.println("actual: "+actual);

		String expected = "All Customer details deleted";

		System.out.println("checking assertions");
		assertEquals(new ResponseEntity<>(expected, HttpStatus.OK), actual);

		System.out.println("deleteAllCustomersSuccess test case ended");
		System.out.println();
	}





}

