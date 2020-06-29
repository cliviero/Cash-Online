package com.cash.apirest.dto;

import com.cash.apirest.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {

    private User user;

	public User getUser() {
		return user;
	}
	
}
