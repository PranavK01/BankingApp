package com.wipro.PR377825.springboot.HTML;

import org.springframework.stereotype.Component;

@Component
public class NewCustomerHTML 
{
	public String firstName;
	public String lastName;
	public String email;
	public String phone;
	public String userId;
	public String password;
	public String currentAcc;
	public String field;
	
	public NewCustomerHTML() {   }
	
	public NewCustomerHTML(String firstName, String lastName, String email, String contact_No, String userId,String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		phone = contact_No;
		this.userId = userId;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
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

	public String getCurrentAcc() {
		return currentAcc;
	}

	public void setCurrentAcc(String currentAcc) {
		this.currentAcc = currentAcc;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	
	
}
