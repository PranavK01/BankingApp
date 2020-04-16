package com.wipro.PR377825.springboot.UnitTests;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wipro.PR377825.springboot.RestController.CustomerRestController;
import com.wipro.PR377825.springboot.entity.Customer;


@SpringBootTest
public class ZCustomerTests 
{
	@Autowired
	CustomerRestController custRestCtrl;

	@Ignore
//	@Test
	public void getAllCustomersSuccess()
	{
		System.out.println("Running unit test case - getAllCustomersSuccess");

		System.out.println("calling getAllCustomers method from CustomerRestController");

		ResponseEntity<List<Customer>> response = custRestCtrl.getAllCustomers();
		System.out.println("result: "+response);
		
		String result = response.toString();
		try {
		FileWriter file = new FileWriter("getAllCustomersSuccess_Actual.txt");
		BufferedWriter buffWrite = new BufferedWriter(file);
		buffWrite.write(result);
		buffWrite.close();
		
		FileReader readFile = new FileReader("getAllCustomersSuccess_Expected.txt");
		BufferedReader buffRead =  new BufferedReader(readFile);
//		while (buffRead.readLine() != null)
//		{
//			String actual
//		}
		

//		BufferedReader actual = new BufferedReader(file);
		System.out.println("checking assertions");
//		assertEquals(new ResponseEntity<>(customer, HttpStatus.OK), response);
		
		assertSame(buffRead, buffWrite);
		}
		catch(IOException e)
		{
			e.printStackTrace();
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

