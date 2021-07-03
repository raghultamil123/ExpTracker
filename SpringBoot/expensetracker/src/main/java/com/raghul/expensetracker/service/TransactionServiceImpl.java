package com.raghul.expensetracker.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.raghul.expensetracker.dto.RefTermDTO;
import com.raghul.expensetracker.dto.TransactionDTO;
import com.raghul.expensetracker.model.Transaction;
import com.raghul.expensetracker.repository.TransactionRepository;
import com.raghul.expensetracker.translator.TransactionTranslator;

@Component
public class TransactionServiceImpl implements TransactionService{
	
	
	@Resource
	private TransactionTranslator transactionTranslator;
	
	@Resource
	private TransactionRepository transactionRepository;

	@Override
	public void saveTransaction(TransactionDTO transactionDTO) {
		Transaction transaction = transactionTranslator.translateToTransaction(transactionDTO);
		transactionRepository.save(transaction);
	}

	@Override
	public List<TransactionDTO> getTransactions(List<String> bankNames,List<String> status,UUID userId) {

		bankNames = Optional.ofNullable(bankNames).orElse(Collections.emptyList());
		status = Optional.ofNullable(status).orElse(Collections.emptyList());
		List<Transaction> transactions = getTransactionsList(bankNames, status,userId);
        transactions = Optional.ofNullable(transactions).orElse(Collections.emptyList());	
		return transactionTranslator.translateToTransactionDTOs(transactions);
	}
	
	private List<Transaction> getTransactionsList(List<String> bankNames,List<String> status,UUID userId){
		if(!bankNames.isEmpty() && !status.isEmpty()) {
			return transactionRepository.findByMoneyFromBankInAndMoneyStatusInAndUserId(bankNames, status,userId).get();
		}
		else if(!bankNames.isEmpty() && status.isEmpty()) {
			return transactionRepository.findByMoneyFromBankInAndUserId(bankNames,userId).get();
		}else if(bankNames.isEmpty() && !status.isEmpty()) {
			return transactionRepository.findByMoneyStatusInAndUserId(status,userId).get();
		}else {
			return transactionRepository.findByUserId(userId).get();
		}
	}

	@Override
	public Map<String, List<RefTermDTO>> getTransactionFilter(UUID userId) {
		List<Transaction> transactions = transactionRepository.findByUserId(userId)
				.orElse(Collections.emptyList());
		Map<String,List<RefTermDTO>> filters = new HashMap<>();
	
		if(!transactions.isEmpty()) {
			transactionTranslator.addFromBankFilter(filters, transactions);
			transactionTranslator.addMoneyStatusFilter(filters, transactions);
		}
		return filters;
	}
	
	
	
	

}
