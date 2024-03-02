package com.bank.controller;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bank.ObjectModel.Transfer;
import com.bank.model.Customer;
import com.bank.model.Statements;
import com.bank.repo.StatmentRepo;
import com.bank.service.CustomerService;
import com.bank.service.EmployeeService;
import com.bank.service.StatementsServ;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("v1/bank/emp/")
public class EmployeeController {

	@Autowired
	CustomerService custServ;
	
	@Autowired
	StatementsServ stmtService;
	
	@Autowired
	EmployeeService empService;
	
	
	/*  	Get All Customers
	 * 
	 * 
	 * */
	
	@GetMapping("/getAll/customers")
	
		public List<Customer> getAllCustomer() {
			
		   return custServ.getAllCustomer();
		}
	
	/* This method is used to Get a 
	  *  Minimum Costomer if you want Only 5 Customer Then it 
	  *  
	  *  return only Five Costomer list
	  * */
	
	@GetMapping("/get/customers/{display}")
	
		public List<Customer> getlimitCustomer(@PathVariable int display) {
			
		   return custServ.limitedCustomer(display);
		}
	
	 /* This method is used to Get a 
	  *  Minimum Costomer if you want next 5 Customer Then it 
	  *  
	  *  return next Five Costomer list
	  * */
	
	@GetMapping("/getnP/customers/{display}")
	
		public List<Customer> getlimitNextPageCustomer(@PathVariable int display) {
			
		   return custServ.limitedNextPageCustomer(display);
		}
	
	
	
	
	/* this method is used to  find customer
	 * by using Mobile No;
	 * 
	 * */
	
	@GetMapping("/getAll/custM/{mobileNo}")
	
	public Customer findByMobileNo(@PathVariable Long mobileNo) {
		
	   return custServ.findByMobileNo(mobileNo);
	}
	
	/*this mehtod is Find By customer 
	 * by using Account No of Customer ;
	 * 
	 * */
	@GetMapping("/getAll/custA/{accountNo}")
	public Customer findByAccountNo( @PathVariable Long accountNo) {
		
		return custServ.findByAccountNo(accountNo);
	}
	
	/**
	 *this method is Used to  Find By List <Customer> 
	 *By using customer Name 
	 *
	 */
	@GetMapping("/getAll/custN/{name}")
	  public List<Customer> findByName(@PathVariable String name){
		
		return custServ.findByName(name);  
	  }
	
	/*this method is Used to Find The List <Customer>
	 * by using The address of customer
	 * 
	 * 
	 * */
	@GetMapping("/getAll/custAddres/{address}")
	  public List<Customer> findByAddress(@PathVariable String address){
		
		return custServ.findByAddress(address);  
	  }
	
	/* this method is Used to Get all Transaction/BankStatment
	 * 
	 * By using account nO of customer
	
	 */
	
	@GetMapping("/getAll/custTnx/{accountNo}")
	  public  List<Statements> getAllTranx(@PathVariable Long accountNo){
		
		return custServ.getAllStatementlist(accountNo);  
		
	  }
	
	@GetMapping("/reports")
	public ModelAndView viewPendingReport() {
		
		
		return  new ModelAndView("dashbord/viewReport");
	}
	
	@GetMapping("/gen_account")
	public ModelAndView genrateAccountNo() {
		ModelAndView mv= new ModelAndView("dashbord/viewReport/gen_Acc");
		
		List<Customer> allCustomer = custServ.getAllCustomer();
	
		
		List<Customer> collect = allCustomer.stream().filter(e-> e.getAccountNo()==0)
									.collect(Collectors.toList());
		 mv.addObject("list", collect);
		System.out.println(collect);
		return mv ;
	}
	
	@GetMapping("/gen_log_pwd")
	public ModelAndView gen_log_pwd() {
		
		
		return  new ModelAndView("dashbord/viewReport/gen_log_pwd");
	}
	
	
	@GetMapping("/gen_account/{id}")
	public ModelAndView genrateAccountNoBySrNo(@PathVariable Integer id) {
		ModelAndView mv= new ModelAndView("dashbord/viewReport");
		
		Customer customer = custServ.findById(id);
	
		customer.setAccountNo(genrateAccNo());
		
		custServ.save(customer);
		
		return mv ;
	}
	
	 public Long genrateAccNo() {
		 Long nextInt = (Long) new Random().nextLong();
		 String substring = nextInt.toString().substring(2, 6);
		 Long l= new Long(substring);
		 
		
		return l;
		
		
	}
	@GetMapping("/allstatement")
	public ModelAndView allviewsStatement() {
		ModelAndView mv = new ModelAndView("/dashbord/viewReport/statement");
		List<Statements> list = stmtService.getAllStatement();
		mv.addObject("statment", list);
		
		return mv;
	}
	
	@GetMapping("/veiwStatment")
	public ModelAndView viewsStatement() {
		ModelAndView mv = new ModelAndView("/dashbord/viewReport/statement1");
		
		
		return mv;
	}
	
	@PostMapping("/stat121")
	public ModelAndView viewsStatementByAccountNo( HttpServletRequest req) {
		
		String s="23-02-2024";
		Integer n=new Integer(s.replace('-', ' ').replaceAll("\\s", ""));
		System.out.println(n);
		
		
		 String  parameter =  req.getParameter("acc");
		Long accNo=new Long(parameter.trim());
		List<Statements> stmt = stmtService.findBySelfNo(accNo);
		ModelAndView mv = new ModelAndView("/dashbord/viewReport/stmtByAcc");
		 mv.addObject("statment", stmt);

		 mv.addObject("accNo", accNo);
		return mv;
	}
	
	
	@PostMapping("/stmtDate")
	public ModelAndView stmtDate(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("/dashbord/viewReport/statByDate");
		
		List<Statements> statByDate1 = stmtService.getStatByDate(req);
		
		mv.addObject("date", statByDate1);
		
		System.out.println(statByDate1);
		
		return mv;
	}
	
	
	@GetMapping("/stmtToday")
	public ModelAndView stmtByToday() {
		
		ModelAndView mv = new ModelAndView("/dashbord/viewReport/stmtByToday");
		 
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		
		LocalDate l= LocalDate.now();
		String today = dtf.format(l);
		
		System.out.println(today);
	
		List<Statements> statByDate1 = null;
		
		try {
			System.out.println("inside try Block........................................!!!!!!!!");
			 statByDate1 = stmtService.getStmtByToday(today);
			 
			 System.out.println("inside try Block........................................!!!!!!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		mv.addObject("date", statByDate1);
//		
		
		System.out.println(statByDate1);
		
		return mv;
	}
	
	
	
	
	@GetMapping("/f_trans")
	public ModelAndView fundTranfer() {
	
		
		return new ModelAndView("/dashbord/admin/f_trans");
	}
	
	@PostMapping("/tranfer")
	public ModelAndView fundTranferOk(@ModelAttribute Transfer tns) {
		
		
		ModelAndView mv = empService.fundTransfer(tns);
		
		return mv ;
		
	}
	
	
	
	
	
}
