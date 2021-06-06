package com.raghul.expensetracker.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.raghul.expensetracker.dto.RefTermDTO;
import com.raghul.expensetracker.dto.TransactionDTO;

public interface TransactionService {
	
	void saveTransaction(TransactionDTO transactionDTO);
	
	List<TransactionDTO> getTransactions(List<String> bankNames,List<String> status);
	
	Map<String,List<RefTermDTO>> getTransactionFilter(UUID userId);

}
