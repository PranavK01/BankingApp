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
import com.wipro.PR377825.springboot.services.ProfileService;

@RestController
@RequestMapping("/Rest")
public class ProfileRestController 
{
	@Autowired
	ProfileService proService;


	@GetMapping("/Profile/{phone}")
	public ResponseEntity<Map<String,String>> getProfileInfo(@PathVariable("phone") String number)
	{
		HashMap<String, String> map = new HashMap<>();
		
		String details[] = proService.getProfileDetails(number);
		
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
	public ResponseEntity<Customer> updateProfile(@PathVariable("UserID") String ID, @RequestBody Customer custObj)
	{
		Customer update = proService.updateProfileById(ID, custObj);

		return new ResponseEntity<>(update, HttpStatus.OK);
	}

}
