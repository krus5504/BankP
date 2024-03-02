package com.bank.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Statements;
import com.bank.repo.StatmentRepo;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class StatementsServ {

	@Autowired
	StatmentRepo stmRep;
	public Statements save(Statements stmt) {
		return stmRep.save(stmt);
	}
	
	public List<Statements> findBySelfNo(Long acc_no) {
		return stmRep.findBySelfNo(acc_no);
	}
	
	public List<Statements> getAllStatement () {
		return stmRep.findAll();
	}
	
	
	
	
	@SuppressWarnings("removal")
	public List<Statements> getStmtByToday(String s) {

		Integer f = new Integer(s.replace('-', ' ').replaceAll("\\s", ""));

		List<Statements> list = getAllStatement();

		System.out.println(list);

		List<Statements> filter = list.stream().filter(e->  
        new Integer(e.getDate().substring(0, 10).replace('-', ' ').replaceAll("\\s", "")).equals(f) 

				).collect(Collectors.toList());

		return filter;

	}

		/*****
	 *   		This method is used to genrate the Transaction
		 *   	byl using the Start date and end Date 
		 *      in The Start date is < end Date
		 *      
		 *      
		 *       for ie...  if you want Display the Transaction 
		 * 		of Today five(5 days) days  for example.... you want
		 * 		 transaction of.... 1 jan 2023 to 5 jan 2023 
		 * 
		 * 			then you Enter the Format of 
		 *          01-01-2023 to 05-01-2023 
		 *          
		 * 
		 * 
		 * ******/
	
	
	@SuppressWarnings("removal")
	public List<Statements> getStatByDate( HttpServletRequest req) {
		

		String from = req.getParameter("from");
		String to = req.getParameter("to");
		
		
		Integer f=new Integer(from.replace('-', ' ').replaceAll("\\s", ""));
		Integer t=new Integer(to.replace('-', ' ').replaceAll("\\s", ""));
		
		
		List<Statements> list = getAllStatement();
		
	
		List<Statements> filter = list.stream().filter(e->  
		        new Integer(e.getDate().substring(0, 10).replace('-', ' ').replaceAll("\\s", "")) >= f 
		        && new Integer(e.getDate().substring(0, 10).replace('-', ' ').replaceAll("\\s", "")) <= t
		        )
				.collect(Collectors.toList());
				
		
		return filter;
	}
	
	
}
