package com.raghul.expensetracker.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raghul.expensetracker.dto.ExpenseDTO;
import com.raghul.expensetracker.dto.ExpenseItemDTO;
import com.raghul.expensetracker.dto.UserDTO;

@Service
public class MiscServiceImpl implements MiscService{
	
	@Resource
	private UserService userService;
	
	@Resource
	private ResourceLoader resourceLoader;
	
	
	@Resource
	private ExpenseService expenseService;

	@Override
	public void build() throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<UserDTO>> typeReference = new TypeReference<List<UserDTO>>(){};
		InputStream inputStream = resourceLoader.getResource("classpath:user.json").getInputStream();
		List<UserDTO> users = mapper.readValue(inputStream,typeReference);
		users.forEach( user->{
			UserDTO userDTO = userService.createUser(user);
			TypeReference<List<ExpenseDTO>> expenseReference = new TypeReference<List<ExpenseDTO>>(){};
		  InputStream inputStream2 = null;
		try {
			inputStream2 = resourceLoader.getResource("classpath:expense.json").getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			List<ExpenseDTO> expenseDTOs;
			try {
				expenseDTOs = mapper.readValue(inputStream2,expenseReference);
				for(ExpenseDTO expense:expenseDTOs) {
					  expense.setUserId(userDTO.getUserId());
					  for(ExpenseItemDTO items:expense.getExpenseItems()) {
						  items.setUserId(userDTO.getUserId());
					  }
					  expenseService.saveExpense(UUID.fromString(userDTO.getUserId()),expense);
					  
				  }
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}

		  
			
		});
		
		
		
		
	}

}
