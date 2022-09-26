package com.darkstar.trading.trademanager.testing.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ticker {

	private Double bid;
	private Double ask;
	private Double last;
	
	@JsonProperty("Bid")
	public Double getBid() {
		return bid;
	}

	public void setBid(Double bid) {
		this.bid = bid;
	}

	@JsonProperty("Ask")
	public Double getAsk() {
		return ask;
	}
	
	public void setAsk(Double ask) {
		this.ask = ask;
	}
	
	@JsonProperty("Last")
	public Double getLast() {
		return last;
	}
	
	public void setLast(Double last) {
		this.last = last;
	}
}
