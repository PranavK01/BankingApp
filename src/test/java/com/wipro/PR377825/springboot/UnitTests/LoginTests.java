package com.wipro.PR377825.springboot.UnitTests;

import static org.junit.Assert.assertEquals;

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

import com.wipro.PR377825.springboot.HTML.LoginHTML;
import com.wipro.PR377825.springboot.RestController.LoginRestController;
import com.wipro.PR377825.springboot.entity.Customer;
import com.wipro.PR377825.springboot.repository.CurrentAccRepo;
import com.wipro.PR377825.springboot.repository.CustomerRepo;
import com.wipro.PR377825.springboot.repository.SavingAccRepo;
import com.wipro.PR377825.springboot.services.DashboardService;
import com.wipro.PR377825.springboot.services.LoginService;
import com.wipro.PR377825.springboot.services.NewCustomerService;

@SpringBootTest
public class LoginTests
{

	@Autowired
	LoginRestController logCtrl;
	
//	@Mock
//	LoginService LogServ;
//	@InjectMocks
//	LoginService logService;
//	@Mock
//	CustomerRepo custRepo;
//
//	@InjectMocks
//	NewCustomerService newCustService;
//	@Mock
//	SavingAccRepo saverepo;
//	@Mock
//	CurrentAccRepo currRepo;
//
//	@InjectMocks
//	DashboardService dashService;
//	@Mock
//	CustomerRepo repo;


//	@Before
//	public void init() 
//	{
//		MockitoAnnotations.initMocks(this);
//		
////		newCustService.addNewCustomer("Pranav", "Kalra", "pranav.kalra3@wipro.com", "9717275141", "PK01", "123", "Saving");
//	}



	//	Test for successful login
	@Test
	public void testLoginSuccess()
	{
		System.out.println("Running unit test case");

//		newCustService.addNewCustomer("Pranav", "Kalra", "pranav.kalra3@wipro.com", "9717275141", "PK01", "123", "Saving");

//		List<Customer> list = dashService.getAllCustomers();

//		System.out.println("data from customer: "+ list);

		LoginHTML HTMLobj = new LoginHTML();

		HTMLobj.setUserID("PK01");
		HTMLobj.setPassword("123");

		System.out.println(HTMLobj.getUserId() + "\n" + HTMLobj.getPassword());

		System.out.println("calling checkLogin method from loginRestController");

		ResponseEntity<String> res = logCtrl.checkLogin(HTMLobj);
		System.out.println("response: "+res);

		String response = "UserID matched" + "\nPassword matched" + "\nLogin Success";
		
		System.out.println("checking assertions");

		assertEquals(new ResponseEntity<String>(response, HttpStatus.OK), res);

		System.out.println("Test case ended");
	}


	@Test
	public void testLoginIncorrectUserIDFailure()
	{
		System.out.println("Running unit test case");
		LoginHTML HTMLobj = new LoginHTML();

		HTMLobj.setUserID("PK02");
		HTMLobj.setPassword("123");

		System.out.println(HTMLobj.getUserId() + "\n" + HTMLobj.getPassword());

		System.out.println("calling checkLogin method from loginRestController");

		ResponseEntity<String> res = logCtrl.checkLogin(HTMLobj);
		System.out.println("response: "+res);

		System.out.println("checking assertions");

		assertEquals(new ResponseEntity<String>("Incorrect UserID", HttpStatus.BAD_REQUEST), res);

		System.out.println("Test case ended");
	}



	@Test
	public void testLoginIncorrectPasswordFailure()
	{
		System.out.println("Running unit test case");
		System.out.println("Inserting initial data in table");

//		newCustService.addNewCustomer("Pranav", "Kalra", "pranav.kalra3@wipro.com", "9717275141", "PK01", "123", "Saving");

//		List<Customer> list = dashService.getAllCustomers();

//		System.out.println("data from customer: "+ list);

		System.out.println("Trying to login with incorrect password");
		LoginHTML HTMLobj = new LoginHTML();

		HTMLobj.setUserID("PK01");
		HTMLobj.setPassword("12356");

		System.out.println(HTMLobj.getUserId() + "\n" + HTMLobj.getPassword());

		System.out.println("calling checkLogin method from loginREstController");

		ResponseEntity<String> res = logCtrl.checkLogin(HTMLobj);
		System.out.println("response: "+res);

		System.out.println("checking assertions");

		assertEquals(new ResponseEntity<String>("Incorrect Password", HttpStatus.BAD_REQUEST), res);

		System.out.println("Test case ended");
	}

}
