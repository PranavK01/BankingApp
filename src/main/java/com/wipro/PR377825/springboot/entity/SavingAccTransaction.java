package com.wipro.PR377825.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name="amount")
	private double Amount;
	
	@Column(name="last_statement")
	private double previousBal;

	@Column(name="available_balance")
	private double availableBalance;

	@Column(name="date")
	private Date dateTime;

	@Column(name = "status")
	private String status;

	@Column(name = "transfer_type")
	private String type;

	@Column(name = "account_number")
	private long accNumber;

	//	@ManyToOne
	//	@JoinColumn(name = "account_number")
	//	private SavingAccount savingAccNumber;


	public SavingAccTransaction() {   }

	public SavingAccTransaction(String description, double amount, double availableBalance, double previousBal, Date dateTime,
			String status, String type, long accNumber) {
		super();
		this.description = description;
		Amount = amount;
		this.availableBalance = availableBalance;
		this.dateTime = dateTime;
		this.status = status;
		this.type = type;
		this.accNumber = accNumber;
		this.previousBal = previousBal;
	}

	@Override
	public String toString() {
		return "CurrentAccTransaction [id=" + id + ", description=" + description + ", Amount=" + Amount
				+ ", previousBal=" + previousBal + ", availableBalance=" + availableBalance + ", dateTime=" + dateTime
				+ ", status=" + status + ", type=" + type + ", accNumber=" + accNumber + "]";
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
	
	public double getPreviousBal() {
		return previousBal;
	}

	public void setPreviousBal(double previousBal) {
		this.previousBal = previousBal;
	}
}
