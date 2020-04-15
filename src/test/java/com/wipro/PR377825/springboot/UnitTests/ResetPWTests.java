package com.wipro.PR377825.springboot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wipro.PR377825.springboot.HTML.ResetPwHTML;
import com.wipro.PR377825.springboot.RestController.ResetPWRestContoller;
import com.wipro.PR377825.springboot.repository.CustomerRepo;
import com.wipro.PR377825.springboot.services.ResetPwService;


@SpringBootTest
public class ResetPWTests 
{
	
	@Autowired
	ResetPWRestContoller resetCtrl;
	
//	@InjectMocks
//	ResetPWRestContoller resetCtrl;
//	@Mock
//	ResetPwService resetService;
//	@InjectMocks
//	ResetPwService resetService2;
//	@Mock
//	CustomerRepo custRepo;
	
	
	@Test
	public void ResetCustomerPasswordSuccess()
	{
		System.out.println("Running unit test case");
		String userID = "PK01";
		
		ResetPwHTML HTMLobj = new ResetPwHTML();
		HTMLobj.setUserId(userID);
		HTMLobj.setPassword("1234");
		HTMLobj.setConfirmPW("1234");
		
		ResponseEntity<String> response = resetCtrl.resetPassword(userID, HTMLobj);
		System.out.println("result: "+response);

		assertEquals(new ResponseEntity<>("Password has been reset successfully", HttpStatus.OK), response);

		System.out.println("test case ended");
	}
	
	
	@Test
	public void ResetCustomerPasswordFailure()
	{
		System.out.println("Running unit test case");
		String userID = "PK01";
		
		ResetPwHTML HTMLobj = new ResetPwHTML();
		HTMLobj.setUserId(userID);
		HTMLobj.setPassword("1234");
		HTMLobj.setConfirmPW("12389");
		
		ResponseEntity<String> response = resetCtrl.resetPassword(userID, HTMLobj);
		System.out.println("result: "+response);

		assertEquals(new ResponseEntity<>("Passwords mismatch", HttpStatus.BAD_REQUEST), response);

		System.out.println("test case ended");
	}
	
	
	@Test
	public void ResetCustomerPasswordIncorrectIDFailure()
	{
		System.out.println("Running unit test case");
		String userID = "PK02";
		
		ResetPwHTML HTMLobj = new ResetPwHTML();
		HTMLobj.setUserId(userID);
		HTMLobj.setPassword("1234");
		HTMLobj.setConfirmPW("1234");
		
		ResponseEntity<String> response = resetCtrl.resetPassword(userID, HTMLobj);
		System.out.println("result: "+response);

		assertEquals(new ResponseEntity<>("Incorrect UserID", HttpStatus.BAD_REQUEST), response);

		System.out.println("test case ended");
	}
}
