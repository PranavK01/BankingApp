package com.wipro.PR377825.springboot.RestController;

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
	public ResponseEntity<Customer> getProfileInfo(@PathVariable("phone") String number)
	{

		Customer profile = proService.getProfileByPhone(number);
// profile data needs to be sorted
		return new ResponseEntity<>(profile, HttpStatus.OK);
	}



	@PutMapping("/Profile/update/{UserID}")
	public ResponseEntity<Customer> updateProfile(@PathVariable("UserID") String ID, @RequestBody Customer custObj)
	{
		Customer update = proService.updateProfileById(ID, custObj);

		return new ResponseEntity<>(update, HttpStatus.OK);
	}

}
