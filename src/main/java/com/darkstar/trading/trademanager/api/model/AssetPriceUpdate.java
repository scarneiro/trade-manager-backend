package com.darkstar.trading.trademanager.api.model;

import com.darkstar.trading.trademanager.domain.AssetPrice;

public class AssetPriceUpdate {

	private String asset;
	private Double bid;
	private Double ask;
	private Double last;
	
	public AssetPriceUpdate(AssetPrice price) {
	
		this.asset = price.getAsset();
		this.bid = price.getBidPrice();
		this.ask = price.getAskPrice();
		this.last = price.getLastPrice();
	}
	
	public String getAsset() {
		return asset;
	}
	
	public void setAsset(String asset) {
		this.asset = asset;
	}
	
	public Double getBid() {
		return bid;
	}
	
	public void setBid(Double bid) {
		this.bid = bid;
	}
	
	public Double getAsk() {
		return ask;
	}
	
	public void setAsk(Double ask) {
		this.ask = ask;
	}
	
	public Double getLast() {
		return last;
	}
	
	public void setLast(Double last) {
		this.last = last;
	}
}
