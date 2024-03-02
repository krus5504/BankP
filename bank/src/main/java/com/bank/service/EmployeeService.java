package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bank.ObjectModel.Transfer;
import com.bank.controller.MainController;
import com.bank.model.Customer;
import com.bank.model.Employee;
import com.bank.model.EmployeeLogin;
import com.bank.model.Statements;
import com.bank.repo.CustomerRepo;
import com.bank.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo erepo;
	
	@Autowired
	CustomerRepo cusRepo;
	
	@Autowired
	StatementsServ stmtService;
	
	
	static String gen_Date = null;
	static String gen_tnxId = null;
	
	
	public Employee saveEmployee(Employee emp) {
		return erepo.save(emp);
	}
	public Employee getEmployeeById(Integer id) {
		return erepo.findById(id).get();
	}
	public List<Employee> getAllEmployee() {
		return erepo.findAll();
	}
	
	public Employee getByUserId(String userId) {
		
		return erepo.findByUserId(userId);
	}
	
	
	
	public ModelAndView fundTransfer(Transfer tns) {

		try {
			
			Employee emp1 = MainController.e1;
			

			Customer b_customer = cusRepo.findByAccountNo(tns.getB_accNo());
			System.out.println(b_customer);
			
			if (b_customer != null && b_customer.getAccountNo() != emp1.getAcc_no()) {

				System.out.println("inside if");

//				Customer self = cusRepo.findByAccountNo(emp1.getAcc_no());
				
				Integer ballence = emp1.getBallence();
				
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				
				Double self_bal = new Double(ballence);

				if (tns.getAmount() < self_bal) {

					Double bal = b_customer.getBallence();
					self_bal = self_bal - tns.getAmount();

					bal = bal + tns.getAmount();
					
					b_customer.setBallence(bal);
					System.out.println(">........................................................");
					cusRepo.save(b_customer);
               
				  
				  int intValue = self_bal.intValue();
					emp1.setBallence(intValue);
					
					erepo.save(emp1);

					with_st(tns, emp1);

					diposit_st(tns, emp1);

					System.out.println(tns);
					return new ModelAndView("/dashbord/admin/trans_Done");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/v1/bank/dashbord/f_trans");
	}
	
	
	public void with_st(Transfer tns, Employee self) {
		
		Statements st = new Statements();
		
		gen_Date = CustomerService.gen_Date();
		gen_tnxId = CustomerService.gen_tnxId();

		st.setDate(gen_Date);
		st.setTransId(gen_tnxId);
		st.setDescr(tns.getDesc());
		st.setRef(tns.getB_accNo());
		st.setWithd(tns.getAmount());
		st.setSelfNo((long)self.getAcc_no());

		stmtService.save(st);

	}

	public void diposit_st(Transfer tns, Employee self) {
		Statements st = new Statements();
		st.setDate(gen_Date);
		st.setTransId(gen_tnxId);
		st.setDescr(tns.getDesc());
		st.setRef((long)self.getAcc_no());
		st.setDepos(tns.getAmount());
		st.setSelfNo(tns.getB_accNo());

		stmtService.save(st);

	}
	
	
	
	
	
}
