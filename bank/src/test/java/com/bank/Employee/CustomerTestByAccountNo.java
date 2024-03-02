package com.bank.Employee;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.bank.model.Customer;
import com.bank.service.CustomerService;

@SpringBootTest
public class CustomerTestByAccountNo {
	@Autowired
	CustomerService custServ;
	
	 RestTemplate rt= new RestTemplate();
	
	private final int portNo=8080;
	Long accountNo= 21884651521l;
	   
	 String firstName="krushna";
	 String lastName="Daksh";
	 Long mobileNo=9765475504l;
	 String address="parbhani";
	 double balence=28900.0;
	 Long adhar=200963421563l;
	
	String api="http://localhost:"+portNo+"/v1/bank/emp/getAll/custA/"+accountNo;
	
	
	
	
	
	
	/* this method is used to Getcustomer
	 * By Account And And Check 
	 * Customer MobileNo is Correct Or Not
	
	 * */
	@Test
	void checkAccountNo() {
		 
		 
		 Customer customer = rt.getForObject(api,Customer.class);
		   
		  long actual = customer.getMobileNo();		  
		 
		  assertEquals(mobileNo, actual);
	}
	
	/* this method is used to Getcustomer
	 * By Account And And Check 
	 * Customer FirstName is Correct Or Not
	
	 * */
	@Test
	void checkLastName() {
		 
		 
		  Customer customer = rt.getForObject(api,Customer.class);
		   
		  String actual = customer.getlName();		  
		 
		  assertEquals(lastName, actual);
	}
	
	/* this method is used to Getcustomer
	  * By Account And And Check 
	 * Customer LastName is Correct Or Not
	
	 * */
	@Test
	void checkFristName() {
		 
		 
		  Customer customer = rt.getForObject(api,Customer.class);
		   
		  String actual = customer.getfName();		  
		 
		  assertEquals(firstName, actual);
	}
	
	/* this method is used to Getcustomer
	 * By mobileNo And And Check 
	 * Customer address is Correct Or Not
	
	 * */
	@Test
	void checkAddress() {
		 
		 
		  Customer customer = rt.getForObject(api,Customer.class);
		   
		  String actual = customer.getAddress();		  
		 
		  assertEquals(address, actual);
	}
	
	/* this method is used to Getcustomer
	 * By Account And And Check 
	 * Customer Ballect is Correct Or Not
	
	 * */
	@Test
	void checkBallece() {
		 
		 
		  Customer customer = rt.getForObject(api,Customer.class);
		   
		  Double actual = customer.getBallence();		  
		 
		  assertEquals(balence, actual);
	}
	
	
	/* this method is used to Getcustomer
	  * By Account And And Check 
	 * Customer adharId is Correct Or Not
	
	 * */
	@Test
	void checkAdharId() {
		 
		 
		  Customer customer = rt.getForObject(api,Customer.class);
		   
		  Long actual = customer.getAdharId();		  
		 
		  assertEquals(adhar, actual);
	}
	
	
	
	
	      
}
