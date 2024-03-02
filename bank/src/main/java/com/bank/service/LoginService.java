package com.bank.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.EmployeeLogin;
import com.bank.repo.LoginRepo;

import jakarta.persistence.GeneratedValue;

@Service
public class LoginService {
	@Autowired
	LoginRepo repo;

	public List<EmployeeLogin> getAll() {

		return repo.findAll();
	}

	public EmployeeLogin getByid(int id) {

		return repo.findById(id).get();
	}

	public EmployeeLogin save(EmployeeLogin empLogin) {

		return repo.save(empLogin);
	}

	
	public void checkLogin(EmployeeLogin emplogin, String pwd) {

		List<EmployeeLogin> all = repo.findAll();
		

		if (all.isEmpty()) {
			if ((emplogin.getPassword().equals(pwd))) {
				System.out.println("two password is same ");
				emplogin.setType("customer");
				repo.save(emplogin);
				

			} else {
				System.out.println(" Please enter the Same Password .......!!!!");

			}

		} else {

			for (EmployeeLogin emp : all) {
				
				if (!emp.getUserId().equals(emplogin.getUserId())) {

					

					if ((emplogin.getPassword().equals(pwd))) {
						emplogin.setType("customer");
						repo.save(emplogin);
						
						break;
					} else {
						System.out.println(" Please enter the Same Password .......!!!!");
						break;

					}

				}

				else {
					System.out.println("this User id Already exit.......!!!!");
				}
			}

		}
	}
	
	
	
				

				public List<EmployeeLogin> findByType(String type) {
					
					return repo.findByType(type);
				}
				
			
}
