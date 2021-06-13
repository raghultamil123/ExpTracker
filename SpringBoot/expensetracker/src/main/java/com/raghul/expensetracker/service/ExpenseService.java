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

	void saveExpense(ExpenseDTO expenseDTO);
	
	List<ExpenseDTO> getAllExpense();
	
	ExpenseDTO getExpenseDetails(UUID expenseId);
	
	ExpenseItemResponseDTO getExpenseItems();
	
	Map<String,String> getExpenseDashboard();
	
	List<ExpenseItemDTO> getExpenseItems(Date startDate,Date endDate,Date startMonth);
}
