package com.cash.apirest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	@OneToMany(targetEntity = Loan.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@ElementCollection
	private List<Loan> loans;
	
}