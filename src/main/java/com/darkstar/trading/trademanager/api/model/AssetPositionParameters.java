package com.darkstar.trading.trademanager.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssetPositionParameters {

	private Double capital = 0D;
	private Float risk = 0.0F;
	private Double entryPrice = 0D;
	private Float feePercentage = 0.0F;
	private Double positionSizeBTC = 0D;
	private Double positionSize = 0D;
	
	public AssetPositionParameters(
			Double capital,
			Float risk,
			Double entryPrice,
			Float feePercentage,
			Double positionSizeBTC,
			Double positionSize) {
		
		this.capital = capital;
		this.risk = risk;
		this.entryPrice = entryPrice;
		this.feePercentage = feePercentage;
		this.positionSizeBTC = positionSizeBTC;
		this.positionSize = positionSize;
	}
	
	public Double getCapital() {
		return capital;
	}
	
	public void setCapital(Double capital) {
		this.capital = capital;
	}
	
	public Float getRisk() {
		return risk;
	}
	
	public void setRisk(Float risk) {
		this.risk = risk;
	}
	
	@JsonProperty("entry_price")
	public Double getEntryPrice() {
		return entryPrice;
	}
	
	public void setEntryPrice(Double entryPrice) {
		this.entryPrice = entryPrice;
	}
	
	@JsonProperty("fee_percentage")
	public Float getFeePercentage() {
		return feePercentage;
	}
	
	public void setFeePercentage(Float feePercentage) {
		this.feePercentage = feePercentage;
	}
	
	@JsonProperty("position_size_btc")
	public Double getPositionSizeBTC() {
		return positionSizeBTC;
	}
	
	public void setPositionSizeBTC(Double positionSizeBTC) {
		this.positionSizeBTC = positionSizeBTC;
	}
	
	@JsonProperty("position_size")
	public Double getPositionSize() {
		return positionSize;
	}
	
	public void setPositionSize(Double positionSize) {
		this.positionSize = positionSize;
	}
}
