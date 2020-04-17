package com.wipro.PR377825.springboot.UnitTests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wipro.PR377825.springboot.HTML.FundTransferHTML;
import com.wipro.PR377825.springboot.RestController.FundTransferRestController;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class BFundTransferTests 
{
	@Autowired
	FundTransferRestController fundTranRestCtrl;
	
	
	@Order(1)
	@Test
	public void fundTransferSuccess()
	{
		System.out.println("Running unit test case - 'testCustomerLoginSuccess'");
		
		long fromAcc = 20049;
		long toAcc = 40056;
		double amt = 600.0;
		
		FundTransferHTML HTMLobj = new FundTransferHTML();
		HTMLobj.setFromAcc(fromAcc);
		HTMLobj.setToAcc(toAcc);
		HTMLobj.setAmount(amt);
		HTMLobj.setRemark("fund transfer check");
		
		System.out.println("calling transferFunds method from FundTransferRestController");

		ResponseEntity<String> actual = fundTranRestCtrl.transferFunds(HTMLobj);
		
		System.out.println("actual: "+actual);

		String expected = "Amount " + amt + " has been transferred successfully from " + fromAcc + " to " + toAcc;
		
		System.out.println("checking assertions");

		assertEquals(new ResponseEntity<String>(expected, HttpStatus.OK), actual);

		System.out.println("testCustomerLoginSuccess Test case ended");
		System.out.println();
	}

	
	
	@Order(2)
	@Test
	public void fundTransferInsufficientBalanceFailure()
	{
		System.out.println("Running unit test case - 'fundTransferInsufficientBalanceFailure'");
		
		long fromAcc = 20049;
		long toAcc = 40056;
		double amt = 26000.0;
		
		FundTransferHTML HTMLobj = new FundTransferHTML();
		HTMLobj.setFromAcc(fromAcc);
		HTMLobj.setToAcc(toAcc);
		HTMLobj.setAmount(amt);
		HTMLobj.setRemark("fund transfer check");
		
		System.out.println("calling transferFunds method from FundTransferRestController");

		ResponseEntity<String> actual = fundTranRestCtrl.transferFunds(HTMLobj);
		
		System.out.println("actual: "+actual);

		String expected = "User does not have enough balance to transfer funds";
		
		System.out.println("checking assertions");

		assertEquals(new ResponseEntity<String>(expected, HttpStatus.BAD_REQUEST), actual);

		System.out.println("fundTransferInsufficientBalanceFailure Test case ended");
		System.out.println();
	}

	
	
	@Order(3)
	@Test
	public void fundTransferBeneficiaryInactiveFailure()
	{
		System.out.println("Running unit test case - 'fundTransferBeneficiaryInactiveFailure'");
		
		long fromAcc = 20049;
		long toAcc = 40010;
		double amt = 600.0;
		
		FundTransferHTML HTMLobj = new FundTransferHTML();
		HTMLobj.setFromAcc(fromAcc);
		HTMLobj.setToAcc(toAcc);
		HTMLobj.setAmount(amt);
		HTMLobj.setRemark("fund transfer check");
		
		System.out.println("calling transferFunds method from FundTransferRestController");

		ResponseEntity<String> actual = fundTranRestCtrl.transferFunds(HTMLobj);
		
		System.out.println("actual: "+actual);

		String expected = "Beneficiary account is not active";
		
		System.out.println("checking assertions");

		assertEquals(new ResponseEntity<String>(expected, HttpStatus.BAD_REQUEST), actual);

		System.out.println("fundTransferBeneficiaryInactiveFailure Test case ended");
		System.out.println();
	}

	
	
	@Order(4)
	@Test
	public void fundTransferBeneficiaryAccountNotExistsFailure()
	{
		System.out.println("Running unit test case - 'fundTransferBeneficiaryAccountNotExistsFailure'");
		
		long fromAcc = 20049;
		long toAcc = 40890;
		double amt = 600.0;
		
		FundTransferHTML HTMLobj = new FundTransferHTML();
		HTMLobj.setFromAcc(fromAcc);
		HTMLobj.setToAcc(toAcc);
		HTMLobj.setAmount(amt);
		HTMLobj.setRemark("fund transfer check");
		
		System.out.println("calling transferFunds method from FundTransferRestController");

		ResponseEntity<String> actual = fundTranRestCtrl.transferFunds(HTMLobj);
		
		System.out.println("actual: "+actual);

		String expected = "Beneficiary account does not exists";
		
		System.out.println("checking assertions");

		assertEquals(new ResponseEntity<String>(expected, HttpStatus.BAD_REQUEST), actual);

		System.out.println("fundTransferBeneficiaryAccountNotExistsFailure Test case ended");
		System.out.println();
	}

	
	
	@Order(5)
	@Test
	public void fundTransferFromAndToSameAccountFailure()
	{
		System.out.println("Running unit test case - 'fundTransferFromAndToSameAccountFailure'");
		
		long fromAcc = 20049;
		long toAcc = 20049;
		double amt = 600.0;
		
		FundTransferHTML HTMLobj = new FundTransferHTML();
		HTMLobj.setFromAcc(fromAcc);
		HTMLobj.setToAcc(toAcc);
		HTMLobj.setAmount(amt);
		HTMLobj.setRemark("fund transfer check");
		
		System.out.println("calling transferFunds method from FundTransferRestController");

		ResponseEntity<String> actual = fundTranRestCtrl.transferFunds(HTMLobj);
		
		System.out.println("actual: "+actual);

		String expected = "Funds can't be transfered from and to same account";
		
		System.out.println("checking assertions");

		assertEquals(new ResponseEntity<String>(expected, HttpStatus.BAD_REQUEST), actual);

		System.out.println("fundTransferFromAndToSameAccountFailure Test case ended");
		System.out.println();
	}

}
