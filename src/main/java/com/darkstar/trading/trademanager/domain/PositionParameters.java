package com.darkstar.trading.trademanager.domain;

import org.springframework.data.mongodb.core.mapping.Field;

public class PositionParameters {

	private Double capital;
	private Float risk;
	private Float feePercentage;
	
	public PositionParameters(
			Double capital, 
			Float risk,
			Float feePercentage) {
	
		this.capital = capital;
		this.risk = risk;
		this.feePercentage = feePercentage;
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
	
	@Field("fee_percentage")
	public Float getFeePercentage() {
		return feePercentage;
	}
	
	public void setFeePercentage(Float feePercentage) {
		this.feePercentage = feePercentage;
	}
}
