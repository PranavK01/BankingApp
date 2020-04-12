package com.wipro.PR377825.springboot.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
public class DashBoardRestController {
//
//	@Autowired
//	LoginService logService;
	@Autowired
	DashboardService dashService;
	@Autowired
	EnquiryService enqService;
//
//	private String customerName, savingCurrency, currentCurrency, UserID;
//	private double savingBalance, currentBalance;
//	private Long savingAccNumber,currentAccNumber,accountnumber[];
//
//	@PostMapping("/restLogin")
//	public Map<String,String> displayDashboard(String user, String pass) 
//	{
//		UserID = user;
//		System.out.println("UserUserID from HTML input:" + UserID);
//
//		String password = pass;
//		System.out.println("Password from HTML input:" + password);
//		System.out.println("checking userUserID and password");
//
//		HashMap<String, String> map = new HashMap<>();
//
//		try
//		{ 
//			String userID = logService.getID(UserID);
//			System.out.println("userUserID from loginService:" + userID);
//
//			if ((userID != null) && (userID.equals(UserID)))
//			{
//				System.out.println("userUserID matched");
//
//				String passwrd = logService.getPassword(UserID);
//				System.out.println("passwrd from loginService:" + passwrd);
//
//				if (passwrd.equals(password))
//				{
//					System.out.println("password matched");
//
//					customerName=dashService.findUserName(userID);
//					System.out.println("customerName from dashboard service: "+customerName);				
//					accountnumber=dashService.findAccountNumber(userID);
//					savingAccNumber = accountnumber[0];
//					currentAccNumber = accountnumber[1];
//					System.out.println("accountnumber from dashboard service: "+savingAccNumber);
//					System.out.println("accountnumber from dashboard service: "+currentAccNumber);
//
//					if (currentAccNumber!=null)
//					{
//						System.out.println("fetching saving account balance");
//
//						savingBalance = enqService.findBalance(savingAccNumber);
//						System.out.println("savingBalance from enquiry service: "+savingBalance);
//						savingCurrency = enqService.findCurrency(savingAccNumber);
//						System.out.println("Currency from enquiry service: "+savingCurrency);
//
//						System.out.println("fetching current account balance");
//
//						currentBalance = enqService.findBalance(currentAccNumber);
//						System.out.println("currentBalance from enquiry service: "+currentBalance);
//						currentCurrency = enqService.findCurrency(currentAccNumber);
//						System.out.println("currentCurrency from enquiry service: "+currentCurrency);
//
//						map.put("name",customerName);
//						map.put("savingAccNumber", ""+savingAccNumber);
//						map.put("currentAccNumber", ""+currentAccNumber);
//						map.put("savingBalance", ""+ savingBalance);
//						map.put("currentBalance", ""+currentBalance);
//						map.put("saveCurrency", savingCurrency);
//						map.put("currentCurrency", currentCurrency);
//
//						return map;
//					}
//					else
//					{
//						System.out.println("fetching saving account balance");
//
//						savingBalance = enqService.findBalance(savingAccNumber);
//						System.out.println("savingBalance from enquiry service: "+savingBalance);
//						savingCurrency = enqService.findCurrency(savingAccNumber);
//						System.out.println("Currency from enquiry service: "+savingCurrency);
//
//						map.put("name",customerName);
//						map.put("savingAccNumber","" + savingAccNumber);
//						map.put("savingBalance","" + savingBalance);
//						map.put("saveCurrency",savingCurrency);
//
//					}
//					return map;
//				}
//				else
//				{	
//					map.put("name","to Bank");
//					map.put("msg","Incorrect Password");
//					map.put("back1","Login");
//
//					return map;
//				}
//			}
//			else
//			{				
//				map.put("name","to Bank");
//				map.put("msg","Incorrect UserID");
//				map.put("back1","Login");
//
//				return map;
//			}
//		}
//		catch (Exception e)
//		{ 
//			e.printStackTrace();
//		}
//		return null;		
//	}
//
	
	
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
	
	
}