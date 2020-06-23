package com.cash.apirest.service;

import java.util.List;

import com.cash.apirest.entity.Loan;

public interface LoanService {
	
	public List<Loan> findAll();
	
	public Loan findById(int id);
	
	public void save(Loan loan);
	
	public void deleteById(int id);

}
