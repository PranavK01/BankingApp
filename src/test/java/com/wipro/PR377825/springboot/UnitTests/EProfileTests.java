package com.wipro.PR377825.springboot.UnitTests;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wipro.PR377825.springboot.RestController.ProfileRestController;
import com.wipro.PR377825.springboot.entity.Customer;


@SpringBootTest
//Sorts by order
@TestMethodOrder(OrderAnnotation.class)

public class EProfileTests 
{
	@Autowired
	ProfileRestController proRestCtrl;
	

	@Order(1)
	@Test
	public void getCustomerProfileByContactNumberSuccess()
	{
		System.out.println("Running unit test case - 'getCustomerProfileByContactNumberSuccess'");

		String phone = "9717275141";

		ResponseEntity<Map<String,String>> response = proRestCtrl.getProfileByPhone(phone);
		System.out.println("response: " + response);		
		
		HashMap<String, String> expected = new HashMap<>();
		expected.put("firstName","Pranav");
		expected.put("lastName","Kalra");
		expected.put("email","pranav.kalra3@wipro.com");
		expected.put("phone","9717275141");

		assertEquals(new ResponseEntity<Map<String,String>>(expected, HttpStatus.OK), response);

		System.out.println("getCustomerProfileByContactNumberSuccess test case ended");
		System.out.println();
	}
	
	
	@Order(2)
	@Test
	public void updateCustomerProfileByUserIDSuccess()
	{
		System.out.println("Running unit test case - 'updateCustomerProfileByUserIDSuccess'");
		String UserID = "PK01";
		
		System.out.println("Updating customers Email address");
		
		Customer custObj = new Customer();
		custObj.setFirstName("Pranav");
		custObj.setLastName("Kalra");
		custObj.setEmail("pranav.kalra@wipro.com");
		custObj.setPhone("9717275141");
		
		System.out.println("calling updateProfile method from profileRestController");
		
		ResponseEntity<String> actual = proRestCtrl.updateProfile(UserID, custObj);
		
		System.out.println("actual: "+actual);

		String expected = "Profile updated successfully";
		
		System.out.println("checking assertions");

		assertEquals(new ResponseEntity<String>(expected, HttpStatus.OK), actual);

		System.out.println("updateCustomerProfileByUserIDSuccess Test case ended");
		System.out.println();		
	}
	
	
	@Order(3)
	@Test
	public void updateCustomerProfileByUserIDNotNullFailure()
	{
		System.out.println("Running unit test case - 'updateCustomerProfileByUserIDNotNullFailure'");
		String UserID = "PK01";
		
		Customer custObj = new Customer();
		custObj.setUserId(UserID);
		custObj.setFirstName("Pranav");
		custObj.setLastName("Kalra");
		custObj.setEmail("pranav.kalra@wipro.com");
		custObj.setPhone("9717275141");
		
		System.out.println("calling updateProfile method from profileRestController");
		
		ResponseEntity<String> actual = proRestCtrl.updateProfile(UserID, custObj);
		
		System.out.println("actual: "+actual);

		String expected = "Try another request without userID field in request input";
		
		System.out.println("checking assertions");

		assertEquals(new ResponseEntity<String>(expected, HttpStatus.BAD_REQUEST), actual);

		System.out.println("updateCustomerProfileByUserIDNotNullFailure Test case ended");
		System.out.println();
	}
	
	
	@Order(4)
	@Test
	public void updateCustomerProfileByUserIDPasswordNotNullFailure()
	{
		System.out.println("Running unit test case - 'updateCustomerProfileByUserIDPasswordNotNullFailure'");
		String UserID = "PK01";
		
		Customer custObj = new Customer();
		custObj.setPassword("123");
		custObj.setFirstName("Pranav");
		custObj.setLastName("Kalra");
		custObj.setEmail("pranav.kalra@wipro.com");
		custObj.setPhone("9717275141");
		
		System.out.println("calling updateProfile method from profileRestController");
		
		ResponseEntity<String> actual = proRestCtrl.updateProfile(UserID, custObj);
		
		System.out.println("actual: "+actual);

		String expected = "Password cannot be updated here. Use reset password option or try another request without password field in input";
		
		System.out.println("checking assertions");

		assertEquals(new ResponseEntity<String>(expected, HttpStatus.BAD_REQUEST), actual);

		System.out.println("updateCustomerProfileByUserIDPasswordNotNullFailure Test case ended");
		System.out.println();		
	}
	
	
	
	@Order(5)	
	@Test
	public void updateCustomerProfileByUserIDUniqueContactNumberFailure()
	{
		System.out.println("Running unit test case - 'updateCustomerProfileByUserIDUniqueContactNumberFailure'");
		String UserID = "PK01";
		
		Customer custObj = new Customer();
		custObj.setFirstName("Pranav");
		custObj.setLastName("Kalra");
		custObj.setEmail("pranav.kalra@wipro.com");
		custObj.setPhone("9717275141");
		
		System.out.println("calling updateProfile method from profileRestController");
		
		ResponseEntity<String> actual = proRestCtrl.updateProfile(UserID, custObj);
		
		System.out.println("actual: "+actual);

		String expected = "Contact number already exits";
		
		System.out.println("checking assertions");

		assertEquals(new ResponseEntity<String>(expected, HttpStatus.BAD_REQUEST), actual);

		System.out.println("updateCustomerProfileByUserIDUniqueContactNumberFailure Test case ended");
		System.out.println();	
	}
	
	
	
	@Order(6)
	@Test
	public void updateCustomerProfileByUserIDUniqueEmailFailure()
	{
		System.out.println("Running unit test case - 'updateCustomerProfileByUserIDUniqueEmailFailure'");
		String UserID = "PK01";
		
		Customer custObj = new Customer();
		custObj.setFirstName("Pranav");
		custObj.setLastName("Kalra");
		custObj.setEmail("ram.sharma@wipro.com");
		custObj.setPhone("9717275141");
		
		System.out.println("calling updateProfile method from profileRestController");
		
		ResponseEntity<String> actual = proRestCtrl.updateProfile(UserID, custObj);
		
		System.out.println("actual: "+actual);

		String expected = "Email already taken";
		
		System.out.println("checking assertions");

		assertEquals(new ResponseEntity<String>(expected, HttpStatus.BAD_REQUEST), actual);

		System.out.println("updateCustomerProfileByUserIDUniqueEmailFailure Test case ended");
		System.out.println();		
	}
}
