package com.wipro.PR377825.springboot.UnitTests;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wipro.PR377825.springboot.HTML.LoginHTML;
import com.wipro.PR377825.springboot.RestController.LoginRestController;
import com.wipro.PR377825.springboot.services.NewCustomerService;

@SpringBootTest
public class LoginTests
{

	@Autowired
	LoginRestController logCtrl;
	
	@Autowired
	NewCustomerService newCustService;



	@Test
	public void testCustomerLoginSuccess()
	{
		System.out.println("Running unit test case - 'testCustomerLoginSuccess'");

		LoginHTML HTMLobj = new LoginHTML();

		HTMLobj.setUserID("PK01");
		HTMLobj.setPassword("123");

		System.out.println("calling checkLogin method from loginRestController");

		ResponseEntity<String> actual = logCtrl.checkLogin(HTMLobj);
		
		System.out.println("actual: "+actual);

		String expected = "UserID matched" + "\nPassword matched" + "\nLogin Success";
		
		System.out.println("checking assertions");

		assertEquals(new ResponseEntity<String>(expected, HttpStatus.OK), actual);

		System.out.println("testCustomerLoginSuccess Test case ended");
		System.out.println();
	}


	@Test
	public void testCustomerLoginIncorrectUserIDFailure()
	{
		System.out.println("Running unit test case - testCustomerLoginIncorrectUserIDFailure");
		LoginHTML HTMLobj = new LoginHTML();

		HTMLobj.setUserID("PK02");
		HTMLobj.setPassword("123");
		System.out.println("Trying to login with incorrect UserID");
		System.out.println("calling checkLogin method from loginRestController");

		ResponseEntity<String> actual = logCtrl.checkLogin(HTMLobj);
		System.out.println("actual: "+actual);
		
		String expected = "Incorrect UserID";

		System.out.println("checking assertions");

		assertEquals(new ResponseEntity<String>(expected, HttpStatus.BAD_REQUEST), actual);

		System.out.println("testCustomerLoginIncorrectUserIDFailure Test case ended");
		System.out.println();
	}



	@Test
	public void testLoginIncorrectPasswordFailure()
	{
		System.out.println("Running unit test case - testLoginIncorrectPasswordFailure");
		
		LoginHTML HTMLobj = new LoginHTML();

		HTMLobj.setUserID("PK01");
		HTMLobj.setPassword("12356");
		System.out.println("Trying to login with incorrect password");
		
		System.out.println("calling checkLogin method from loginREstController");

		ResponseEntity<String> actual = logCtrl.checkLogin(HTMLobj);
		System.out.println("actual: "+actual);

		String expected = "Incorrect Password";
		
		System.out.println("checking assertions");

		assertEquals(new ResponseEntity<String>(expected, HttpStatus.BAD_REQUEST), actual);

		System.out.println("testLoginIncorrectPasswordFailure Test case ended");
		System.out.println();
	}

}
