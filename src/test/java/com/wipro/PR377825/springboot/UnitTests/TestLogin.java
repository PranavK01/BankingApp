//package com.wipro.PR377825.springboot.UnitTests;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.Spy;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.wipro.PR377825.springboot.HTML.LoginHTML;
//import com.wipro.PR377825.springboot.RestController.LoginRestController;
//import com.wipro.PR377825.springboot.repository.CustomerRepo;
//import com.wipro.PR377825.springboot.services.LoginService;
//
//public class TestLogin 
//{
//
//	@InjectMocks
//	LoginRestController logCtrl;
//
//	@Mock
//	LoginService Log;
//	
//	@InjectMocks
//	LoginService logService;
//
//	@Mock
//	CustomerRepo custRepo;
//
//	@Before
//	public void init() 
//	{
//		MockitoAnnotations.initMocks(this);
//	}
//
//
//	@Test
//	public void testLogin()
//	{
//				System.out.println("Running unit test case");
//				LoginHTML HTMLobj = new LoginHTML();
//				
//				HTMLobj.setUserID("PK01");
//				HTMLobj.setPassword("123");
//				
////		String id = "PK01";
////		String pas = "123";
//		System.out.println(HTMLobj.getUserId() + "\n" + HTMLobj.getPassword());
//		//		
//		//		LoginRestController logCtrl = new LoginRestController();
//
////		LoginService logService = new LoginService();
//
//		System.out.println("calling checkLogin method from loginREstController");
//
//				ResponseEntity<String> res = logCtrl.checkLogin(HTMLobj);
//				System.out.println("response: "+res);
//
////		String response="";
//
////		System.out.println("Checking for userID and password");
////		try
////		{ 
////
////			String userID = logService.getID(id);
////			System.out.println("userUserID from loginService:" + userID);
////			//
////			if ((userID != null))
////			{
////				System.out.println("UserID matched");
////				//
////				String passwrd = logService.getPassword(id);
////				System.out.println("passwrd from loginService:" + passwrd);
////				//
////				if (passwrd.equals(pas))
////				{
////					System.out.println("password matched");
////					//
////					response = "UserID matched" + "\nPassword matched" + "\nLogin Success";
//					//				
//
//					System.out.println("checking assertions");
//
//					String expected = "UserID matched" + "\nPassword matched" + "\nLogin Success";
//
//					assertEquals(expected, res);
//				}
////			}
////		}
////
//
//		//		assertEquals(new ResponseEntity<>(response, HttpStatus.OK), response);
//		//	System.out.println("test case ended");
//
//		//		String response="";
//		//		
//		//		System.out.println("Checking for userID and password");
//		//		try
//		//		{ 
//		//			String userID = logService.getID(id);
//		//			//		System.out.println("userUserID from loginService:" + userID);
//		//
//		//			if ((userID != null))
//		//			{
//		//				System.out.println("UserID matched");
//		//
//		//				String passwrd = logService.getPassword(id);
//		//				//			System.out.println("passwrd from loginService:" + passwrd);
//		//
//		//				if (passwrd.equals(pas))
//		//				{
//		//					System.out.println("password matched");
//		//
//		//					response = "UserID matched" + "\nPassword matched" + "\nLogin Success";
//		//					
//		////					return new ResponseEntity<>(response, HttpStatus.OK);
//		//				}
//		//				
//		//			}
//		//			String expected = "UserID matched" + "\nPassword matched" + "\nLogin Success";
//		//			
//		//			assertEquals(expected, response);
//		//			
//		//		}
////		catch(Exception e)
////		{
////			e.printStackTrace();
////		}
////
////
////	}
//}
