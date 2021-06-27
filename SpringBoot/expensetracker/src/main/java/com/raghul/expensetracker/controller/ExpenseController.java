package com.raghul.expensetracker.controller;

import java.sql.Date;
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

import com.raghul.expensetracker.dto.ExpenseDTO;
import com.raghul.expensetracker.service.ExpenseService;

@RestController
@RequestMapping("/api/expense")
@CrossOrigin
public class ExpenseController {
	
	@Resource
	private ExpenseService expenseService;
	
	@GetMapping("/{userId}/available-expenses")
	public ResponseEntity<?> getExpenses(@PathVariable("userId") UUID userId ){
		return ResponseEntity.ok(expenseService.getAllExpense(userId));
	}
	
	@PostMapping("/{userId}/save-expense")
	public ResponseEntity<?> postExpense(@PathVariable("userId") UUID userId,@RequestBody ExpenseDTO expenseDTO  ){
		expenseService.saveExpense(userId,expenseDTO);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{userId}/expense-details")
	public ResponseEntity<?> getExpenseDetails(@PathVariable("userId") UUID userId,@RequestParam("expenseId") UUID expenseId ){
	
		return ResponseEntity.ok(expenseService.getExpenseDetails(userId,expenseId));
	}
	
	@GetMapping("/{userId}/expense-items")
	public ResponseEntity<?> getExpenseItems(@PathVariable("userId") UUID userId){
		return ResponseEntity.ok(expenseService.getExpenseItems(userId));
		
	}
	
	@GetMapping("/{userId}/dashboard")
	public ResponseEntity<?> getExpenseDashboard(@PathVariable("userId") UUID userId){
		return ResponseEntity.ok(expenseService.getExpenseDashboard(userId));
	}
	
	@GetMapping("/{userId}/dashboard/expense-items")
	public ResponseEntity<?> getExpensesItems(@PathVariable("userId") UUID userId,@RequestParam(value="startDate",required=false) Date startDate,
			@RequestParam(value="endDate",required=false) Date endDate,@RequestParam(value="startMonth",required=false) Date startMonth ){
		return ResponseEntity.ok(expenseService.getExpenseItems(userId,startDate, endDate, startMonth));
	}
	
	
	

}
