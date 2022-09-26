package com.darkstar.trading.trademanager.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssetPositionSummary {

	private String id;
	private String asset;
	private Double invested;
	private Double value;
	private Double buyOrders;
	private Double price;
	
	public AssetPositionSummary(
			String id,
			String asset, 
			Double invested,
			Double value,
			Double buyOrders,
			Double price) {
		
		this.id = id;
		this.asset = asset;
		this.invested = invested;
		this.value = value;
		this.buyOrders = buyOrders;
		this.price = price;
	}
	
	public String getAsset() {
		return asset;
	}
	
	public void setAsset(String asset) {
		this.asset = asset;
	}
	
	public Double getInvested() {
		return invested;
	}
	
	public void setInvested(Double invested) {
		this.invested = invested;
	}
	
	public Double getValue() {
		return value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}
	
	@JsonProperty("buy_orders")
	public Double getBuyOrders() {
		return buyOrders;
	}
	
	public void setBuyOrders(Double buyOrders) {
		this.buyOrders = buyOrders;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
