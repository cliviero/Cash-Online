package com.cash.apirest.controller;

import com.cash.apirest.dto.UserRequest;
import com.cash.apirest.entity.Loan;
import com.cash.apirest.entity.User;
import com.cash.apirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void initDB() {
		List<User> users=new ArrayList<>();
		List<Loan> loans1=new ArrayList<>();
		List<Loan> loans2=new ArrayList<>();
		List<Loan> loans3=new ArrayList<>();
		loans1.add(new Loan(1,new BigDecimal(2500),1));
		loans1.add(new Loan(2,new BigDecimal(65120.75),1));
		loans2.add(new Loan(3,new BigDecimal(5000),2));
		loans3.add(new Loan(4,new BigDecimal(4000),3));
		users.add(new User(1, "test@app.com.ar", "Pepe", "Argento", loans1));
		users.add(new User(1, "test@app.com.ar", "Pepe", "Argento", loans1));
		users.add(new User(2, "test2@app.com.ar", "Coqui", "Argento", loans2));
		users.add(new User(3, "test3@app.com.ar", "Dardo", "Fuseneco", loans3));
		userRepository.saveAll(users);
	}
	
	/*
	 * Este método se hará cuando por una petición POST (como indica la anotación)
	 * se llame a la url http://127.0.0.1:8080/users
	 */
	
	@PostMapping("/users")
	public User createUser(@RequestBody UserRequest request) {
		return userRepository.save(request.getUser());
	}
	
	/*
	 * Este método se hará cuando por una petición GET (como indica la anotación) se
	 * llame a la url http://127.0.0.1:8080/users
	 */
	
	@GetMapping("/users")
	public List<User> getUsers() {
		// retornará todos los usuarios con sus loans
		return userRepository.findAll();
	}

	/*
	 * Este método se hará cuando por una petición GET (como indica la anotación) se
	 * llame a la url + el id de un usuario http://127.0.0.1:8080/users/1
	 */
	@GetMapping("/users/{userId}")
	public User getUserById(@PathVariable int userId) {
		User user = userRepository.findById(userId);
		
		if (user == null) {
			throw new RuntimeException("User id not found -" + userId);
		}
		// retornará al usuario con id pasado en la url
		return user;
	}

	/*
	 * Este método se hará cuando por una petición DELETE (como indica la anotación)
	 * se llame a la url + id del usuario http://127.0.0.1:8080/users/1
	 */
	@DeleteMapping("users/{userId}")
	public String deteteUser(@PathVariable int userId) {
		User user = userRepository.findById(userId);

		if (user == null) {
			throw new RuntimeException("User id not found -" + userId);
		}

		userRepository.deleteById(userId);

		// Este método, recibira el id de un usuario por URL y se borrará de la bd junto con su loan asociado.
		return "Deleted user id - " + userId;
	}

}