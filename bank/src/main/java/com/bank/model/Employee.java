package com.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String userId;
	private Integer acc_no;
	private Integer ballence;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(Integer acc_no) {
		this.acc_no = acc_no;
	}
	public Integer getBallence() {
		return ballence;
	}
	public void setBallence(Integer ballence) {
		this.ballence = ballence;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", userId=" + userId + ", acc_no=" + acc_no + ", ballence=" + ballence + "]";
	}
	
	
	
	
	
	
}
