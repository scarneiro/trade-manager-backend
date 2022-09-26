package com.darkstar.trading.trademanager.api.model;

public class AssetPositionExecutionAddRequest {

	private String asset;
	private String operation;
	private Double price;
	private Double quantity;

	public AssetPositionExecutionAddRequest() {	}
	public AssetPositionExecutionAddRequest(
			String asset,
			String operation,
			Double price,
			Double quantity) {
		
		this.asset = asset;
		this.operation = operation;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getAsset() {
		return asset;
	}
	
	public void setAsset(String asset) {
		this.asset = asset;
	}
	
	
	public String getOperation() {
		return operation;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
}
