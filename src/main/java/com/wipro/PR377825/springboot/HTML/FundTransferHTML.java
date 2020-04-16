package com.wipro.PR377825.springboot.HTML;

import org.springframework.stereotype.Component;

@Component
public class FundTransferHTML 
{
	public long fromAcc;
	public long toAcc;
	public double amount;
	public String Remark;
	
	public FundTransferHTML() { }

	public FundTransferHTML(long fromAcc, long toAcc, double amount, String remark) {
		super();
		this.fromAcc = fromAcc;
		this.toAcc = toAcc;
		this.amount = amount;
		Remark = remark;
	}

	public long getFromAcc() {
		return fromAcc;
	}

	public void setFromAcc(long fromAcc) {
		this.fromAcc = fromAcc;
	}

	public long getToAcc() {
		return toAcc;
	}

	public void setToAcc(long toAcc) {
		this.toAcc = toAcc;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}
	
}
