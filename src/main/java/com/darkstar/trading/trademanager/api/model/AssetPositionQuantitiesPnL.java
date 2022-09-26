package com.darkstar.trading.trademanager.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssetPositionQuantitiesPnL {

	private Double netQuantity;
	private Integer percentageProfitLoss;
	private Double amountProfitLoss;
	
	public AssetPositionQuantitiesPnL(
			Double netQuantity,
			Integer percentageProfitLoss, 
			Double amountProfitLoss) {
		
		this.netQuantity = netQuantity;
		this.percentageProfitLoss = percentageProfitLoss;
		this.amountProfitLoss = amountProfitLoss;
	}
	
	@JsonProperty("net_quantity")
	public Double getNetQuantity() {
		return netQuantity;
	}
	
	public void setNetQuantity(Double netQuantity) {
		this.netQuantity = netQuantity;
	}
	
	@JsonProperty("percentage_profit_loss")
	public Integer getPercentageProfitLoss() {
		return percentageProfitLoss;
	}
	
	public void setPercentageProfitLoss(Integer percentageProfitLoss) {
		this.percentageProfitLoss = percentageProfitLoss;
	}
	
	@JsonProperty("amount_profit_loss")
	public Double getAmountProfitLoss() {
		return amountProfitLoss;
	}
	
	public void setAmountProfitLoss(Double amountProfitLoss) {
		this.amountProfitLoss = amountProfitLoss;
	}
}
