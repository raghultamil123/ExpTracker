package com.raghul.expensetracker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class ExpenseItemDTO {
	
	private String expenseItemId;
	private String expenseItemName;
	private Integer expenseItemPrice;
	private Integer expenseItemQuantity;
	public String getExpenseItemId() {
		return expenseItemId;
	}
	public void setExpenseItemId(String expenseItemId) {
		this.expenseItemId = expenseItemId;
	}
	public String getExpenseItemName() {
		return expenseItemName;
	}
	public void setExpenseItemName(String expenseItemName) {
		this.expenseItemName = expenseItemName;
	}
	public Integer getExpenseItemPrice() {
		return expenseItemPrice;
	}
	public void setExpenseItemPrice(Integer expenseItemPrice) {
		this.expenseItemPrice = expenseItemPrice;
	}
	public Integer getExpenseItemQuantity() {
		return expenseItemQuantity;
	}
	public void setExpenseItemQuantity(Integer expenseItemQuantity) {
		this.expenseItemQuantity = expenseItemQuantity;
	}
	
	
	

}
