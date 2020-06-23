package com.cash.apirest.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cash.apirest.dao.LoanDAO;
import com.cash.apirest.dao.UserDAO;
import com.cash.apirest.entity.Loan;
import com.cash.apirest.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
//	@Autowired
//	private LoanDAO loanDAO;
	
	@Override
	public List<User> findAll() {
		List<User> listUsers= userDAO.findAll();
//		List<Loan> loans = loanDAO.findAll();
//		//recorro los usuarios y les agrego sus préstamos correspondientes
//		int userId = listUsers.get(0).getId();
//		int prevUserId = userId;
//		int loanUserId = 0;
//		Loan loan = null;
//		List<Loan> auxLoans = new ArrayList<Loan>();
//		Iterator<Loan> it = loans.iterator();
//		for (User user : listUsers) {
//			if (userId == prevUserId) {
//				while(it.hasNext() && userId == prevUserId) {
//					loan = it.next();
//					loanUserId = loan.getUserId();
//					if (loanUserId == userId) {
//						auxLoans.add(loan);
//					} else {
//						//le paso la lista auxiliar de loans a users
//						user.setLoanList(auxLoans);
//						//limpio la lista y le agrego este préstamo para no perderlo
//						auxLoans = new ArrayList<Loan>();
//						auxLoans.add(loan);
//						//aviso que el usuario cambió y corta el recorrido de préstamos
//						prevUserId = loanUserId;
//					}
//				}
//			}
//		}
		return listUsers;
	}

	@Override
	public User findById(int id) {
		User user = userDAO.findById(id);
		return user;
	}

	@Override
	public void save(User user) {
		userDAO.save(user);

	}

	@Override
	public void deleteById(int id) {
		userDAO.deleteById(id);
	}

}