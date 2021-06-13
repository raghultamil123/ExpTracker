package com.raghul.expensetracker.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="user_salary")
public class UserSalary extends BaseModel{

	@Id
	@Column(name="user_salary_id")
	@Type(type="uuid-char")
	private UUID userSalaryId;
	@Column(name="user_salary")
	private Integer userSalary;
	@Column(name="user_id")
	private UUID userId;
	public UUID getUserSalaryId() {
		return userSalaryId;
	}
	public void setUserSalaryId(UUID userSalaryId) {
		this.userSalaryId = userSalaryId;
	}
	public Integer getUserSalary() {
		return userSalary;
	}
	public void setUserSalary(Integer userSalary) {
		this.userSalary = userSalary;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	
}
