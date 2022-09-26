package com.darkstar.trading.trademanager.testing.model;

public class TickerResult extends BittrexResult {

	private Ticker result = new Ticker();

	public Ticker getResult() {
		return result;
	}

	public void setResult(Ticker result) {
		this.result = result;
	}
}
