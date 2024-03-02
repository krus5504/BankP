package com.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.Statements;

@Repository
public interface StatmentRepo extends JpaRepository<Statements, Integer>{
 public List<Statements> findBySelfNo(Long acc_no);

public List<Statements> findByDate(String date);
}
