package com.wipro.PR377825.springboot.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wipro.PR377825.springboot.HTML.NewCustomerHTML;
import com.wipro.PR377825.springboot.services.NewCustomerService;

public class NewCustomerRestController {
	@Autowired
	NewCustomerService custService;


	@GetMapping(value="/create/newCustomer/form")
	public String displayForm()
	{
		return "NewCustomerForm";		
	}

	@PostMapping(value = "/create/newCustomer/ack", produces = "application/HTML")
	public String createCustomer(@ModelAttribute NewCustomerHTML HTMLobj , BindingResult result, ModelMap model) 
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
//				String Email = custService.checkEmail(email);
//				if (Email == null)
//				{
				custService.create(firstName, lastName, email, contact, userID, password, currentAcc);			

				model.addAttribute("name","to Bank");
				model.addAttribute("msg","Customer has been successfully created");
				model.addAttribute("back1","Login");
				
				return "Acknowledgement";
//				}
//				else
//				{					
//					model.addAttribute("name","to Bank");
//					model.addAttribute("msg","Email must be unique.");
//					model.addAttribute("back2","Back");
//										
//					return "Acknowledgement";
//				}
			}
			else
			{
				model.addAttribute("name","to Bank");
				model.addAttribute("msg","UserId already taken.");
				model.addAttribute("back2","Back");
				
				return "Acknowledgement";
			}
		}
		catch (Exception e)
		{ 
			e.printStackTrace();
		}

		return null;
	}

}

