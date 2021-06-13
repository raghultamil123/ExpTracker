package com.raghul.expensetracker.translator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.raghul.expensetracker.dto.ExpenseDTO;
import com.raghul.expensetracker.dto.ExpenseItemDTO;
import com.raghul.expensetracker.model.Expense;
import com.raghul.expensetracker.model.ExpenseItem;

@Component
public class ExpenseTranslator {
	
	public Expense translateToExpense(ExpenseDTO expenseDTO) {
		Expense expense = new Expense();
		UUID expenseId = Optional.ofNullable(expenseDTO.getExpenseId()).map(UUID::fromString).orElse(UUID.randomUUID());
		expense.setExpenseId(expenseId);
		expense.setExpenseName(
				expenseDTO.getExpenseName()
				);
		
		return expense;
	}
	
	public List<ExpenseItem> translateToExpenseItems(List<ExpenseItemDTO> expenseItems,UUID expenseId){
		expenseItems = Optional.ofNullable(expenseItems).orElse(Collections.emptyList());
		if(!expenseItems.isEmpty()) {
			
			List<ExpenseItem> items = new ArrayList<>();
			expenseItems.forEach(  itemDTO->{
				items.add(translateToExpenseItem(itemDTO,expenseId));

			});
			return items;
			
		}
		return Collections.emptyList();
	}
	
	public ExpenseItem translateToExpenseItem(ExpenseItemDTO expenseItemDTO,UUID expenseId) {
		ExpenseItem expenseItem = new ExpenseItem();
		UUID expenseItemId = Optional.ofNullable(expenseItemDTO.getExpenseItemId()).map(UUID::fromString)
				.orElse(UUID.randomUUID());
		expenseItem.setExpenseItemId(expenseItemId);
		expenseItem.setExpenseItem(expenseItemDTO.getExpenseItemName());
		expenseItem.setExpenseId(expenseId);
		expenseItem.setPrice(expenseItemDTO.getExpenseItemPrice());
		expenseItem.setQuantity(expenseItemDTO.getExpenseItemQuantity());
		return expenseItem;
	}

	public List<ExpenseDTO> translateToExpenseDTOs(List<Expense> expenses,
			Map<UUID, List<ExpenseItem>> expenseItemMap) {
		
		if(!expenses.isEmpty()) {
			List<ExpenseDTO> expenseDTOs = new ArrayList<>();
			expenses.forEach( expense->{
				expenseDTOs.add(translateToExpenseDTO(expense,expenseItemMap));
			});
			return expenseDTOs;
		}
		
		
		return Collections.emptyList();
	}

	public ExpenseDTO translateToExpenseDTO(Expense expense, Map<UUID, List<ExpenseItem>> expenseItemMap) {
		ExpenseDTO expenseDTO = new ExpenseDTO();
		expenseDTO.setExpenseName(expense.getExpenseName());
		expenseDTO.setExpenseId(expense.getExpenseId().toString());
		List<ExpenseItem> expenseItems = Optional.ofNullable(expenseItemMap.get(expense.getExpenseId())).orElse(Collections.emptyList());
		if(!expenseItems.isEmpty()) {
			expenseDTO.setExpenseItems(translateToExpenseItems(expense.getExpenseId(),expenseItems));
		}
		return expenseDTO;
	}

	private List<ExpenseItemDTO> translateToExpenseItems(UUID expenseId, List<ExpenseItem> expenseItems) {
		if(!expenseItems.isEmpty()) {
			List<ExpenseItemDTO> expenseItemDTOs = new ArrayList<>();
			expenseItems.forEach(  expenseItem->{
				expenseItemDTOs.add(translateToExpenseItem(expenseId,expenseItem));
			});
			return expenseItemDTOs;
		}
		return Collections.emptyList();
	}

	private ExpenseItemDTO translateToExpenseItem(UUID expenseId, ExpenseItem expenseItem) {
		
		ExpenseItemDTO itemDTO = new ExpenseItemDTO();
		itemDTO.setExpenseItemName(expenseItem.getExpenseItem());
		itemDTO.setExpenseItemId(expenseItem.getExpenseItemId().toString());
		return itemDTO;
	}
	
	public List<ExpenseItemDTO> translateToExpenseItemDTOs(List<ExpenseItem> expenseItems){
	   if(!expenseItems.isEmpty()) {
		   List<ExpenseItemDTO> itemsDTO = new ArrayList<>();
		   expenseItems.forEach( expenseItem->{
			   itemsDTO.add(translateToExpenseItemDTO(expenseItem));
		   });
		   return itemsDTO;
	   }
	   return Collections.emptyList();
	}
	
	public ExpenseItemDTO translateToExpenseItemDTO(ExpenseItem expenseItem) {
		ExpenseItemDTO itemDTO = new ExpenseItemDTO();
		itemDTO.setExpenseItemName(expenseItem.getExpenseItem());
		itemDTO.setExpenseItemPrice(expenseItem.getPrice());
		itemDTO.setExpenseItemQuantity(expenseItem.getQuantity());
		return itemDTO;
	}
	
	
	
	

}
