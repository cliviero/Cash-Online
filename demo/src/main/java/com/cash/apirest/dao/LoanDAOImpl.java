package com.cash.apirest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cash.apirest.entity.Loan;

@Repository
public class LoanDAOImpl implements LoanDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Loan> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Loan> theQuery = currentSession.createQuery("from Loan ORDER BY user_id ASC", Loan.class);
		
		List<Loan> loans = theQuery.getResultList();
		
		return loans;
	}

	@Override
	public Loan findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Loan user = currentSession.get(Loan.class, id);
		
		return user;
	}

	@Override
	public void save(Loan loan) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(loan);		
	}

	@Override
	public void deleteById(int userId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Loan> theQuery = currentSession.createQuery("delete from loan where user_id=:userId");
		
		theQuery.setParameter("userId", userId);
		theQuery.executeUpdate();
	}
	
}