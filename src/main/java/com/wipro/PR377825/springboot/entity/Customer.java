package com.wipro.PR377825.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customer")
public class Customer 
{
	//defining fields
	@Id
	@Column(name = "userId", nullable = false)
	private String userId;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="first_name", nullable = false)
	private String firstName;
    
	@Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "contact_num", nullable = false, unique = true)
    private String phone;

  

	
	// defining constructors 
    
    public Customer()  {  }
    
    
	public Customer(String userId, String password, String firstName, String lastName, String email, String phone) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

//	getters and setters
	
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


}
