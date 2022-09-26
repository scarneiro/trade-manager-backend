package com.darkstar.trading.trademanager.domain;

public class ExecutedOrder {
	
	private Long item;
	private OperationType operation;
	private Double quantity;
	private Double price;
	
	public ExecutedOrder(
			Long item,
			OperationType operation,
			Double quantity,
			Double price) {
		
		this.item = item;
		this.operation = operation;
		this.quantity = quantity;
		this.price = price;
	}
	
	public OperationType getOperation() {
		return operation;
	}
	
	public void setOperation(OperationType operation) {
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
	
	public Double calculateAmount() {
		
		return price * quantity; 
	}
	
	public Double calculateFee(Float feePercentage) {
		
		return this.calculateAmount() * feePercentage / 100;
	}
	
	public Double calculateBalance(Float feePercentage) {
		
		if (this.operation.equals(OperationType.Buy))
			return calculateAmount() + calculateFee(feePercentage);
		
		return calculateAmount() - calculateFee(feePercentage);
	}

	public Long getItem() {
		return item;
	}

	public void setItem(Long item) {
		this.item = item;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null) return false;
		
		if (! (obj instanceof ExecutedOrder)) return false;
		
		ExecutedOrder otherOrder = (ExecutedOrder) obj;
		
		return this.getItem() == otherOrder.getItem();
	}
}
