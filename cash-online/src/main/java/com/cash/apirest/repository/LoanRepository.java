package com.cash.apirest.repository;

import com.cash.apirest.entity.Loan;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,Integer> {
	
	public Page<Loan> findAllByUserId(Integer id, Pageable pageRequest);
}
