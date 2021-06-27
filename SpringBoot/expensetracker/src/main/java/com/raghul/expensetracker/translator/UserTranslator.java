package com.raghul.expensetracker.translator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.raghul.expensetracker.dto.UserDTO;
import com.raghul.expensetracker.dto.UserEmailDTO;
import com.raghul.expensetracker.dto.UserPasswordDTO;
import com.raghul.expensetracker.dto.UserPhoneDTO;
import com.raghul.expensetracker.model.User;
import com.raghul.expensetracker.model.UserEmail;
import com.raghul.expensetracker.model.UserPassword;
import com.raghul.expensetracker.model.UserPhone;

@Component
public class UserTranslator {
	
	
	public User translateToUserDTO(UserDTO userDTO) {
		User user = new User();
		user.setUserId(UUID.randomUUID());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setDateOfBirth(userDTO.getDateOfBirth());
		return user;
	}
	
	
	public UserDTO translateToUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(user.getUserId().toString());
		userDTO.setFirstName( user.getFirstName());
		userDTO.setLastName( user.getLastName());
		userDTO.setDateOfBirth( user.getDateOfBirth());
		return userDTO;
	}
	public List<UserEmail> translateToUserEmail(UserDTO userDTO,UUID userId) {
		List<UserEmailDTO> emailsDTO = Optional.ofNullable(userDTO.getUserEmail()).orElse(Collections.emptyList());
		
		if(!emailsDTO.isEmpty()) {
			List<UserEmail> emails = new ArrayList<>();
			emailsDTO.forEach(  emailDTO->{
				emails.add(translateToUserEmail(emailDTO,userId));
			});
			return emails;
		}
		return Collections.emptyList();
		
	}
	
	public UserEmail translateToUserEmail(UserEmailDTO userEmailDTO,UUID userId) {
		UserEmail email = new UserEmail();
		email.setUserId(userId);
		email.setUserEmailId(UUID.randomUUID());
		email.setEmailId(userEmailDTO.getEmail());
		email.setIsPrimary(userEmailDTO.getIsPrimary());
		return email;
		
	}
	
	public List<UserPassword> translateToUserPassword(List<UserPasswordDTO> userPasswordDTOs,UUID userId){
		userPasswordDTOs = Optional.ofNullable(userPasswordDTOs).orElse(Collections.emptyList());
		
		if(!userPasswordDTOs.isEmpty()) {
			List<UserPassword> userPasswords = new ArrayList<>();
			userPasswordDTOs.forEach( (userPasswordDTO)->{
				userPasswords.add(translateToUserPassword(userPasswordDTO,userId));
			});
			return userPasswords;
		}
		return Collections.emptyList();
		
	}
	
	public UserPassword translateToUserPassword(UserPasswordDTO userPasswordDTO,UUID userId) {
		UserPassword userPassword = new UserPassword();
		userPassword.setUserId(userId);
		userPassword.setPassword(userPasswordDTO.getPassword());
		userPassword.setUserPasswordId(UUID.randomUUID());
		return userPassword;
	}
	
	public List<UserEmailDTO> translateToUserEmailDTOs(List<UserEmail> userEmails){
	    userEmails = Optional.ofNullable(userEmails).orElse(Collections.emptyList()) ;
	    if(!userEmails.isEmpty()) {
			List<UserEmailDTO> emailDTOs = new ArrayList<>();
			userEmails.forEach( (email)->{
				emailDTOs.add(translateToUserEmailDTO((email)));

			});
			return emailDTOs;	
	    }
	    
	    return Collections.emptyList();
	}
	
	public List<UserPhoneDTO> translateToUserPhoneDTOs(List<UserPhone> userPhones){
		userPhones = Optional.ofNullable(userPhones).orElse(Collections.emptyList()) ;
	    if(!userPhones.isEmpty()) {
			List<UserPhoneDTO> userPhoneDTOs = new ArrayList<>();
			userPhones.forEach( (phone)->{
				userPhoneDTOs.add(translateToUserPhoneDTO((phone)));

			});
			return userPhoneDTOs;	
	    }
	    
	    return Collections.emptyList();
	}
	
	public List<UserPasswordDTO> translateToUserPasswordDTOs(List<UserPassword> userPasswords){
		userPasswords = Optional.ofNullable(userPasswords).orElse(Collections.emptyList()) ;
	    if(!userPasswords.isEmpty()) {
			List<UserPasswordDTO> userPasswordDTOs = new ArrayList<>();
			userPasswords.forEach( (password)->{
				userPasswordDTOs.add(translateToUserPasswordDTO((password)));

			});
			return userPasswordDTOs;	
	    }
	    
	    return Collections.emptyList();
	}
	
	public UserEmailDTO translateToUserEmailDTO(UserEmail userEmail) {
	   UserEmailDTO userEmailDTO = new UserEmailDTO();
	   userEmailDTO.setEmail(userEmail.getEmailId());
	   userEmailDTO.setIsPrimary(userEmail.getIsPrimary());
	   return userEmailDTO;
	}
	
	public UserPhoneDTO translateToUserPhoneDTO(UserPhone userPhone) {
		UserPhoneDTO userPhoneDTO = new UserPhoneDTO();
		userPhoneDTO.setPhone(userPhone.getPhoneNumber());
		userPhoneDTO.setIsAllowedToRead(userPhone.getIsAllowToRead());
		return userPhoneDTO;
	}
	public UserPasswordDTO translateToUserPasswordDTO(UserPassword userPassword) {
		UserPasswordDTO userPasswordDTO = new UserPasswordDTO();
		userPasswordDTO.setPassword(userPassword.getPassword());
		return userPasswordDTO;
	}

}
