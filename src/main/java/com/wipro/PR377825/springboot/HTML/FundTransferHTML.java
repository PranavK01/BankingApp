package com.wipro.PR377825.springboot.HTML;

import org.springframework.stereotype.Component;

@Component
public class FundTransferHTML 
{
	public int fromAcc;
	public int toAcc;
	public int amount;
	public String Remark;
	
	public FundTransferHTML() { }

	public FundTransferHTML(int fromAcc, int toAcc, int amount, String remark) {
		super();
		this.fromAcc = fromAcc;
		this.toAcc = toAcc;
		this.amount = amount;
		Remark = remark;
	}

	public int getFromAcc() {
		return fromAcc;
	}

	public void setFromAcc(int fromAcc) {
		this.fromAcc = fromAcc;
	}

	public int getToAcc() {
		return toAcc;
	}

	public void setToAcc(int toAcc) {
		this.toAcc = toAcc;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}
			
}
