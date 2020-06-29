package com.cash.apirest.repository;

import com.cash.apirest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findById(int id);
	public void deleteById(int id);
}