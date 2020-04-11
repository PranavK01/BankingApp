package com.wipro.PR377825.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="customer")
public class Customer 
{
	//defining fields
	@Id
	@Column(name = "userId")
	private String userId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="first_name")
	private String firstName;
    
	@Column(name="last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
    
    @Column(name = "contact_num")
    private String phone;

    @Column(name = "current_accountNum")
    private Long currentAccNum;

    @Column(name = "saving_accountNum")
    private Long savingAccNum;

 // ****  setting up one to one mapping to saving and current entity  ****
//    @OneToOne
//    private SavingAccount saving_accountNum;
//    
//    @OneToOne
//    private CurrentAccount current_accountNum;

  

	
	// defining constructors 
    
    public Customer()  {  }
    
	public Customer(String userId, String password, String firstName, String lastName, String email, String phone,
			Long currentAccNum, Long savingAccNum) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.currentAccNum = currentAccNum;
		this.savingAccNum = savingAccNum;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phone=" + phone + ", currentAccNum=" + currentAccNum
				+ ", savingAccNum=" + savingAccNum + "]";
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

	public Long getCurrentAccNum() {
		return currentAccNum;
	}

	public void setCurrentAccNum(Long currentAccNum) {
		this.currentAccNum = currentAccNum;
	}

	public Long getSavingAccNum() {
		return savingAccNum;
	}

	public void setSavingAccNum(Long savingAccNum) {
		this.savingAccNum = savingAccNum;
	}	
	
}
