package com.darkstar.trading.trademanager.exchange.bittrex.domain;

public class BittrexResult {

	private Boolean success = null;
	private String message = null;
	
	public Boolean getSuccess() {
		return success;
	}
	
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
