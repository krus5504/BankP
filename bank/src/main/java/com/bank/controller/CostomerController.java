package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bank.ObjectModel.Transfer;
import com.bank.model.Customer;
import com.bank.model.EmployeeLogin;
import com.bank.model.Statements;
import com.bank.repo.CustomerRepo;
import com.bank.service.CustomerService;
import com.bank.service.LoginService;

@RestController
@RequestMapping("/v1/bank/dashbord")
public class CostomerController {
	
	@Autowired 
   	LoginService loginSer;
	
	@Autowired
    CustomerService customerServ;
		
    
	@GetMapping("/f_trans")
	public ModelAndView fundTranfer() {
	
		
		return new ModelAndView("/dashbord/f_trans");
	}
	@PostMapping("/tranfer")
	public ModelAndView fundTranferOk(@ModelAttribute Transfer tns) {
		
		return customerServ.fundTransfer(tns);
		
	}
	
	@GetMapping("/balence")
	public ModelAndView check_Balence() {
		 
		 Double balence = customerServ.findByAccountNo(MainController.emp1.getAccNo()).getBallence();
		 ModelAndView mv = new ModelAndView("/dashbord/balence");
		 mv.addObject("balence", balence);
		 
		return mv;
	}
	@GetMapping("/statement")
	public ModelAndView viewsStatement() {
		ModelAndView mv = new ModelAndView("/dashbord/statement");
		List<Statements> list = customerServ.getAllStatementlist(MainController.emp1.getAccNo());
		mv.addObject("statment", list);
		
		return mv;
	}
	
	
	
	
}
