package com.wipro.PR377825.springboot.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.PR377825.springboot.HTML.NewCustomerHTML;
import com.wipro.PR377825.springboot.services.EnquiryService;
import com.wipro.PR377825.springboot.services.ProfileService;


@Controller
public class AccountInfoController 
{
	@Autowired
	DashboardController dashCtrl;
	@Autowired
	EnquiryService enqService;
	@Autowired
	ProfileService proService;
	
	
	String field="";
	
	@RequestMapping(value = "/dashboard/SavingAccountInfo")
	public String SavingAccountInfo(ModelMap model)
	{
		long accountNum = dashCtrl.getSavingAccNumber();
		System.out.println("accountNum from dashboard controller:"+accountNum);
		String customerName = dashCtrl.getCustomerName();
		System.out.println("Username from dashboard controller:"+customerName);
		double Balance = dashCtrl.getSavingBalance();
		System.out.println("Balance from dashboard controller:"+Balance);
		String Currency = dashCtrl.getSavingCurrency();
		System.out.println("Currency from dashboard controller:"+Currency);
		String Status = enqService.findStatus(accountNum);
		System.out.println("Status from enquiry service: "+Status);
				
		model.addAttribute("name",customerName);
		model.addAttribute("AccNumber",accountNum);
		model.addAttribute("Balance",Balance);
		model.addAttribute("Currency",Currency);
		model.addAttribute("Status",Status);
		
		return "Enquiry";
	}
	
	
	@RequestMapping(value = "/dashboard/CurrentAccountInfo")
	public String CurrentAccountInfo(ModelMap model)
	{
		long accountNum = dashCtrl.getCurrentAccNumber();
		System.out.println("accountNum from dashboard controller:"+accountNum);
		String customerName = dashCtrl.getCustomerName();
		System.out.println("Username from dashboard controller:"+customerName);
		double Balance = dashCtrl.getCurrentBalance();
		System.out.println("Balance from dashboard controller:"+Balance);
		String Currency = dashCtrl.getCurrentCurrency();
		System.out.println("Currency from dashboard controller:"+Currency);
		String Status = enqService.findStatus(accountNum);
		System.out.println("Status from enquiry service: "+Status);
				
		model.addAttribute("name",customerName);
		model.addAttribute("AccNumber",accountNum);
		model.addAttribute("Balance",Balance);
		model.addAttribute("Currency",Currency);
		model.addAttribute("Status",Status);
		
		return "Enquiry";
	}
	
	@RequestMapping(value = "/dashboard/Profile")
	public String ProfileInfo(ModelMap model)
	{
		String userID = dashCtrl.getUserID();
		System.out.println("userID from dashboard: "+userID);
		
		String details[] = proService.getProfileDetails(userID);
		
		String fname = details[0];
		String lname = details[1];
		String phone = details[2];
		String email = details[3];
		
		model.addAttribute("name",fname + " " + lname);
		model.addAttribute("firstName",fname);
		model.addAttribute("lastName",lname);
		model.addAttribute("email",email);
		model.addAttribute("phone",phone);
				
		return "Profile";
	}
	
	
	@RequestMapping(value = "/dashboard/Profile/update/firstName")
	public String ProfileUpdate1(ModelMap model)
	{	
		field = "FirstName";
		
		model.addAttribute("name",dashCtrl.getCustomerName());
		model.addAttribute("field",field);
				
		return "Profileupdate";
	}
	
	@RequestMapping(value = "/dashboard/Profile/update/lastName")
	public String ProfileUpdate2(ModelMap model)
	{
		field = "LastName";
		
		model.addAttribute("name",dashCtrl.getCustomerName());
		model.addAttribute("field",field);
				
		return "Profileupdate";
	}
	
	@RequestMapping(value = "/dashboard/Profile/update/email")
	public String ProfileUpdate3(ModelMap model)
	{		
		field = "Email";
		
		model.addAttribute("name",dashCtrl.getCustomerName());
		model.addAttribute("field",field);
				
		return "Profileupdate";
	}
	
	@RequestMapping(value = "/dashboard/Profile/update/phone")
	public String ProfileUpdate4(ModelMap model)
	{		
		field = "Contact Number";
		
		model.addAttribute("name",dashCtrl.getCustomerName());
		model.addAttribute("field",field);
				
		return "Profileupdate";
	}
	
	
	@RequestMapping(value = "/dashboard/Profile/update/ack")
	public String ProfileUpdateSave(@ModelAttribute NewCustomerHTML HTMLobj , BindingResult result, ModelMap model)
	{
		String response = HTMLobj.getField();				
		System.out.println("Value is: "+response);
		
		String userID = dashCtrl.getUserID();
		System.out.println("field in ack controller: "+field);
		
		String customerName = proService.saveDetail(userID, field, response);			
		
		model.addAttribute("name",customerName);
		model.addAttribute("msg","Profile has been successfully updated");
		model.addAttribute("back","Back");
				
		return "Acknowledgement";
	}
	
}
