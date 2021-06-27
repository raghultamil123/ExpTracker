package com.raghul.expensetracker.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghul.expensetracker.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, UUID> {

	Expense findByExpenseId(UUID expenseId);

	List<Expense> findByUserId(UUID userId);

	Long countByUserId(UUID userId);

}
