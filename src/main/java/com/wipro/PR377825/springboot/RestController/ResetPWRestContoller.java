package com.wipro.PR377825.springboot.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.PR377825.springboot.HTML.ResetPwHTML;
import com.wipro.PR377825.springboot.services.ResetPwService;

@RestController
@RequestMapping("/Rest")
public class ResetPWRestContoller {
	@Autowired
	ResetPwService resetService;


	
	@PutMapping("/Reset/Password/{UserID}")
	public ResponseEntity<String> resetPassword(@PathVariable("UserID") String ID, @RequestBody ResetPwHTML HTMLobj)
	{
		try
		{ 
			String userID = resetService.getID(ID);
			System.out.println("userID from resetService :"+userID);

			if ((userID != null))
			{		
				System.out.println("userId matched");
				String password = HTMLobj.getPassword();
				String confirmPW = HTMLobj.getConfirmPW();

				if (password.equals(confirmPW))
				{
					System.out.println("passwords are same");

					resetService.updatePassword(userID, password);


					return new ResponseEntity<>("Password has been reset successfully", HttpStatus.OK);
				}
				else
				{	
					return new ResponseEntity<>("Passwords mismatch", HttpStatus.BAD_REQUEST);
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
