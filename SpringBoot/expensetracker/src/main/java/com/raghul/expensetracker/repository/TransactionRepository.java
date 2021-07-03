package com.raghul.expensetracker.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghul.expensetracker.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,UUID>{
	
	Optional<List<Transaction>> findByUserId(UUID userId);
	
	Optional<List<Transaction>> findByMoneyStatusInAndUserId(List<String> moneyStatus,UUID userId);
	
	Optional<List<Transaction>> findByMoneyFromBankInAndUserId(List<String> bankNames,UUID userId);

	Optional<List<Transaction>> findByMoneyFromBankInAndMoneyStatusInAndUserId(List<String> bankNames, List<String> status, UUID userId);

	

}
