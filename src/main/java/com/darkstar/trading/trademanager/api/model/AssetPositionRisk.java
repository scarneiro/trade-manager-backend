package com.darkstar.trading.trademanager.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssetPositionRisk {

	private Double averagePrice;
	private Float riskPercentage;
	private Double maxSizeBTC;
	private Double maxSize;
	
	public AssetPositionRisk(
			Double averagePrice,
			Float riskPercentage,
			Double maxSizeBTC,
			Double maxSize) {
		
		this.averagePrice = averagePrice;
		this.riskPercentage = riskPercentage;
		this.maxSizeBTC = maxSizeBTC;
		this.maxSize = maxSize;
	}
	
	@JsonProperty("average_price")
	public Double getAveragePrice() {
		return averagePrice;
	}
	
	public void setAveragePrice(Double averagePrice) {
		this.averagePrice = averagePrice;
	}
	
	@JsonProperty("risk_percentage")
	public Float getRiskPercentage() {
		return riskPercentage;
	}
	
	public void setRiskPercentage(Float riskPercentage) {
		this.riskPercentage = riskPercentage;
	}
	
	@JsonProperty("max_size_btc")
	public Double getMaxSizeBTC() {
		return maxSizeBTC;
	}
	
	public void setMaxSizeBTC(Double maxSizeBTC) {
		this.maxSizeBTC = maxSizeBTC;
	}
	
	@JsonProperty("max_size")
	public Double getMaxSize() {
		return maxSize;
	}
	
	public void setMaxSize(Double maxSize) {
		this.maxSize = maxSize;
	}
}
