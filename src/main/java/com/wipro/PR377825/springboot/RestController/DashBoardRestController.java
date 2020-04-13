package com.wipro.PR377825.springboot.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//
import com.wipro.PR377825.springboot.services.DashboardService;
import com.wipro.PR377825.springboot.services.EnquiryService;
//import com.wipro.PR377825.springboot.services.LoginService;
//

import java.util.List;

import com.wipro.PR377825.springboot.entity.CurrentAccount;
import com.wipro.PR377825.springboot.entity.Customer;
import com.wipro.PR377825.springboot.entity.SavingAccount;

@RestController
@RequestMapping("/Rest")
public class DashBoardRestController 
{
	@Autowired
	DashboardService dashService;
	@Autowired
	EnquiryService enqService;
	
	
	@GetMapping("/AllCustomers")
	public List<Customer> getAllCustomers()
	{
		return dashService.getAllCustomers();
	}
	
	@GetMapping("/AllSavingAccounts")
	public List<SavingAccount> getAllSavingAccounts()
	{
		return enqService.getAllSavingAccounts();
	}
	
	@GetMapping("/AllCurrentAccounts")
	public List<CurrentAccount> getAllCurrentAccounts()
	{
		return enqService.getAllCurrentAccounts();
	}
	
	@DeleteMapping("/Customer/{userID}")
	public void deleteById(@PathVariable("userID") String ID)
	{
		dashService.deleteByUserID(ID);
	}
	
	@DeleteMapping("/Customer/deleteAll")
	public void deleteAll()
	{
		dashService.deleteAllCustomers();
	}
	
	
	
}