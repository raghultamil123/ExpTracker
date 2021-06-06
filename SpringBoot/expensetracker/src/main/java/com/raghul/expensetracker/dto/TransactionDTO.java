package com.raghul.expensetracker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class TransactionDTO {
	
	private String amount;
	private String moneyStatus;
	private String note;
	private String recipient;
	private String userId;
	private String moneyFromBank;
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getMoneyStatus() {
		return moneyStatus;
	}
	public void setMoneyStatus(String moneyStatus) {
		this.moneyStatus = moneyStatus;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMoneyFromBank() {
		return moneyFromBank;
	}
	public void setMoneyFromBank(String moneyFromBank) {
		this.moneyFromBank = moneyFromBank;
	}
	
	

}
