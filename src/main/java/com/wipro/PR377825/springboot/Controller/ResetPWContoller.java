package com.wipro.PR377825.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.PR377825.springboot.HTML.ResetPwHTML;
import com.wipro.PR377825.springboot.services.ResetPwService;


@Controller
public class ResetPWContoller 
{
	@Autowired
	ResetPwService resetService;

	
	private String password;

	@RequestMapping("/forgotPassword")
	public String resetPW()
	{
		return "ResetPasswordForm";
	}


	@RequestMapping(value = "/forgotPassword/Ack", produces = "application/HTML")
	public String ResetPWack(@ModelAttribute ResetPwHTML HTMLobj , BindingResult result, ModelMap model) 
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
				setPassword(HTMLobj.getPassword());
				String confirmPW = HTMLobj.getConfirmPW();

				if (getPassword().equals(confirmPW))
				{
					System.out.println("passwords are same");

					resetService.updatePassword(userID);

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


	// getters and setters for variables
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

}