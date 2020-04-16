package com.wipro.PR377825.springboot.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.PR377825.springboot.entity.Customer;
import com.wipro.PR377825.springboot.services.NewCustomerService;
import com.wipro.PR377825.springboot.services.ProfileService;

@RestController
@RequestMapping("/Rest")
public class ProfileRestController 
{
	@Autowired
	ProfileService proService;
	@Autowired
	NewCustomerService newCustService;



	@GetMapping("/Profile/{phone}")
	public ResponseEntity<Map<String,String>> getProfileByPhone(@PathVariable("phone") String number)
	{
		HashMap<String, String> map = new HashMap<>();

		String details[] = proService.getProfileByPhone(number);

		String fname = details[0];
		String lname = details[1];
		String phone = details[2];
		String email = details[3];

		map.put("firstName",fname);
		map.put("lastName",lname);
		map.put("email",email);
		map.put("phone",phone);


		return new ResponseEntity<>(map, HttpStatus.OK);
	}



	@PutMapping("/Profile/update/{UserID}")
	public ResponseEntity<String> updateProfile(@PathVariable("UserID") String ID, @RequestBody Customer custObj)
	{	
		String details ="";

		if ((custObj.getUserId()) == null)
		{		
			if ((custObj.getPassword()) == null)
			{
				String profile[] = proService.getProfileDetails(ID);
				String fname = profile[0];
				String lname = profile[1];
				String email = profile[3];

				if (fname.equals(custObj.getFirstName()))
				{
					if (lname.equals(custObj.getLastName()))
					{
						if (email.equals(custObj.getEmail()))
						{
							String Contact = newCustService.checkContactNumber(custObj.getPhone());
							if (Contact == null)
							{
								String field = "Contact Number";
								details = proService.updateProfileById(ID, field, custObj.getPhone());
							}
							else
							{
								details = "Contact number already exits";
								return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
							}
						}
						else
						{
							String Email = newCustService.checkEmail(custObj.getEmail());
							if(Email == null )
							{
								String field = "Email";
								details = proService.updateProfileById(ID, field, custObj.getEmail());
							}
							else
							{
								details = "Email already taken";
								return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
							}
						}
					}
					else
					{
						String field = "LastName";
						details = proService.updateProfileById(ID, field, custObj.getLastName());
					}
				}
				else
				{
					String field = "FirstName";
					details = proService.updateProfileById(ID, field, custObj.getFirstName());
				}
			}
			else
			{
				details = "Password cannot be updated here. Use reset password option or try another request without password field in input";
				return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
			}
		}
		else
		{
			details = "Try another request without userID field in request input";
			return new ResponseEntity<>(details,HttpStatus.BAD_REQUEST);
			
		}

		return new ResponseEntity<>(details, HttpStatus.OK);
	}
}
