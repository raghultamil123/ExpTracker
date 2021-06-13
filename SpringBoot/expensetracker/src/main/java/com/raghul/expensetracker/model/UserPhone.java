package com.raghul.expensetracker.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="user_phone")
public class UserPhone extends BaseModel{
	
	@Id
	@Column(name="user_phone_id")
	@Type(type="uuid-char")
	private UUID userPhoneId;
	@Column(name="user_id")
	@Type(type="uuid-char")
	private UUID userId;
	@Column(name="phone_number")
	private String phoneNumber;
	@Column(name="is_allow_to_read")
	private Boolean isAllowToRead;
	@Column(name="is_primary")
	private Boolean isPrimary;
	public UUID getUserPhoneId() {
		return userPhoneId;
	}
	public void setUserPhoneId(UUID userPhoneId) {
		this.userPhoneId = userPhoneId;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Boolean getIsAllowToRead() {
		return isAllowToRead;
	}
	public void setIsAllowToRead(Boolean isAllowToRead) {
		this.isAllowToRead = isAllowToRead;
	}
	public Boolean getIsPrimary() {
		return isPrimary;
	}
	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	
	

}
