package com.raghul.expensetracker.service;

import java.util.UUID;

import com.raghul.expensetracker.dto.UserDTO;

public interface UserService {
	
	UserDTO createUser(UserDTO userDTO);
	
	UserDTO getUser(UUID userId);
	

}
