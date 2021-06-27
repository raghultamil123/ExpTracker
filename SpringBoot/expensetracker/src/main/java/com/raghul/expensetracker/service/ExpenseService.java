package com.raghul.expensetracker.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.raghul.expensetracker.dto.ExpenseDTO;
import com.raghul.expensetracker.dto.ExpenseItemDTO;
import com.raghul.expensetracker.dto.ExpenseItemResponseDTO;
import com.raghul.expensetracker.model.ExpenseItem;

public interface ExpenseService {

	void saveExpense(UUID userId,ExpenseDTO expenseDTO);
	
	List<ExpenseDTO> getAllExpense(UUID userId);
	
	ExpenseDTO getExpenseDetails(UUID userId,UUID expenseId);
	
	ExpenseItemResponseDTO getExpenseItems(UUID userId);
	
	Map<String,String> getExpenseDashboard(UUID userId);
	
	Map<String, List<ExpenseItemDTO>> getExpenseItems(UUID userId,Date startDate,Date endDate,Date startMonth);
}
