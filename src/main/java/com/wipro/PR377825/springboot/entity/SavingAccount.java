package com.wipro.PR377825.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "saving_account")
@SequenceGenerator(name="saveSeq", initialValue=20051, allocationSize = 33)
public class SavingAccount
{ 
	//defining fields
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="saveSeq")
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
		
		@OneToOne
		@JoinColumn(name = "user_id")
		private Customer FKuserID;
		



		//		// ****  setting up one to many mapping to saving and current entity  ****
		//	    @OneToMany(mappedBy = "savingAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		//	    private List<CurrentAccTransaction> currentTransactionList;


		// defining constructors 
		public SavingAccount() {		}

		public SavingAccount(String accountType, double balance, String currency, String status, Customer fKuserID) {
			super();
			this.accountType = accountType;
			this.balance = balance;
			this.currency = currency;
			this.status = status;
			FKuserID = fKuserID;
		}

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
		
		public Customer getFKuserID() {
			return FKuserID;
		}
		
		public void setFKuserID(Customer fKuserID) {
			FKuserID = fKuserID;
		}
	
	}
