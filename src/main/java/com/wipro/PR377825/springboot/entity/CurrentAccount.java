package com.wipro.PR377825.springboot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "current_account")
@SequenceGenerator(name="seq", initialValue=20050, allocationSize = 33)
public class CurrentAccount 
{
	//defining fields
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
		@Column(name="account_number")
		private Long accNumber;

			
		@Column(name="account_type")
		private String accountType;
		
		@Column(name="balance")
		private double balance;

		@Column(name="currency") 
		private String currency;
		
		@Column(name="status") 
		private String status;
		
		@Column(name = "user_id")
		private String UserId;
		
//		// ****  setting up one to many mapping to saving and current entity  ****
//	    @OneToMany(mappedBy = "savingAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	    private List<CurrentAccTransaction> currentTransactionList;


	 // defining constructors 
		public CurrentAccount() {   }
	    
		public CurrentAccount(String accountType, double balance, String currency, String status,
				String userId) {   //, List<CurrentAccTransaction> currentTransactionList) {
			super();
			this.accountType = accountType;
			this.balance = balance;
			this.currency = currency;
			this.status = status;
			UserId = userId;
			//this.currentTransactionList = currentTransactionList;
		}

		// defining toString function just to display fields
		
		@Override
		public String toString() {
			return "SavingAccount [accNumber=" + accNumber + ", accountType=" + accountType + ", balance=" + balance
					+ ", currency=" + currency + ", status=" + status + ", UserId=" + UserId + "]";
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

		public String getUserId() {
			return UserId;
		}

		public void setUserId(String userId) {
			UserId = userId;
		}

//		public List<CurrentAccTransaction> getCurrentTransactionList() {
//			return currentTransactionList;
//		}
//
//		public void setCurrentTransactionList(List<CurrentAccTransaction> currentTransactionList) {
//			this.currentTransactionList = currentTransactionList;
//		}
	   
	}
