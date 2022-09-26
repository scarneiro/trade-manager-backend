package com.darkstar.trading.trademanager.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssetPositionOrder {

	private Double targetPrice;
	private Double incrementedPrice;
	private Double targetSize;
	
	public AssetPositionOrder(
			Double targetPrice, 
			Double incrementedPrice,
			Double targetSize) {
		
		this.targetPrice = targetPrice;
		this.incrementedPrice = incrementedPrice;
		this.targetSize = targetSize;
	}
	
	@JsonProperty("target_price")
	public Double getTargetPrice() {
		return targetPrice;
	}
	
	public void setTargetPrice(Double targetPrice) {
		this.targetPrice = targetPrice;
	}
	
	@JsonProperty("incremented_price")
	public Double getIncrementedPrice() {
		return incrementedPrice;
	}
	
	public void setIncrementedPrice(Double incrementedPrice) {
		this.incrementedPrice = incrementedPrice;
	}
	
	@JsonProperty("target_size")
	public Double getTargetSize() {
		return targetSize;
	}
	
	public void setTargetSize(Double targetSize) {
		this.targetSize = targetSize;
	}
}
