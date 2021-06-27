package com.raghul.expensetracker.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="expense")
public class Expense extends BaseModel{
	
	@Id
	@Column(name="expense_id")
	@Type(type="uuid-char")
	private UUID expenseId;
	@Column(name="expense_name")
	private String expenseName;
	@Column(name="userId")
	@Type(type="uuid-char")
	private UUID userId;
	public UUID getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(UUID expenseId) {
		this.expenseId = expenseId;
	}
	public String getExpenseName() {
		return expenseName;
	}
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	

}
