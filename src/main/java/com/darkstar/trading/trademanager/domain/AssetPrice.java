package com.darkstar.trading.trademanager.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="AssetPrice")
public class AssetPrice {

	@Id
	private String id;
	private String asset;
	private Double bidPrice;
	private Double askPrice;
	private Double lastPrice;
	
	public AssetPrice() {	}
	
	public AssetPrice(String asset) {
		
		this.asset = asset;
	}
	
	public String getId() {
		return id;
	}
	
	public String getAsset() {
		return asset;
	}
	
	public void setAsset(String asset) {
		this.asset = asset;
	}
	
	public Double getBidPrice() {
		return bidPrice;
	}
	
	public void setBidPrice(Double bidPrice) {
		this.bidPrice = bidPrice;
	}
	
	public Double getAskPrice() {
		return askPrice;
	}
	
	public void setAskPrice(Double askPrice) {
		this.askPrice = askPrice;
	}

	public Double getLastPrice() {
		return lastPrice;
	}
	
	public void setLastPrice(Double lastPrice) {
		this.lastPrice = lastPrice;
	}
}
