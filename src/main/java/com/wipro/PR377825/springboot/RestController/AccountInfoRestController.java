package com.wipro.PR377825.springboot.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.PR377825.springboot.entity.CurrentAccount;
import com.wipro.PR377825.springboot.entity.SavingAccount;
import com.wipro.PR377825.springboot.services.EnquiryService;

@RestController
@RequestMapping("/Rest")
public class AccountInfoRestController 
{
	@Autowired
	EnquiryService enqService;




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
	
	
	@GetMapping("/SavingAccountInfo/{AccNum}")
	public ResponseEntity<Map<String, String>> getSavingAccountInfoByID(@PathVariable("AccNum") Long accNum)
	{
		HashMap<String, String> map = new HashMap<>();
		String account[] = enqService.findByAccountNumberSaving(accNum);
			
			String accountNum = account[0];
			String accType = account[1];
			String balance = account[2];
			String status = account[3];
			String currency = account[4];

			map.put("Account Number",accountNum);
			map.put("Account Type",accType);
			map.put("Balance",balance);
			map.put("Status",status);
			map.put("Currency",currency);

			return new ResponseEntity<>(map, HttpStatus.OK);
	}


	@GetMapping(value = "/CurrentAccountInfo/{AccNum}")
	public ResponseEntity<Map<String, String>> getCurrentAccountInfoByID(@PathVariable("AccNum") Long accNum)
	{
		HashMap<String, String> map = new HashMap<>();
		String account[] = enqService.findByAccountNumberCurrent(accNum);
			
			String accountNum = account[0];
			String accType = account[1];
			String balance = account[2];
			String status = account[3];
			String currency = account[4];

			map.put("Account Number",accountNum);
			map.put("Account Type",accType);
			map.put("Balance",balance);
			map.put("Status",status);
			map.put("Currency",currency);

			return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
