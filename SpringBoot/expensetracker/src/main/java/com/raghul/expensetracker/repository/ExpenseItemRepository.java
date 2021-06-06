package com.raghul.expensetracker.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghul.expensetracker.model.ExpenseItem;

public interface ExpenseItemRepository extends JpaRepository<ExpenseItem, UUID>{
	
	List<ExpenseItem> findByExpenseIdIn(List<UUID> expenseId);

	List<ExpenseItem> findByExpenseId(UUID expenseId);
	
	

}
