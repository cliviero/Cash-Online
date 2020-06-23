package com.cash.apirest.dao;

import java.util.List;

import com.cash.apirest.entity.Loan;

public interface LoanDAO {
	
	public List<Loan> findAll();
	
	public Loan findById(int id);
	
	public void save(Loan loan);
	
	public void deleteById(int id);

}
