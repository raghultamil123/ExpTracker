package com.raghul.expensetracker.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raghul.expensetracker.dto.TransactionDTO;
import com.raghul.expensetracker.service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
@CrossOrigin
public class TransactionController {
	
	@Resource
	private TransactionService transactionService;
	
	
	@PostMapping("/{userId}/save")
	public ResponseEntity<?> saveTransaction(@RequestBody TransactionDTO transactionDTO,
			@PathVariable("userId") UUID userId){
	    transactionDTO.setUserId(userId.toString());
		transactionService.saveTransaction(transactionDTO);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{userId}/available-transaction")
	public ResponseEntity<?> getAllTransactions(@RequestParam(value = "bankNames", required = false) List<String> bankNames,
			@RequestParam(value="statusList",required = false) List<String> status,@PathVariable("userId") UUID userId ){
		return ResponseEntity.ok(transactionService.getTransactions(bankNames,status,userId));
	}
	
	@GetMapping("/{userId}/transaction-filters")
	public ResponseEntity<?> getUserTransactionOptions(@PathVariable("userId") UUID userId){
		return ResponseEntity.ok(transactionService.getTransactionFilter(userId));
	}
	
	
	
	

}
