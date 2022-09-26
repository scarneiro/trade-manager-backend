package com.darkstar.trading.trademanager.api.model;

public class AssetPositionExecution {

	private Long item;
	private String operation;
	private Double quantity;
	private Double price;
	private Double amount;
	private Double fee;
	private Double balance;
	
	public AssetPositionExecution(
			Long item,
			String operation,
			Double quantity,
			Double price,
			Double amount,
			Double fee,
			Double balance) {

		this.item = item;
		this.operation = operation;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
		this.fee = fee;
		this.balance = balance;
	}
	
	public String getOperation() {
		return operation;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public Double getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public Double getFee() {
		return fee;
	}
	
	public void setFee(Double fee) {
		this.fee = fee;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Long getItem() {
		return item;
	}

	public void setItem(Long item) {
		this.item = item;
	}
}
