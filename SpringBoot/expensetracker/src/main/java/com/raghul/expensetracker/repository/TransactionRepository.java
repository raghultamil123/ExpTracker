package com.raghul.expensetracker.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghul.expensetracker.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,UUID>{
	
	Optional<List<Transaction>> findByUserId(UUID userId);
	
	Optional<List<Transaction>> findByMoneyStatusIn(List<String> moneyStatus);
	
	Optional<List<Transaction>> findByMoneyFromBankIn(List<String> bankNames);

	Optional<List<Transaction>> findByMoneyFromBankInAndMoneyStatusIn(List<String> bankNames,List<String> status);

	

}
