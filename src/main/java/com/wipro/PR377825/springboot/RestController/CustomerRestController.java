package com.wipro.PR377825.springboot.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.PR377825.springboot.services.DashboardService;
import com.wipro.PR377825.springboot.services.EnquiryService;
import java.util.List;
import com.wipro.PR377825.springboot.entity.Customer;


@RestController
@RequestMapping("/Rest")
public class CustomerRestController 
{
	@Autowired
	DashboardService dashService;
	@Autowired
	EnquiryService enqService;


	@GetMapping("/AllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers()
	{
		List<Customer> customer = dashService.getAllCustomers();
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}


	@DeleteMapping("/Customer/{userID}")
	public ResponseEntity<String> deleteById(@PathVariable("userID") String ID)
	{

		dashService.deleteByUserID(ID);
		return new  ResponseEntity<String>("Customer details deleted for UserID "+ID, HttpStatus.OK);
	}

	@DeleteMapping("/Customer/deleteAll")
	public ResponseEntity<String> deleteAll()
	{
		dashService.deleteAllCustomers();
		return new  ResponseEntity<String>("All Customer details deleted", HttpStatus.OK);
	}



}