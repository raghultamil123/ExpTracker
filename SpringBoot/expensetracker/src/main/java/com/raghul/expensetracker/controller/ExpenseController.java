package com.raghul.expensetracker.controller;

import java.sql.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/available-expenses")
	public ResponseEntity<?> getExpenses(){
		return ResponseEntity.ok(expenseService.getAllExpense());
	}
	
	@PostMapping("/save-expense")
	public ResponseEntity<?> postExpense(@RequestBody ExpenseDTO expenseDTO  ){
		expenseService.saveExpense(expenseDTO);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/expense-details")
	public ResponseEntity<?> getExpenseDetails(@RequestParam("expenseId") UUID expenseId ){
	
		return ResponseEntity.ok(expenseService.getExpenseDetails(expenseId));
	}
	
	@GetMapping("/expense-items")
	public ResponseEntity<?> getExpenseItems(){
		return ResponseEntity.ok(expenseService.getExpenseItems());
		
	}
	
	@GetMapping("/dashboard")
	public ResponseEntity<?> getExpenseDashboard(){
		return ResponseEntity.ok(expenseService.getExpenseDashboard());
	}
	
	@GetMapping("/expenses-items")
	public ResponseEntity<?> getExpensesItems(@RequestParam(value="startDate",required=false) Date startDate,
			@RequestParam(value="endDate",required=false) Date endDate,@RequestParam(value="startMonth",required=false) Date startMonth ){
		return ResponseEntity.ok(expenseService.getExpenseItems(startDate, endDate, startMonth));
	}
	
	
	

}
