package com.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.EmployeeLogin;

@Repository
public interface LoginRepo extends JpaRepository<EmployeeLogin, Integer> {

	public List<EmployeeLogin> findByType(String type);
}
