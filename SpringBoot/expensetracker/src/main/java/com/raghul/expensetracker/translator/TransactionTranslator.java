package com.raghul.expensetracker.translator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.raghul.expensetracker.dto.RefTermDTO;
import com.raghul.expensetracker.dto.TransactionDTO;
import com.raghul.expensetracker.model.Transaction;

@Component
public class TransactionTranslator {
	
	
	public Transaction translateToTransaction(TransactionDTO transactionDTO) {
		Transaction transaction = new Transaction();
		transaction.setTransactionId(UUID.randomUUID());
		transaction.setMoneyStatus(transactionDTO.getMoneyStatus());
		transaction.setAmount(transactionDTO.getAmount());
		transaction.setMoneyFromBank(transactionDTO.getMoneyFromBank());
		transaction.setNote(transactionDTO.getNote());
		transaction.setRecipient(transactionDTO.getRecipient());
		transaction.setUserId(UUID.fromString(transactionDTO.getUserId()));
		return transaction;
	}
	
	public TransactionDTO translateToTransactionDTO(Transaction transaction) {
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setAmount(transaction.getAmount());
		transactionDTO.setNote(transaction.getNote());
		transactionDTO.setUserId(transaction.getUserId().toString());
		transactionDTO.setMoneyStatus(transaction.getMoneyStatus());
		transactionDTO.setMoneyFromBank(transaction.getMoneyFromBank());
		return transactionDTO;
	}
	
	public List<TransactionDTO> translateToTransactionDTOs(List<Transaction> transactions){
		if(transactions!=null && !transactions.isEmpty()) {
			List<TransactionDTO> transactionDTOs = new ArrayList<>();
			transactions.forEach(
					transaction->{
						transactionDTOs.add(translateToTransactionDTO(transaction));
					}
					);
			return transactionDTOs;
		}
		return Collections.emptyList();
	}
	
	public void addFromBankFilter(Map<String,List<RefTermDTO>> values,List<Transaction> transactions) {
		Set<String> availableBank = transactions.stream().map(Transaction::getMoneyFromBank)
				.collect(Collectors.toSet());
		List<RefTermDTO> fromBanks = new ArrayList<>();
		String name ="bank";
		availableBank.forEach( str->{
			RefTermDTO refTermDTO = new RefTermDTO();
			refTermDTO.setName(str);
			fromBanks.add(refTermDTO);
			
		});
		
		values.put(name, fromBanks);
		
	}
	
	public void addMoneyStatusFilter(Map<String,List<RefTermDTO>> values,List<Transaction> transactions) {
		Set<String> status = transactions.stream().
				map(Transaction::getMoneyStatus).collect(Collectors.toSet());
		String name="status";
		List<RefTermDTO> statues = new ArrayList<>();
		status.forEach( str->{
			RefTermDTO refTermDTO = new RefTermDTO();
			refTermDTO.setName(str);
			statues.add(refTermDTO);
			
		});
		
		values.put(name, statues);


		
	}

}
