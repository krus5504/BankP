package com.bank.Employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.bank.model.Customer;
import com.bank.service.CustomerService;

@SpringBootTest
public class CustomerTestByName {

	@Autowired
	CustomerService custServ;
	
	 RestTemplate rt= new RestTemplate();
	
	private final int portNo=8080;
	 String name="daksh";
	 
	 int count=3;
	
	 
	
	String api="http://localhost:"+portNo+"/v1/bank/emp/getAll/custN/"+name;
	
	/* this method is used to Getcustomer count
	 * By Account And And Check 
	 * Customer ccount is Correct Or Not
	
	 * */
	@Test
	void checkCount() {
		 
		 ResponseEntity<Customer[]> forEntity = rt.getForEntity(api,Customer[].class);
		
		 Customer[] body = forEntity.getBody();
		 
		 long collect = Arrays.stream(body).count();
		
		 
		 assertEquals(count, collect);
		 
	}
	
	
	
	
}
