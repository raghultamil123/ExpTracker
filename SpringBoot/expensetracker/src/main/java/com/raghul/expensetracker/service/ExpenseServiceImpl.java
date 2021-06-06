package com.raghul.expensetracker.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.raghul.expensetracker.dto.ExpenseDTO;
import com.raghul.expensetracker.dto.ExpenseItemDTO;
import com.raghul.expensetracker.dto.ExpenseItemResponseDTO;
import com.raghul.expensetracker.model.Expense;
import com.raghul.expensetracker.model.ExpenseItem;
import com.raghul.expensetracker.repository.ExpenseItemRepository;
import com.raghul.expensetracker.repository.ExpenseRepository;
import com.raghul.expensetracker.translator.ExpenseTranslator;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Resource
	private ExpenseTranslator expenseTranslator;

	@Resource
	private ExpenseRepository expenseRepository;
	
	@Resource
	private ExpenseItemRepository expenseItemRepository;
	
	
	@Override
	public void saveExpense(ExpenseDTO expenseDTO) {
		Expense expense = expenseTranslator.translateToExpense(expenseDTO);
		UUID expenseId = expenseRepository.save(expense).getExpenseId();
		List<ExpenseItem> expenseItems = expenseTranslator.translateToExpenseItems(expenseDTO.getExpenseItems(), expenseId);
		expenseItemRepository.saveAll(expenseItems);
		
	}


	@Override
	public List<ExpenseDTO> getAllExpense() {
		
		List<Expense> expenses = expenseRepository.findAll();
		List<UUID> expenseIds = expenses.stream().map(Expense::getExpenseId).collect(Collectors.toList());
		List<ExpenseItem> expenseItems = expenseItemRepository.findByExpenseIdIn(expenseIds);
		Map<UUID,List<ExpenseItem>> expenseItemMap = new HashMap<>();
		expenseItems.forEach( expenseItem->{
			
			if(expenseItemMap.containsKey(expenseItem.getExpenseId())){
				expenseItemMap.get(expenseItem.getExpenseId()).add(expenseItem);
			}else {
				expenseItemMap.put(expenseItem.getExpenseId(), new ArrayList<>());
				expenseItemMap.get(expenseItem.getExpenseId()).add(expenseItem);
			}
		});
		
		List<ExpenseDTO> expenseDTOs = expenseTranslator.translateToExpenseDTOs(expenses,expenseItemMap); 
		
		return expenseDTOs;
	}


	@Override
	public ExpenseDTO getExpenseDetails(UUID expenseId) {
		Expense expense = expenseRepository.findByExpenseId(expenseId);
		List<ExpenseItem> expenseItems = expenseItemRepository.findByExpenseId(expenseId);
		Map<UUID,List<ExpenseItem>> expenseItemMap = new HashMap<>();
        expenseItemMap.put(expenseId, expenseItems);
		return expenseTranslator.translateToExpenseDTO(expense, expenseItemMap);
	}


	@Override
	public ExpenseItemResponseDTO getExpenseItems() {
		List<ExpenseItem> expenseItems = expenseItemRepository.findAll();
		List<ExpenseItemDTO> expenseItemsDTO = expenseTranslator.translateToExpenseItemDTOs(expenseItems);
		Integer priceTotal = expenseItems.stream().map( item->item.getPrice() * item.getQuantity())
				.collect(Collectors.summingInt(Integer::intValue));
		ExpenseItemResponseDTO expenseItemResponseDTO = new ExpenseItemResponseDTO();
		expenseItemResponseDTO.setExpenseItems(expenseItemsDTO);
		expenseItemResponseDTO.setExpenseItemsTotal(priceTotal);
		return expenseItemResponseDTO;
	}


	@Override
	public Map<String, String> getExpenseDashboard() {
		
		Map<String,String> dashboardMap = new HashMap<>();
		dashboardMap.put("expenseGroup", String.valueOf(expenseRepository.count()));
		dashboardMap.put("expenseItem", String.valueOf(expenseItemRepository.count()));

		return dashboardMap;
	}

	
}
