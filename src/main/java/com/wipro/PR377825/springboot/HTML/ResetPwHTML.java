package com.wipro.PR377825.springboot.HTML;

import org.springframework.stereotype.Component;

@Component
public class ResetPwHTML 
{
	public String userId;
	public String password;
	public String confirmPW;
	
	public ResetPwHTML() { }
	
	public ResetPwHTML(String userId, String password, String confirmPW) {
		super();
		this.userId = userId;
		this.password = password;
		this.confirmPW = confirmPW;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPW() {
		return confirmPW;
	}
	public void setConfirmPW(String confirmPW) {
		this.confirmPW = confirmPW;
	}
	
	
}
