package com.wipro.PR377825.springboot.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.PR377825.springboot.HTML.NewCustomerHTML;
import com.wipro.PR377825.springboot.services.NewCustomerService;

@RestController
@RequestMapping("/Rest")
public class NewCustomerRestController {
	@Autowired
	NewCustomerService custService;



	@PostMapping("/create/newCustomer")
	public ResponseEntity<String> createCustomer(@RequestBody NewCustomerHTML HTMLobj) 
	{
		String firstName = HTMLobj.getFirstName();		
		System.out.println("firstName from HTML input:" + firstName);

		String lastName = HTMLobj.getLastName();		
		System.out.println("lastName from HTML input:" + lastName);

		String email = HTMLobj.getEmail();		
		System.out.println("email from HTML input:" + email);

		String contact = HTMLobj.getphone();		
		System.out.println("contact number from HTML input:" + contact);

		String userID = HTMLobj.getUserId();
		System.out.println("userID from HTML input:" + userID);

		String password = HTMLobj.getPassword();
		System.out.println("Password from HTML input:" + password);

		String currentAcc = HTMLobj.getCurrentAcc();
		System.out.println("Is current account needed: " + currentAcc);

		try 
		{
			String userId = custService.checkUserID(userID);
			if (userId == null)
			{
				String Email = custService.checkEmail(email);
				if (Email == null)
				{
					String phone = custService.checkContactNumber(contact);
					if (phone == null)
					{
						custService.addNewCustomer(firstName, lastName, email, contact, userID, password, currentAcc);			

						return new ResponseEntity<String>("New Customer has been successfully created", HttpStatus.OK);
					}
					else 
					{					
						return new ResponseEntity<String>("Contact Number must be unique", HttpStatus.BAD_REQUEST);
					}
				}
				else
				{					
					return new ResponseEntity<String>("Email must be unique", HttpStatus.BAD_REQUEST);
				}
			}
			else
			{				
				return new ResponseEntity<String>("UserId already taken", HttpStatus.BAD_REQUEST);
			}
		}
		catch (Exception e)
		{ 
			e.printStackTrace();
		}

		return null;
	}

}

