package com.cash.apirest.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="loan")
public class Loan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="total")
	private BigDecimal total;
	
	@Column(name="userId")
	private int userId;
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

	public Loan() {}
	
	public Loan(int id, BigDecimal total, int userId) {
		this.id = id;
		this.total = total;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "{\n \"id\" :" + id + ", "
				+ " \n\"total\": " + total + ", "
				+ " \n\"userId\": " + userId + ", "
				+ "\n}"
				+ "\n";
	}
	
	
}