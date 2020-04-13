package com.wipro.PR377825.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "saving_transaction")
public class SavingAccTransaction 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name="description")
	private String description;

	@Column(name="amount", nullable = false)
	private double Amount;

	@Column(name="last_statement", nullable = false)
	private double previousBal;

	@Column(name="available_balance", nullable = false)
	private double availableBalance;

	@Column(name="date", nullable = false)
	private Date dateTime;

	@Column(name = "status", nullable = false)
	private String status;


	@ManyToOne
	@JoinColumn(name = "account_number", nullable = false)
	private SavingAccount savingAccNumber;


	public SavingAccTransaction() {   }


	public SavingAccTransaction(String description, double amount, double previousBal, double availableBalance,
			Date dateTime, String status) {
		super();
		this.description = description;
		Amount = amount;
		this.previousBal = previousBal;
		this.availableBalance = availableBalance;
		this.dateTime = dateTime;
		this.status = status;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public double getPreviousBal() {
		return previousBal;
	}

	public void setPreviousBal(double previousBal) {
		this.previousBal = previousBal;
	}


	public SavingAccount getSavingAccNumber() {
		return savingAccNumber;
	}


	public void setSavingAccNumber(SavingAccount savingAccNumber) {
		this.savingAccNumber = savingAccNumber;
	}


}
