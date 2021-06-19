package com.raghul.expensetracker.controller;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghul.expensetracker.dto.AuthRequestDTO;
import com.raghul.expensetracker.dto.UserDTO;
import com.raghul.expensetracker.service.UserService;

@RequestMapping("/api/user")
@RestController
@CrossOrigin
public class UserController {
	
	@Resource
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
		userService.createUser(userDTO);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{userId}/user-details")
	public ResponseEntity<?> getUserDetails(@PathVariable("userId")UUID userId){
	   UserDTO userDTO = userService.getUser(userId);
	   return ResponseEntity.ok(userDTO);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody AuthRequestDTO authRequestDTO){
	
		try {
			return ResponseEntity.ok(userService.authenticateUser(authRequestDTO));
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
}
