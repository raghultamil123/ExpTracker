package com.raghul.expensetracker.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class ExpenseDTO {
	
	private String expenseId;
	private String expenseName;
	private List<ExpenseItemDTO> expenseItems;
	private String userId;
	private String createdOn;
	public String getExpenseName() {
		return expenseName;
	}
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	public List<ExpenseItemDTO> getExpenseItems() {
		return expenseItems;
	}
	public void setExpenseItems(List<ExpenseItemDTO> expenseItems) {
		this.expenseItems = expenseItems;
	}
	public String getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(String expenseId) {
		this.expenseId = expenseId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	
	
	
	
	

}
