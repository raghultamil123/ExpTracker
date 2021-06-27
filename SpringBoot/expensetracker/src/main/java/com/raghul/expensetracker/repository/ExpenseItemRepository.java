package com.raghul.expensetracker.repository;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raghul.expensetracker.model.ExpenseItem;

public interface ExpenseItemRepository extends JpaRepository<ExpenseItem, UUID>{
	
	List<ExpenseItem> findByExpenseIdIn(List<UUID> expenseId);

	List<ExpenseItem> findByExpenseId(UUID expenseId);
	
	@Query("select expenseItem from ExpenseItem expenseItem where date(expenseItem.createdOn) between :startDate and :endDate")
	List<ExpenseItem> findByCreatedOnBetween(Date startDate,Date endDate);
	
	@Query("select expenseItem from ExpenseItem expenseItem where month(expenseItem.createdOn) = month(:startMonth) and userId=:userId")
	List<ExpenseItem> findByUserIdAndCreatedOn(UUID userId,Date startMonth);

	List<ExpenseItem> findByUserId(UUID userId);

	Long countByUserId(UUID userId);

	List<ExpenseItem> findByUserIdAndCreatedOnBetween(UUID userId, Date startDate, Date endDate);

	
	

}
