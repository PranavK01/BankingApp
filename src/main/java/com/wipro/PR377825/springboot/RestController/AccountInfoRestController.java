package com.wipro.PR377825.springboot.RestController;

import java.util.Optional;

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



	@GetMapping("/SavingAccountInfo/{AccNum}")
	public ResponseEntity<Optional<SavingAccount>> getSavingAccountInfo(@PathVariable("AccNum") Long accNum)
	{

		Optional<SavingAccount> accountNum = enqService.findByAccountNumber1(accNum);
		if (accountNum.isPresent())
		{		
			return new ResponseEntity<>(accountNum, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}


	@GetMapping(value = "/CurrentAccountInfo/{AccNum}")
	public ResponseEntity<Optional<CurrentAccount>> getCurrentAccountInfo(@PathVariable("AccNum") Long accNum)
	{

		Optional<CurrentAccount> accountNum = enqService.findByAccountNumber2(accNum);
		if (accountNum.isPresent())
		{		
			return new ResponseEntity<>(accountNum, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
