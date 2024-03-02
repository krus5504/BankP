package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bank.model.Customer;
import com.bank.model.Employee;
import com.bank.model.EmployeeLogin;
import com.bank.service.CustomerService;
import com.bank.service.EmployeeService;
import com.bank.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/v1/bank")

public class MainController {
@Autowired
	EmployeeService es;
@Autowired 
   	LoginService loginSer;
@Autowired
    CustomerService customerServ;
		
       public  static EmployeeLogin emp1;
       public  static Employee e1;

	@GetMapping("/app")
	public ModelAndView main() {
		System.out.println("in side main method Controller");
		
		return new ModelAndView("index");
	}
	@GetMapping("/loginform")
	public ModelAndView login(){
		
		    
		    return new ModelAndView("login/loginForm");
		
	}
	@GetMapping("/singUp")
	public ModelAndView singUp(){
		
		    
		    return new ModelAndView("login/singUpForm");
		
	}
	@PostMapping("/loginDone")
	public ModelAndView loginDone(@ModelAttribute EmployeeLogin empLogin){
		   
		    List<EmployeeLogin> list=loginSer.findByType("customer");
		    
		    for (EmployeeLogin emp : list) {
				if (emp.getUserId().equals(empLogin.getUserId()) && 
						emp.getPassword().equals(empLogin.getPassword())) {
				    emp1=emp;
					   ModelAndView mv= new ModelAndView("dashbord/dashbord");
					 
					   mv.addObject("fname",emp.getfName());
					   mv.addObject("lname",emp.getlName());
					   
					   
					
					
					return mv;
				}
			}
		    return new ModelAndView("redirect:/v1/bank/app");
		
	}
	
	
	@GetMapping("/loginDone")
	public ModelAndView dashbord1(){
					  
		    return new ModelAndView("dashbord/dashbord");
		
	}
	@GetMapping("/empLogin")
	public ModelAndView empLogin(@ModelAttribute EmployeeLogin empLogin){
		   
		e1 = es.getByUserId(empLogin.getUserId());
		
		    List<EmployeeLogin> list=loginSer.findByType("Admin");
		    
		    for (EmployeeLogin emp : list) {
				if (emp.getUserId().equals(empLogin.getUserId()) && 
						emp.getPassword().equals(empLogin.getPassword())) {
					
				          ModelAndView mv= new ModelAndView("dashbord/empDashbord");
				          
				          mv.addObject("ballence", e1.getBallence());
					return mv ;
					
				}
			}
		    return new ModelAndView("redirect:/v1/bank/app");
		
	}
	
	@PostMapping("/saveLoginD")
	public void save_loginUser(@ModelAttribute EmployeeLogin emplogin,
			                      HttpServletRequest req,HttpServletResponse res) {
		
		String pwd = (String)req.getParameter("password1");
		
		Long accNo = emplogin.getAccNo();
		
		if(customerServ.findByAdharNo(accNo)==null) {
			
			loginSer.checkLogin(emplogin,pwd);
			
			System.out.println(pwd);
			System.out.println(emplogin);
			
		}
		
	}
	
	/*
	 * this method is Used to Create New Account 
	 * Form only ..Display form Olny
	 * for Customer Imformation like Name ,last name, mobile no like that
	 * 
	 * */
	
	@GetMapping("/accForm")
	public ModelAndView createFrom() {
		
		return new ModelAndView("login/accOpenForm");
	}

	
	
	@PostMapping("/accDone")
public ModelAndView accDone(@ModelAttribute Customer customer) {
		
		customer.setAccountNo(0000l);
		
		System.out.println(customer);
		
		Customer cust = customerServ.findByMobileNo(customer.getMobileNo());
		Customer cust1= customerServ.findByAdharNo(customer.getAdharId());
		
		if (cust1==null) {
			System.out.println("inside if");
			try {
				
				customerServ.save(customer);
				
				ModelAndView mv= new ModelAndView("login/suc");
				mv.addObject("account", " Account Create sussfully Wait for Aprowal");
				return mv;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("outSide if");
		return new ModelAndView("redirect:/v1/bank/accForm");
	}
	
	
	@GetMapping("get/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) {
		System.out.println("in side main method Controller");
		
		return es.getEmployeeById(id);
	}
	@GetMapping("/getAll")
	public List<Employee> getAllEmployee() {
		System.out.println("in side main method Controller");
		
		return es.getAllEmployee();
	}
	@PostMapping("/save")
	
	public Employee main(@RequestBody Employee employee) {
		
		System.out.println("inside methoed");
		return es.saveEmployee(employee);
	}
	
	@GetMapping("/dashbord")
	public ModelAndView dashbord() {
		
		return new ModelAndView("dashbord/dashbord");
	}
	

}
