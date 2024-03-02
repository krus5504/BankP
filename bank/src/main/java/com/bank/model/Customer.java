package com.bank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	
	   int srNo;
	  String fName;
	  String lName;
	  @Column(unique = true)
	  Long mobileNo;
	  
	  @Column(unique = true)
	  Long adharId;
	  String address;
	 
	  @Column(nullable = true)
	  Long accountNo;
	 @Column(nullable = true)
	  Double ballence;
	  
	  
	  
	  
	  
	public Double getBallence() {
		return ballence;
	}
	public void setBallence(Double ballence) {
		this.ballence = ballence;
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Long getAdharId() {
		return adharId;
	}
	public void setAdharId(Long adharId) {
		this.adharId = adharId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	
	@Override
	public String toString() {
		return "\nCustomer [srNo=" + srNo + ", fName=" + fName + ", lName=" + lName + ", mobileNo=" + mobileNo
				+ ", adharId=" + adharId + ", address=" + address + ", accountNo=" + accountNo + "]";
	}
	  
	  
	
	
	  
}
