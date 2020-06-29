package com.cash.apirest.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cash.apirest.entity.Loan;
import com.cash.apirest.repository.LoanRepository;

public class LoanController {
	@Autowired
	private LoanRepository loanRepository;
	
	public void initDB() {
		List<Loan> loans=new ArrayList<>();
		loans.add(new Loan(new BigDecimal(2500.00)));
		loans.add(new Loan(new BigDecimal(65120.75)));
		loanRepository.saveAll(loans);
	}
	
	/*
	 * Este método se hará cuando por una petición GET (como indica la anotación) se
	 * llame a la url http://127.0.0.1:8080/loans
	 */
	
	@GetMapping("/loans")
	public List<Loan> getLoans() {
		// retornará todos los loans
		return loanRepository.findAll();
	}

	/*
	 * Este método se hará cuando por una petición GET (como indica la anotación) se
	 * llame a la url + el id de un loan http://127.0.0.1:8080/loans/1
	 */
	@GetMapping("/loans/{userId}")
	public Loan findLoanByUserId(@PathVariable int userId) {
		Loan loan = loanRepository.findByUserId(userId);
		
		if (loan == null) {
			throw new RuntimeException("Loan id not found -" + userId);
		}
		// retornará al loan con id de usuario pasado en la url
		return loan;
	}
	

}
