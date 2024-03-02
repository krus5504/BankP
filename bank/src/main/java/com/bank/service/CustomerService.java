package com.bank.service;

import java.beans.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bank.ObjectModel.Transfer;
import com.bank.controller.MainController;
import com.bank.model.Customer;
import com.bank.model.EmployeeLogin;
import com.bank.model.Statements;
import com.bank.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo cusRepo;
	
	@Autowired
	StatementsServ stmtService;

	static String gen_Date = null;
	static String gen_tnxId = null;

	public static void main(String[] args) {

	}
     
	 // this method is used to Find the customer
	  // by using mobile NO
	  // if mobile is Register then its return customer
	  // otherWiss is return null value
	
	public Customer findByMobileNo(Long mobileNo) {

		return cusRepo.findByMobileNo(mobileNo);
	}

	public Customer findByAdharNo(Long adharNo) {

		return cusRepo.findByAdharId(adharNo);
	}

	public Customer save(Customer customer) {

		return cusRepo.save(customer);
	}
	
	public Customer findById(Integer id) {

		return cusRepo.findById(id).get();
	}

	public Customer findByAccountNo(Long accountNo) {

		return cusRepo.findByAccountNo(accountNo);
	}

	public static String gen_Date() {

		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		return myDateObj.format(myFormatObj);

	}

	public static String gen_tnxId() {
		Random r = new Random();
		Integer i = r.nextInt();
		String s = new String("tnx " + i);

		return s;

	}

	public ModelAndView fundTransfer(Transfer tns) {

		try {
			EmployeeLogin emp1 = MainController.emp1;

			Customer b_customer = cusRepo.findByAccountNo(tns.getB_accNo());
			System.out.println(b_customer);
			if (b_customer != null && b_customer.getAccountNo() != emp1.getAccNo()) {

				System.out.println("inside if");

				Customer self = cusRepo.findByAccountNo(emp1.getAccNo());
				Double self_bal = self.getBallence();

				if (tns.getAmount() < self_bal) {

					double bal = b_customer.getBallence();
					self_bal = self_bal - tns.getAmount();

					bal = bal + tns.getAmount();
					b_customer.setBallence(bal);
					cusRepo.save(b_customer);

					self.setBallence(self_bal);
					cusRepo.save(self);

					with_st(tns, self);

					diposit_st(tns, self);

					System.out.println(tns);
					return new ModelAndView("/dashbord/trans_Done");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/v1/bank/dashbord/f_trans");
	}

	public void with_st(Transfer tns, Customer self) {
		Statements st = new Statements();
		gen_Date = gen_Date();
		gen_tnxId = gen_tnxId();

		st.setDate(gen_Date);
		st.setTransId(gen_tnxId);
		st.setDescr(tns.getDesc());
		st.setRef(tns.getB_accNo());
		st.setWithd(tns.getAmount());
		st.setSelfNo(self.getAccountNo());

		stmtService.save(st);

	}

	public void diposit_st(Transfer tns, Customer self) {
		Statements st = new Statements();
		st.setDate(gen_Date);
		st.setTransId(gen_tnxId);
		st.setDescr(tns.getDesc());
		st.setRef(self.getAccountNo());
		st.setDepos(tns.getAmount());
		st.setSelfNo(tns.getB_accNo());

		stmtService.save(st);

	}

	
	public final List<Statements> getAllStatementlist(Long acc) {

		return stmtService.findBySelfNo(acc);
	}
	
	/*
	 * This method is Used to Get All Customer List
	 * 
	 * */
	  public List<Customer> getAllCustomer() {
		  
		  return cusRepo.findAll();		  
	  }

	  /*This method is Used To Find The List OF
	   *  Cusotmer by using First Name And LastName
	   *  
	   * 
	   * */
	  
	  
	public List<Customer> findByName(String name) {
	  
		List<Customer> byfName = cusRepo.findByfName(name);
		List<Customer> lName= cusRepo.findBylName(name);
		byfName.addAll(lName);
		
		
		return new ArrayList<Customer>(new HashSet<>(byfName)) ;
	}
	
	/*this method is Used to Find The List <Customer>
	 * by using The address of customer
	 * 
	 * 
	 * */
	  public List<Customer>findByAddress(String address){
		  
		  return cusRepo.findByAddress(address);
	  }
	 
	  
	 /* This method is used to Get a 
	  *  Minimum Costomer if you want Only First 5 Customer Then it 
	  *  
	  *  return only First Five Costomer list
	  * */
	
	  public List<Customer> limitedCustomer(int limit){
		  List<Customer> all = cusRepo.findAll();
		  List<Customer> limit1 = all.stream().limit(limit).collect(Collectors.toList());
		  return limit1;
	  }
	  
	  /* This method is used to Get a 
		  *  Minimum Costomer if you want next 5 Customer Then it 
		  *  
		  *  return next Five Costomer list
		  * */
		
		  public List<Customer> limitedNextPageCustomer(int limit){
			  List<Customer> all = cusRepo.findAll();
			  List<Customer> limit1= all.stream().skip(5).limit(limit).collect(Collectors.toList());

			  return limit1;
		  }
}
