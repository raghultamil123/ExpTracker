package com.raghul.expensetracker.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="expense_item")
public class ExpenseItem extends BaseModel{

	@Id
	@Type(type="uuid-char")
	@Column(name="expense_item_id")
	private UUID expenseItemId;
	@Column(name="expense_item")
	private String expenseItem;
	@Column(name="expense_id")
	@Type(type="uuid-char")
	private UUID expenseId;
	@Column(name="price")
	private Integer price;
	@Column(name="quantity")
	private Integer quantity;
	@Column(name="userId")
	@Type(type="uuid-char")
	private UUID userId;
	public UUID getExpenseItemId() {
		return expenseItemId;
	}
	public void setExpenseItemId(UUID expenseItemId) {
		this.expenseItemId = expenseItemId;
	}
	public String getExpenseItem() {
		return expenseItem;
	}
	public void setExpenseItem(String expenseItem) {
		this.expenseItem = expenseItem;
	}
	public UUID getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(UUID expenseId) {
		this.expenseId = expenseId;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	
	
	
	
	
	
	
}
