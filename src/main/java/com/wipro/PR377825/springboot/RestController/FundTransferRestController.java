package com.wipro.PR377825.springboot.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.PR377825.springboot.HTML.FundTransferHTML;
import com.wipro.PR377825.springboot.services.CreditService;
import com.wipro.PR377825.springboot.services.DebitService;
import com.wipro.PR377825.springboot.services.EnquiryService;
import com.wipro.PR377825.springboot.services.FundTransferService;

@RestController
@RequestMapping("/Rest")
public class FundTransferRestController 
{	
	@Autowired
	DebitService debitService;
	@Autowired
	CreditService creditService;
	@Autowired
	EnquiryService enqService;
	@Autowired
	FundTransferService fundService;


	@PostMapping("/FundTransfer")
	public ResponseEntity<String> transferFunds(@RequestBody FundTransferHTML HTMLobj) 
	{
		try 
		{
			long fromAcc = HTMLobj.getFromAcc();
			System.out.println("fromAcc from Fund Transfer form: "+fromAcc);		
			try
			{ 
				long toAcc = HTMLobj.getToAcc();
				System.out.println("toAcc from Fund Transfer form: "+toAcc);

				if (fromAcc != toAcc)
				{
					long toAccNum = fundService.checkAccNumber(toAcc);
					if (toAccNum != 0)
					{
						String Status = enqService.findStatus(toAcc);
						if (Status.equalsIgnoreCase("Active"))
						{
							System.out.println("beneficiary account is active");

							double amt = HTMLobj.getAmount();
							System.out.println("amt from Fund Transfer form: "+amt);
							double balance = enqService.findBalance(fromAcc);
							if (balance >= amt)
							{
								String remark = HTMLobj.getRemark();

								// debit leg
								double closingBal = balance - amt;
								System.out.println("closing balance after debit: "+closingBal);

								debitService.updateDetails(fromAcc, closingBal, remark, amt, balance, "fund Transfer");
								System.out.println("account " + fromAcc + " has been debited successfully");


								// credit leg
								balance = enqService.findBalance(toAcc);
								System.out.println("balance from db: "+balance);

								closingBal = balance + amt;
								System.out.println("closing balance after debit: "+closingBal);

								creditService.updateDetails(toAcc, closingBal, remark, amt, balance, "fund Transfer");
								System.out.println("account " + toAcc + " has been credited successfully");

								String response = "Amount " + amt + " has been transferred successfully from " + fromAcc + " to " + toAcc;

								return new ResponseEntity<>(response, HttpStatus.OK);

							}
							else
							{
								return new ResponseEntity<>("User does not have enough balance to transfer funds", HttpStatus.BAD_REQUEST);
							}
						}
						else
						{
							return new ResponseEntity<>("Beneficiary account is not active", HttpStatus.BAD_REQUEST);
						}
					}
					else
					{
						return new ResponseEntity<>("Beneficiary account does not exists", HttpStatus.BAD_REQUEST);
					}
				}
				else
				{
					return new ResponseEntity<>("Funds can't be transfered from and to same account", HttpStatus.BAD_REQUEST);
				}
			}
			catch (Exception e)
			{ 
				e.printStackTrace();
			}
			return null;		
		}
		catch (Exception e)
		{ 
			e.printStackTrace();
		}
		return null;
	}
}