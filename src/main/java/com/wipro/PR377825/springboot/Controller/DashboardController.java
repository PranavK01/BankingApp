package com.wipro.PR377825.springboot.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wipro.PR377825.springboot.HTML.LoginHTML;
import com.wipro.PR377825.springboot.services.DashboardService;
import com.wipro.PR377825.springboot.services.EnquiryService;
import com.wipro.PR377825.springboot.services.LoginService;

@Controller
public class DashboardController 
{
	@Autowired
	LoginService logService;
	@Autowired
	DashboardService dashService;
	@Autowired
	EnquiryService enqService;

	private String customerName, Currency, UserID;
	private double Balance;
	private Long accountnumber;

	@PostMapping(value = "/dashboard", produces = "application/HTML")
	public String displayDashboard(@ModelAttribute LoginHTML HTMLobj , BindingResult result, ModelMap model) 
	{
		UserID = HTMLobj.getUserId();		
		System.out.println("UserUserID from HTML input:" + UserID);

		String password = HTMLobj.getPassword();
		System.out.println("Password from HTML input:" + password);
		System.out.println("checking userUserID and password");

		try
		{ 
			String userID = logService.getID(UserID);
			System.out.println("userUserID from loginService:" + userID);

			if ((userID != null))
			{
				System.out.println("userUserID matched");

				String passwrd = logService.getPassword(UserID);
				System.out.println("passwrd from loginService:" + passwrd);

				if (passwrd.equals(password))
				{
					System.out.println("password matched");

					customerName=dashService.findUserName(userID);
					System.out.println("customerName from dashboard service: "+customerName);				
					accountnumber=dashService.findAccountNumber(userID);

					System.out.println("accountnumber from dashboard service: "+accountnumber);

					System.out.println("fetching account balance");

					Balance = enqService.findBalance(accountnumber);
					System.out.println("Balance from enquiry service: "+Balance);
					Currency = enqService.findCurrency(accountnumber);
					System.out.println("Currency from enquiry service: "+Currency);

					String accType = dashService.findAccType(accountnumber);
					System.out.println("accType from enquiry service: "+accType);


					model.addAttribute("name",customerName);
					model.addAttribute("type",accType);
					model.addAttribute("AccNumber","Account Number: " + accountnumber);
					model.addAttribute("Balance","Available balance: " + Balance);
					model.addAttribute("Currency",Currency);
					
					return "Dashboard";

				}
				else
				{	
					model.addAttribute("name","to Bank");
					model.addAttribute("msg","Incorrect Password");
					model.addAttribute("back1","Login");

					return "Acknowledgement";
				}
			}
			else
			{				
				model.addAttribute("name","to Bank");
				model.addAttribute("msg","Incorrect UserID");
				model.addAttribute("back1","Login");

				return "Acknowledgement";
			}
		}
		catch (Exception e)
		{ 
			e.printStackTrace();
		}
		return null;		
	}

	@GetMapping(value = "/dashboard/AccSummary")
	public String getAccSummary(ModelMap model)
	{
		customerName=dashService.findUserName(UserID);
		System.out.println("customerName from dashboard service: "+customerName);

		System.out.println("fetching account balance");

		Balance = enqService.findBalance(accountnumber);
		System.out.println("Balance from enquiry service: "+Balance);
		Currency = enqService.findCurrency(accountnumber);
		System.out.println("Currency from enquiry service: "+Currency);

		String accType = dashService.findAccType(accountnumber);
		System.out.println("accType from enquiry service: "+accType);


		model.addAttribute("name",customerName);
		model.addAttribute("type",accType);
		model.addAttribute("AccNumber","Account Number: " + accountnumber);
		model.addAttribute("Balance","Available balance: " + Balance);
		model.addAttribute("Currency",Currency);

		return "Dashboard";
	}



	//getters and setters for variables

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}

	public Long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(Long accountnumber) {
		this.accountnumber = accountnumber;
	}

}