package com.raghul.expensetracker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class UserPhoneDTO {
	
	private String id;
	private String phone;
	private Boolean isAllowedToRead;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Boolean getIsAllowedToRead() {
		return isAllowedToRead;
	}
	public void setIsAllowedToRead(Boolean isAllowedToRead) {
		this.isAllowedToRead = isAllowedToRead;
	}
	
	
	
	

}
