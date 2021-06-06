package com.raghul.expensetracker.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.raghul.expensetracker.dto.ExpenseDTO;
import com.raghul.expensetracker.dto.ExpenseItemResponseDTO;

public interface ExpenseService {

	void saveExpense(ExpenseDTO expenseDTO);
	
	List<ExpenseDTO> getAllExpense();
	
	ExpenseDTO getExpenseDetails(UUID expenseId);
	
	ExpenseItemResponseDTO getExpenseItems();
	
	Map<String,String> getExpenseDashboard();
}
