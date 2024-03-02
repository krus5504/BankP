package com.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	public Customer findByMobileNo(Long mobileNo);
	public Customer findByAdharId(Long Adhar);
	public Customer findByAccountNo(Long accountNo);
	public List<Customer> findByfName(String fname);
	public List<Customer> findBylName(String lname);
	public List<Customer> findByAddress(String address);
	
}
