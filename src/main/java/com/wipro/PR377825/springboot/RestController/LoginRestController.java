package com.wipro.PR377825.springboot.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.PR377825.springboot.HTML.LoginHTML;
import com.wipro.PR377825.springboot.services.LoginService;

@RestController
@RequestMapping("/Rest")
public class LoginRestController 
{
	@Autowired
	LoginService logService;
	
	
	@PostMapping("/Login")
	public ResponseEntity<String> checkLogin(@RequestBody LoginHTML HTMLobj) 
	{
		String UserID = HTMLobj.getUserId();
		//	System.out.println("UserID from HTML input:" + UserID);

		String password = HTMLobj.getPassword();
		//	System.out.println("Password from HTML input:" + password);

		System.out.println("checking UserID and password");

		try
		{ 
			String userID = logService.getID(UserID);
			//		System.out.println("userUserID from loginService:" + userID);

			if ((userID != null) && (userID.equals(UserID)))
			{
				System.out.println("UserID matched");

				String passwrd = logService.getPassword(UserID);
				//			System.out.println("passwrd from loginService:" + passwrd);

				if (passwrd.equals(password))
				{
					System.out.println("password matched");

					String response = "UserID matched" + "\nPassword matched" + "\nLogin Success";
					
					return new ResponseEntity<>(response, HttpStatus.OK);
				}
				else
				{	
					return new ResponseEntity<>("Incorrect Password", HttpStatus.BAD_REQUEST);
				}
			}
			else
			{	
				return new ResponseEntity<>("Incorrect UserID", HttpStatus.BAD_REQUEST);
			}
		}
		catch (Exception e)
		{ 
			e.printStackTrace();
		}
		return null;		
	}

}
