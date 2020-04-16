package com.wipro.PR377825.springboot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wipro.PR377825.springboot.HTML.ResetPwHTML;
import com.wipro.PR377825.springboot.RestController.ResetPWRestContoller;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ResetPWTests 
{
	
	@Autowired
	ResetPWRestContoller resetCtrl;
	
	
	@Order(1)
	@Test
	public void ResetCustomerPasswordSuccess()
	{
		System.out.println("Running unit test case - ResetCustomerPasswordSuccess");
		String userID = "PK01";
		
		ResetPwHTML HTMLobj = new ResetPwHTML();
		HTMLobj.setUserId(userID);
		HTMLobj.setPassword("1234");
		HTMLobj.setConfirmPW("1234");
		
		System.out.println("calling resetPassword method from ResetPaswordRestController");
		
		ResponseEntity<String> response = resetCtrl.resetPassword(userID, HTMLobj);
		System.out.println("result: "+response);

		assertEquals(new ResponseEntity<>("Password has been reset successfully", HttpStatus.OK), response);

		System.out.println("ResetCustomerPasswordSuccess test case ended");
		System.out.println();
	}
	
	
	@Order(2)
	@Test
	public void ResetCustomerPasswordFailure()
	{
		System.out.println("Running unit test case - ResetCustomerPasswordFailure");
		String userID = "PK01";
		
		ResetPwHTML HTMLobj = new ResetPwHTML();
		HTMLobj.setUserId(userID);
		HTMLobj.setPassword("1234");
		HTMLobj.setConfirmPW("12389");
		
		System.out.println("calling resetPassword method from ResetPaswordRestController");
		
		ResponseEntity<String> response = resetCtrl.resetPassword(userID, HTMLobj);
		System.out.println("result: "+response);

		assertEquals(new ResponseEntity<>("Passwords mismatch", HttpStatus.BAD_REQUEST), response);

		System.out.println("ResetCustomerPasswordFailure test case ended");
		System.out.println();
	}
	
	
	@Order(3)
	@Test
	public void ResetCustomerPasswordIncorrectUserIDFailure()
	{
		System.out.println("Running unit test case - ResetCustomerPasswordIncorrectUserIDFailure");
		String userID = "PK02";
		
		ResetPwHTML HTMLobj = new ResetPwHTML();
		HTMLobj.setUserId(userID);
		HTMLobj.setPassword("1234");
		HTMLobj.setConfirmPW("1234");
		
		System.out.println("calling resetPassword method from ResetPaswordRestController");
		
		ResponseEntity<String> response = resetCtrl.resetPassword(userID, HTMLobj);
		System.out.println("result: "+response);

		assertEquals(new ResponseEntity<>("Incorrect UserID", HttpStatus.BAD_REQUEST), response);

		System.out.println("ResetCustomerPasswordIncorrectUserIDFailure test case ended");
		System.out.println();
	}
}
