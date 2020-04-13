package com.wipro.PR377825.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wipro.PR377825.springboot.HTML.ResetPwHTML;
import com.wipro.PR377825.springboot.services.ResetPwService;


@Controller
public class ResetPWContoller 
{
	@Autowired
	ResetPwService resetService;

	
	
	@GetMapping("/forgotPassword")
	public String resetPassword()
	{
		return "ResetPasswordForm";
	}


	
	@PostMapping(value = "/forgotPassword/Ack", produces = "application/HTML")
	public String updatePassword(@ModelAttribute ResetPwHTML HTMLobj , BindingResult result, ModelMap model) 
	{
		String UserId = HTMLobj.getUserId();
		System.out.println("UserId from resetPW form: "+UserId);

		try
		{ 
			String userID = resetService.getID(UserId);
			System.out.println("userID from resetService :"+userID);

			if ((userID != null) && (userID.equals(UserId)))
			{		
				System.out.println("userId matched");
				String password = HTMLobj.getPassword();
				String confirmPW = HTMLobj.getConfirmPW();

				if (password.equals(confirmPW))
				{
					System.out.println("passwords are same");

					resetService.updatePassword(userID, password);

					model.addAttribute("name","to Bank");
					model.addAttribute("msg","Password has been successfully reset");
					model.addAttribute("back1","Login");

					return "Acknowledgement";					
				}

				else
				{					
					model.addAttribute("name","to Bank");
					model.addAttribute("msg","Password mismatch");
					model.addAttribute("back3","Back");
										
					return "Acknowledgement";
				}
			}
			else
			{
				model.addAttribute("name","to Bank");
				model.addAttribute("msg","Please enter correct User ID");
				model.addAttribute("back3","Back");
									
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