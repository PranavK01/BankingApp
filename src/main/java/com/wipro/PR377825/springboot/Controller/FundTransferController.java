package com.wipro.PR377825.springboot.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.wipro.PR377825.springboot.HTML.FundTransferHTML;
import com.wipro.PR377825.springboot.services.CreditService;
import com.wipro.PR377825.springboot.services.DebitService;
import com.wipro.PR377825.springboot.services.EnquiryService;
import com.wipro.PR377825.springboot.services.FundTransferService;


@Controller
public class FundTransferController 
{
	@Autowired
	DebitService debitService;
	@Autowired
	CreditService creditService;
	@Autowired
	EnquiryService enqService;
	@Autowired
	DashboardController dashCrtl;
	@Autowired
	FundTransferService fundService;

	private long fromAcc,toAcc;
	private double amt;
	private String remark, type;


	@GetMapping("/dashboard/FundTransfer/inter")
	public String getInterFund(Model model)
	{
		type = "Inter Account transfer";
		System.out.println("type: "+type);
		model.addAttribute("name",dashCrtl.getCustomerName());
		model.addAttribute("fromSavingAcc",dashCrtl.getSavingAccNumber());
		model.addAttribute("fromCurrentAcc",dashCrtl.getCurrentAccNumber());

		return "InterFundTransferForm";
	}


	@GetMapping("/dashboard/FundTransfer/other")
	public String getOtherFund(Model model)
	{
		type = "Other Account transfer";
		System.out.println("type: "+type);
		model.addAttribute("name",dashCrtl.getCustomerName());
		model.addAttribute("fromSavingAcc",dashCrtl.getSavingAccNumber());
		model.addAttribute("fromCurrentAcc",dashCrtl.getCurrentAccNumber());

		return "OtherFundTransferForm";
	}



	@PostMapping(value = "/dashboard/FundTransfer/confirm", produces = "application/HTML")
	public String updateFunds(@ModelAttribute FundTransferHTML HTMLobj , BindingResult result, ModelMap model) 
	{
		fromAcc = HTMLobj.getFromAcc();
		System.out.println("fromAcc from Fund Transfer form: "+fromAcc);		
		try
		{ 
			toAcc = HTMLobj.getToAcc();
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

						amt = HTMLobj.getAmount();
						System.out.println("amt from Fund Transfer form: "+amt);
						double amount = enqService.findBalance(fromAcc);
						if (amount >= amt)
						{
							System.out.println("enough balance to transfer funds");

							remark = HTMLobj.getRemark();
							System.out.println("Description from Fund transfer form: "+remark);

							model.addAttribute("name",dashCrtl.getCustomerName());
							model.addAttribute("fromAcc",fromAcc);
							model.addAttribute("toAcc",toAcc);		
							model.addAttribute("amount",amt);
							model.addAttribute("Remark",remark);

							return "FundTransferConfirm";					
						}
						else
						{
							if (type == "Inter Account transfer")
							{
								model.addAttribute("name",dashCrtl.getCustomerName());
								model.addAttribute("msg","User does not have enough balance to transfer funds");
								model.addAttribute("back4","Back");
							}
							else 
							{
								model.addAttribute("name",dashCrtl.getCustomerName());
								model.addAttribute("msg","User does not have enough balance to transfer funds");
								model.addAttribute("back5","Back");
							}

							return "Acknowledgement";
						}
					}

					else
					{
						if (type == "Inter Account transfer")
						{
							model.addAttribute("name",dashCrtl.getCustomerName());
							model.addAttribute("msg","Beneficiary account is not active");
							model.addAttribute("back4","Back");
						}
						else 
						{
							model.addAttribute("name",dashCrtl.getCustomerName());
							model.addAttribute("msg","Beneficiary account is not active");
							model.addAttribute("back5","Back");
						}

						return "Acknowledgement";
					}
				}

				else
				{
					if (type == "Inter Account transfer")
					{
						model.addAttribute("name",dashCrtl.getCustomerName());
						model.addAttribute("msg","Beneficiary account does not exists");
						model.addAttribute("back4","Back");
					}
					else 
					{
						model.addAttribute("name",dashCrtl.getCustomerName());
						model.addAttribute("msg","Beneficiary account does not exists");
						model.addAttribute("back5","Back");
					}

					return "Acknowledgement";
				}
			}

			else
			{
				if (type == "Inter Account transfer")
				{
					model.addAttribute("name",dashCrtl.getCustomerName());
					model.addAttribute("msg","Funds can't be transfered from and to same account");
					model.addAttribute("back4","Back");
				}
				else 
				{
					model.addAttribute("name",dashCrtl.getCustomerName());
					model.addAttribute("msg","Funds can't be transfered from and to same account");
					model.addAttribute("back5","Back");
				}

				return "Acknowledgement";

			}
		}
		catch (Exception e)
		{ 
			e.printStackTrace();
		}
		return null;		
	}


	@PostMapping(value="/dashboard/FundTransfer/confirm/ack", produces = "application/HTML")
	public String saveFunds(ModelMap model) 
	{
		try 
		{
			double balance, closingBal;

			// debit leg
			balance = enqService.findBalance(fromAcc);
			System.out.println("balance from db: "+balance);

			closingBal = balance - amt;
			System.out.println("closing balance after debit: "+closingBal);

			debitService.updateDetails(fromAcc, closingBal, remark, amt, balance, type);
			System.out.println("account " + fromAcc + " has been debited successfully");


			// credit leg
			balance = enqService.findBalance(toAcc);
			System.out.println("balance from db: "+balance);

			closingBal = balance + amt;
			System.out.println("closing balance after debit: "+closingBal);

			creditService.updateDetails(toAcc, closingBal, remark, amt, balance, type);
			System.out.println("account " + toAcc + " has been credited successfully");

			model.addAttribute("name",dashCrtl.getCustomerName());
			model.addAttribute("msg","Amount "+amt+" has been transferred successfully from "+fromAcc+" to "+toAcc);
			model.addAttribute("back","Home");

			return "Acknowledgement";

		}
		catch (Exception e)
		{ 
			e.printStackTrace();
		}
		return null;
	}


	// getters and setters for variables
	public long getFromAcc() {
		return fromAcc;
	}

	public void setFromAcc(long fromAcc) {
		this.fromAcc = fromAcc;
	}

	public long getToAcc() {
		return toAcc;
	}

	public void setToAcc(long toAcc) {
		this.toAcc = toAcc;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
