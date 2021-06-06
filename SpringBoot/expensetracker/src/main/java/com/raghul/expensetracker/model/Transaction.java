package com.raghul.expensetracker.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="transaction")
public class Transaction extends BaseModel{
	
	@Id
	@Column(name="transaction_id")
	@Type(type="uuid-char")
	private UUID transactionId;
	@Column(name="amount")
	private String amount;
	@Column(name="money_status")
	private String moneyStatus;
	@Column(name="note")
	private String note;
	@Column(name="recipient")
	private String recipient;
	@Column(name="money_from_bank")
	private String moneyFromBank;
	@Column(name="user_id")
	@Type(type="uuid-char")
	private UUID userId;
	public UUID getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
	}
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
	public String getMoneyFromBank() {
		return moneyFromBank;
	}
	public void setMoneyFromBank(String moneyFromBank) {
		this.moneyFromBank = moneyFromBank;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	
	
		

}
