package com.bank.ObjectModel;

public class Transfer {

	
	Long b_accNo;
	Double amount;
	String desc;
	
	
	public long getB_accNo() {
		return b_accNo;
	}
	public void setB_accNo(long b_accNo) {
		this.b_accNo = b_accNo;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "transfer [b_accNo=" + b_accNo + ", amount=" + amount + ", desc=" + desc + "]";
	}
	
	
}
