package com.raghul.expensetracker.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="user_email")
public class UserEmail extends BaseModel{
	
	@Column(name="user_email_id")
	@Type(type="uuid-char")
	@Id
	private UUID userEmailId;
	@Column(name="email_id")
	private String emailId;
	@Column(name="user_id")
	@Type(type="uuid-char")
	private UUID userId;
	@Column(name="is_primary")
	private Boolean isPrimary;
	public UUID getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(UUID userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public Boolean getIsPrimary() {
		return isPrimary;
	}
	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	
	
	

}
