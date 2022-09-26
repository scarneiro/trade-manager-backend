package com.darkstar.trading.trademanager.domain;

public class CalculatedOrder {

	private Double targetPrice;
	private Double incrementedPrice;
	private Double targetSize;
	
	public CalculatedOrder(
			Double targetPrice, 
			Double incrementedPrice,
			Double targetSize) {
		
		this.targetPrice = targetPrice;
		this.incrementedPrice = incrementedPrice;
		this.targetSize = targetSize;
	}
	
	public Double getTargetPrice() {
		return targetPrice;
	}
	
	public void setTargetPrice(Double targetPrice) {
		this.targetPrice = targetPrice;
	}
	
	public Double getIncrementedPrice() {
		return incrementedPrice;
	}
	
	public void setIncrementedPrice(Double incrementedPrice) {
		this.incrementedPrice = incrementedPrice;
	}
	
	public Double getTargetSize() {
		return targetSize;
	}
	
	public void setTargetSize(Double targetSize) {
		this.targetSize = targetSize;
	}
}
