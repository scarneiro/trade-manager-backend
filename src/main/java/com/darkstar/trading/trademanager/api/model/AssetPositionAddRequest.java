package com.darkstar.trading.trademanager.api.model;

public class AssetPositionAddRequest {

	private String asset;
	private Double price;
	private Double quantity;

	// TODO add chance to edit defaults for parameters.
//	private Double capital;
//	private Float risk;
//	private Float feePercentage;

	public AssetPositionAddRequest() {	}
	public AssetPositionAddRequest(
			String asset,
			Double price,
			Double quantity,
			Double capital,
			Float risk,
			Float feePercentage) {
		
		this.asset = asset;
		this.price = price;
		this.quantity = quantity;
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
