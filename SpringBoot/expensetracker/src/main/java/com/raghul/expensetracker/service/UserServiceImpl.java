package com.raghul.expensetracker.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.raghul.expensetracker.dto.AuthRequestDTO;
import com.raghul.expensetracker.dto.AuthResponseDTO;
import com.raghul.expensetracker.dto.UserDTO;
import com.raghul.expensetracker.exception.UnauthorizedException;
import com.raghul.expensetracker.model.User;
import com.raghul.expensetracker.model.UserEmail;
import com.raghul.expensetracker.model.UserPassword;
import com.raghul.expensetracker.model.UserPhone;
import com.raghul.expensetracker.repository.UserEmailRepository;
import com.raghul.expensetracker.repository.UserPasswordRepository;
import com.raghul.expensetracker.repository.UserPhoneRepository;
import com.raghul.expensetracker.repository.UserRepository;
import com.raghul.expensetracker.translator.UserTranslator;

@Component
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserRepository userRepository;
	
	@Resource
	private UserPasswordRepository userPasswordRepository;
	
	@Resource
	private UserTranslator userTranslator;
	
	@Resource
	private UserEmailRepository userEmailRepository;
	
	@Resource
	private UserPhoneRepository userPhoneRepository;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = userTranslator.translateToUserDTO(userDTO);
		UUID userId = userRepository.save(user).getUserId();
		List<UserPassword> userPassword = userTranslator.translateToUserPassword(userDTO.getUserPassword(), userId);
		userPasswordRepository.saveAll(userPassword);
		List<UserEmail> userEmails = userTranslator.translateToUserEmail(userDTO, userId);
	    userEmailRepository.saveAll(userEmails);
		userDTO = new UserDTO();
		userDTO.setUserId(userId.toString());
		return userDTO;
	}

	@Override
	public UserDTO getUser(UUID userId) {
		User user = userRepository.getOne(userId);
		List<UserEmail> userEmails = userEmailRepository.findByUserId(userId);
		List<UserPhone> userPhones = userPhoneRepository.findByUserId(userId);
		UserDTO userDTO = userTranslator.translateToUserDTO(user);
		userDTO.setUserPhone(userTranslator.translateToUserPhoneDTOs(userPhones));;
		userDTO.setUserEmail(userTranslator.translateToUserEmailDTOs(userEmails));
		
		return userDTO;
	}

	@Override
	public AuthResponseDTO authenticateUser(AuthRequestDTO authRequestDTO) throws UnauthorizedException {
		
		User user = userRepository.findByFirstName(authRequestDTO.getUsername());
		if(user != null) {
		  List<UserPassword> userPasswords = userPasswordRepository.findByUserId(user.getUserId());
		  if(!userPasswords.isEmpty()) {
			  AuthResponseDTO authResponseDTO = new AuthResponseDTO();
			  userPasswords.forEach( (password)->{
				  if(password.getPassword().equals(authRequestDTO.getPassword())) {
					  authResponseDTO.setUserId(user.getUserId().toString());
				  }
			  });
			  if(authResponseDTO.getUserId() != null) {
				  return authResponseDTO;
			  }else {
				  throw new UnauthorizedException("Invalid Username");
			  }
		  }
		  throw new UnauthorizedException("invalid details");
		}
		
		throw new UnauthorizedException("invalid details");
		
		
		
		
		
	}

}
