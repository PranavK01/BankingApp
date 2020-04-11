package com.wipro.PR377825.springboot.HTML;

import org.springframework.stereotype.Component;

@Component
public class LoginHTML 
{
	public String userId;
	public String password;
	
	public LoginHTML () {}

	public LoginHTML(String userID, String password) { 
		super();
		this.userId = userID;
		this.password = password;
	}
		
	public String getUserId() {
		return this.userId;
	}
	public void setUserID(String userID) {
		this.userId = userID;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
