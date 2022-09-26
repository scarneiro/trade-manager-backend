package com.darkstar.trading.trademanager.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="WalletBalance")
public class WalletBalance {

	@Id
	private String id = null;
	private String exchange = null;
	private Double balance = null;
	
	public WalletBalance() {}
	
	public WalletBalance(String exchange, Double balance) {
		
		this.exchange = exchange;
		this.balance = balance;
	}
	
	public String getExchange() {
		return exchange;
	}
	
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public String getId() {
		return id;
	}
}
