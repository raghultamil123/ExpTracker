package com.raghul.expensetracker.service;

import java.util.UUID;

import com.raghul.expensetracker.dto.AuthRequestDTO;
import com.raghul.expensetracker.dto.AuthResponseDTO;
import com.raghul.expensetracker.dto.UserDTO;
import com.raghul.expensetracker.exception.UnauthorizedException;

public interface UserService {
	
	UserDTO createUser(UserDTO userDTO);
	
	UserDTO getUser(UUID userId);
	
	AuthResponseDTO authenticateUser(AuthRequestDTO authRequestDTO) throws UnauthorizedException;
	

}
