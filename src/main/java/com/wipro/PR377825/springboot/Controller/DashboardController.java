package com.wipro.PR377825.springboot.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

	private String customerName, savingCurrency, currentCurrency, UserID;
	private double savingBalance, currentBalance;
	private Long savingAccNumber,currentAccNumber,accountnumber[];

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
					savingAccNumber = accountnumber[0];
					currentAccNumber = accountnumber[1];
					System.out.println("accountnumber from dashboard service: "+savingAccNumber);
					System.out.println("accountnumber from dashboard service: "+currentAccNumber);

					if (currentAccNumber!=null)
					{
						System.out.println("fetching saving account balance");

						savingBalance = enqService.findBalance(savingAccNumber);
						System.out.println("savingBalance from enquiry service: "+savingBalance);
						savingCurrency = enqService.findCurrency(savingAccNumber);
						System.out.println("Currency from enquiry service: "+savingCurrency);

						System.out.println("fetching current account balance");

						currentBalance = enqService.findBalance(currentAccNumber);
						System.out.println("currentBalance from enquiry service: "+currentBalance);
						currentCurrency = enqService.findCurrency(currentAccNumber);
						System.out.println("currentCurrency from enquiry service: "+currentCurrency);

						model.addAttribute("name",customerName);
						model.addAttribute("savingAccNumber","Account Number: " + savingAccNumber);
						model.addAttribute("currentAccNumber","Account Number: " + currentAccNumber);
						model.addAttribute("savingBalance","Available balance: " + savingBalance);
						model.addAttribute("currentBalance","Available balance: " + currentBalance);
						model.addAttribute("saveCurrency",savingCurrency);
						model.addAttribute("currentCurrency",currentCurrency);
					}
					else
					{
						System.out.println("fetching saving account balance");

						savingBalance = enqService.findBalance(savingAccNumber);
						System.out.println("savingBalance from enquiry service: "+savingBalance);
						savingCurrency = enqService.findCurrency(savingAccNumber);
						System.out.println("Currency from enquiry service: "+savingCurrency);
						
						model.addAttribute("name",customerName);
						model.addAttribute("savingAccNumber","Account Number: " + savingAccNumber);
						model.addAttribute("savingBalance","Available balance: " + savingBalance);
						model.addAttribute("saveCurrency",savingCurrency);

					}
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


	//getters and setters for variables

	public String getSavingCurrency() {
		return savingCurrency;
	}

	public void setSavingCurrency(String savingCurrency) {
		this.savingCurrency = savingCurrency;
	}

	public String getCurrentCurrency() {
		return currentCurrency;
	}

	public void setCurrentCurrency(String currentCurrency) {
		this.currentCurrency = currentCurrency;
	}

	public double getSavingBalance() {
		return savingBalance;
	}


	public void setSavingBalance(double savingBalance) {
		this.savingBalance = savingBalance;
	}


	public double getCurrentBalance() {
		return currentBalance;
	}


	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public Long getSavingAccNumber() {
		return savingAccNumber;
	}


	public void setSavingAccNumber(Long savingAccNumber) {
		this.savingAccNumber = savingAccNumber;
	}


	public Long getCurrentAccNumber() {
		return currentAccNumber;
	}


	public void setCurrentAccNumber(Long currentAccNumber) {
		this.currentAccNumber = currentAccNumber;
	}


	public String getUserID() {
		return UserID;
	}


	public void setUserID(String userID) {
		UserID = userID;
	}

	



	//	public List<Customer> getAccountnumber() {
	//		return accountnumber;
	//	}
	//
	//
	//	public void setAccountnumber(List<Customer> accountnumber) {
	//		this.accountnumber = accountnumber;
	//	}



}
