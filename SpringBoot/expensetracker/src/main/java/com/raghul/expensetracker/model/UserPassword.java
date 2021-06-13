package com.raghul.expensetracker.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="user_password")
public class UserPassword extends BaseModel{

	@Id
	@Column(name="user_password_id")
	@Type(type="uuid-char")
	private UUID userPasswordId;
	@Column(name="user_id")
	@Type(type="uuid-char")
	private UUID userId;
	@Column(name="password")
	private String password;
	public UUID getUserPasswordId() {
		return userPasswordId;
	}
	public void setUserPasswordId(UUID userPasswordId) {
		this.userPasswordId = userPasswordId;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
