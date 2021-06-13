package com.raghul.expensetracker.dto;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class UserDTO {
	
	private String userId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private List<UserEmailDTO> userEmail;
	private List<UserPhoneDTO> userPhone;
	private List<UserPasswordDTO> userPassword;
	private List<UserSalaryDTO> userSalary;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<UserEmailDTO> getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(List<UserEmailDTO> userEmail) {
		this.userEmail = userEmail;
	}
	public List<UserPhoneDTO> getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(List<UserPhoneDTO> userPhone) {
		this.userPhone = userPhone;
	}
	public List<UserPasswordDTO> getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(List<UserPasswordDTO> userPassword) {
		this.userPassword = userPassword;
	}
	public List<UserSalaryDTO> getUserSalary() {
		return userSalary;
	}
	public void setUserSalary(List<UserSalaryDTO> userSalary) {
		this.userSalary = userSalary;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
