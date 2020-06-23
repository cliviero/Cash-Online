package com.cash.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cash.apirest.dao.LoanDAO;
import com.cash.apirest.entity.Loan;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanDAO loanDAO;
	
	@Override
	public List<Loan> findAll() {
		List<Loan> listLoans= loanDAO.findAll();
		return listLoans;
	}

	@Override
	public Loan findById(int id) {
		Loan loan = loanDAO.findById(id);
		return loan;
	}

	@Override
	public void save(Loan loan) {
		loanDAO.save(loan);

	}

	@Override
	public void deleteById(int id) {
		loanDAO.deleteById(id);
	}

}