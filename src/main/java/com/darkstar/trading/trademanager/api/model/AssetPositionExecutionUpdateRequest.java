package com.darkstar.trading.trademanager.api.model;

public class AssetPositionExecutionUpdateRequest {

	private Long item;
	private String asset;
	private Double price;
	private Double quantity;

	public AssetPositionExecutionUpdateRequest() {	}
	public AssetPositionExecutionUpdateRequest(
			Long item,
			String asset,
			Double price,
			Double quantity) {
		
		this.item = item;
		this.asset = asset;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getItem() {
		return item;
	}
	
	public void setItem(Long item) {
		this.item = item;
	}
	
	public String getAsset() {
		return asset;
	}
	
	public void setAsset(String asset) {
		this.asset = asset;
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
