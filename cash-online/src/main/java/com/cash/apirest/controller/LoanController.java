package com.cash.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cash.apirest.entity.Loan;
import com.cash.apirest.repository.LoanRepository;

@RestController
public class LoanController {
	@Autowired
	private LoanRepository loanRepository;
	
	/*
	 * Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url 
	 * http://127.0.0.1:8080/loans?page=1&size=50 o bien http://127.0.0.1:8080/loans?page=1&size=50&user_id=1
	 */
	
	@RequestMapping(value = "/loans", method = RequestMethod.GET)
	public Page<Loan> findPaginatedLoansByUserId(@RequestParam(value = "user_id", required=false) Integer userId, Pageable pageRequest) {
		if (userId != null) {
			return loanRepository.findAllByUserId(userId, pageRequest);
		} else {
			return loanRepository.findAll(pageRequest);
		}
	}
	

}
