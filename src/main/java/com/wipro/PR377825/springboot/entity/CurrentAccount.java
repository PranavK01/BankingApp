package com.wipro.PR377825.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "current_account")
@SequenceGenerator(name="currentSeq", initialValue=40058, allocationSize = 33)
public class CurrentAccount 
{
	//defining fields
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="currentSeq")
	@Column(name="account_number")
	private Long accNumber;

	@Column(name="account_type", nullable = false)
	private String accountType;

	@Column(name="balance", nullable = false)
	private double balance;

	@Column(name="currency", nullable = false) 
	private String currency;

	@Column(name="status", nullable = false) 
	private String status;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Customer FKuserID;
	

	// defining constructors 
	public CurrentAccount() {   }

	

	public CurrentAccount(String accountType, double balance, String currency, String status, Customer FKuserID) {
		super();
		this.accountType = accountType;
		this.balance = balance;
		this.currency = currency;
		this.status = status;
		this.FKuserID = FKuserID;
	}

	// defining getters and setters
	
	public Long getAccNumber() {
		return accNumber;
	}
	
	public void setAccNumber(Long accNumber) {
		this.accNumber = accNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Customer getFKuserID1() {
		return FKuserID;
	}
	
	public void setFKuserID(Customer fKuserID) {
		FKuserID = fKuserID;
	}

}