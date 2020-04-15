package com.wipro.PR377825.springboot.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.wipro.PR377825.springboot.entity.CurrentAccount;
import com.wipro.PR377825.springboot.entity.Customer;
import com.wipro.PR377825.springboot.entity.SavingAccount;

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


	@GetMapping("/AllSavingAccounts")
	public ResponseEntity<Collection<Map<String, String>>> getAllSavingAccounts()
	{
		List<SavingAccount> account = enqService.getAllSavingAccounts();

		Collection<Map<String, String>> maps = new HashSet<Map<String, String>>();

		for (SavingAccount tempSaveAccount : account) 
		{
			System.out.println(tempSaveAccount);
			Map<String, String> tempMap = new HashMap<String, String>();
			tempMap.put("Account Number", ""+tempSaveAccount.getAccNumber());
			tempMap.put("Account Type", ""+tempSaveAccount.getAccountType());
			tempMap.put("Balance", ""+tempSaveAccount.getBalance());
			tempMap.put("Currency", ""+tempSaveAccount.getCurrency());
			tempMap.put("Status", ""+tempSaveAccount.getStatus());
			tempMap.put("UserId", ""+tempSaveAccount.getFKuserID().getUserId());

			maps.add(tempMap);
		}

		return new ResponseEntity<Collection<Map<String, String>>>(maps, HttpStatus.OK);
	}

	@GetMapping("/AllCurrentAccounts")
	public ResponseEntity<Collection<Map<String, String>>> getAllCurrentAccounts()
	{
		List<CurrentAccount> account = enqService.getAllCurrentAccounts();

		Collection<Map<String, String>> maps = new HashSet<Map<String, String>>();

		for (CurrentAccount tempCurrAccount : account) 
		{
			System.out.println(tempCurrAccount);
			Map<String, String> tempMap = new HashMap<String, String>();
			tempMap.put("Account Number", ""+tempCurrAccount.getAccNumber());
			tempMap.put("Account Type", ""+tempCurrAccount.getAccountType());
			tempMap.put("Balance", ""+tempCurrAccount.getBalance());
			tempMap.put("Currency", ""+tempCurrAccount.getCurrency());
			tempMap.put("Status", ""+tempCurrAccount.getStatus());
			tempMap.put("UserId", ""+tempCurrAccount.getFKuserID1().getUserId());

			maps.add(tempMap);
		}

		return new ResponseEntity<Collection<Map<String, String>>>(maps, HttpStatus.OK);
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
		return new  ResponseEntity<String>("Customer details deleted", HttpStatus.OK);
	}



}