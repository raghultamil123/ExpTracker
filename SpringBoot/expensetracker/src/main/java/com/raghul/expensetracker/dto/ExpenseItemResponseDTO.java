package com.raghul.expensetracker.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class ExpenseItemResponseDTO {
	
	private Integer expenseItemsTotal;
	private List<ExpenseItemDTO> expenseItems;
	public Integer getExpenseItemsTotal() {
		return expenseItemsTotal;
	}
	public void setExpenseItemsTotal(Integer expenseItemsTotal) {
		this.expenseItemsTotal = expenseItemsTotal;
	}
	public List<ExpenseItemDTO> getExpenseItems() {
		return expenseItems;
	}
	public void setExpenseItems(List<ExpenseItemDTO> expenseItems) {
		this.expenseItems = expenseItems;
	}
	
	
	

}
