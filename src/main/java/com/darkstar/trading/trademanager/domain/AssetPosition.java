package com.darkstar.trading.trademanager.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="AssetPosition")
public class AssetPosition {

	@Id
	private String id;
	private String asset;
	private Double buyOrders;
	private List<ExecutedOrder> executions;
	private PositionParameters parameters;
	
	public AssetPosition(String id,
			String asset,
			List<ExecutedOrder> executions,
			PositionParameters positionParameters) {
		
		this.id = id;
		this.asset = asset;
		this.executions = executions;
		this.parameters = positionParameters;
	}

	public AssetPosition() {}

	public String getAsset() {
		return asset;
	}
	
	public void setAsset(String asset) {
		this.asset = asset;
	}
	
	public PositionParameters getParameters() {
		return parameters;
	}

	public void setParameters(PositionParameters parameters) {
		this.parameters = parameters;
	}

	
	public List<ExecutedOrder> getExecutions() {
		return executions;
	}

	public void setExecutions(List<ExecutedOrder> executions) {
		this.executions = executions;
	}

	
	public Double getBuyOrders() {
		return buyOrders;
	}

	public void setBuyOrders(Double buyOrders) {
		this.buyOrders = buyOrders;
	}

	public String getId() {
		return id;
	}
	
	public List<CalculatedOrder> calculateOrders(int size) {
		
		List<CalculatedOrder> orders = new ArrayList<CalculatedOrder>();
		
		double wkprice = this.calculateAveragePrice();
		double wksize = this.calculateBoughtQuantities();
		
		for (int i = 0; i < size; i++) {
	
			// TODO manage order calculation via strategies.
			orders.add(new CalculatedOrder(wkprice * 2, wkprice * 2 * (1 + parameters.getFeePercentage() / 100), wksize / 2));
			wkprice *= 2;
			wksize /= 2;
		}
		
		return orders;
	}
	
	public Double calculateMaxSizeInBTC() {
		
		return this.getParameters().getCapital() * this.getParameters().getRisk();
	}
	
	public Double calculateMaxSize() {
		
		return this.calculateMaxSizeInBTC() / this.calculateAveragePrice();
	}

	public Double calculateBuysBalance() {
		
		double balance = 0;
		for (ExecutedOrder execution: this.executions) {
			if (execution.getOperation().equals(OperationType.Buy)) {
				balance += execution.calculateBalance(this.getParameters().getFeePercentage());
			}
		}
		
		return balance;
	}

	public Double calculateSellsBalance() {
		
		double balance = 0;
		for (ExecutedOrder execution: this.executions) {
			if (execution.getOperation().equals(OperationType.Sell)) {
				balance += execution.calculateBalance(this.getParameters().getFeePercentage());
			}
		}
		
		return balance;
	}

	public Double calculateBoughtQuantities() {
		
		double quantities = 0;
		
		for (ExecutedOrder execution: this.executions) {
			if (execution.getOperation().equals(OperationType.Buy)) {
				quantities += execution.getQuantity();
			}
		}
		
		return quantities;
	}

	public Double calculateSoldQuantities() {
		
		double quantities = 0;
		
		for (ExecutedOrder execution: this.executions) {
			if (execution.getOperation().equals(OperationType.Sell)) {
				quantities += execution.getQuantity();
			}
		}
		
		return quantities;
	}

	public Double calculateNetQuantities() {
		
		return calculateBoughtQuantities() - calculateSoldQuantities();
	}
	
	public Double calculateNetBalance() {
		
		return calculateSellsBalance() - calculateBuysBalance();
	}
	
	public Double calculateAmountInvested() {
		
		Double buysBalance = calculateBuysBalance();
		Double sellsBalance = calculateSellsBalance();
		
		return sellsBalance < buysBalance ? buysBalance - sellsBalance : 0;
	}
		
	public Double calculateAveragePrice() {
		
		return calculateBuysBalance() / calculateBoughtQuantities();
	}
	
	public Double calculateValue() {
		
		return calculateBoughtQuantities() * calculateAveragePrice();
	}
	
	public Double calculateProfitPercentage() {
		
		return this.calculateNetBalance() / this.calculateBuysBalance() * 100; 
	}
	
	public void addExecution(
			OperationType type, 
			Double quantity,
			Double price) {
		
		this.executions.add(new ExecutedOrder(
				Long.valueOf(executions.size() + 1),
				type,
				quantity,
				price));
	}
	
	public ExecutedOrder getExecution(Long itemId) {
		
		for (ExecutedOrder execution: this.executions) {
			
			if (execution.getItem().equals(itemId))
				return execution;
		}
		
		return null;
	}
	
	public ExecutedOrder updateExecution(Long item, Double quantity, Double price) {
		
		ExecutedOrder order = this.getExecution(item);
		
		order.setQuantity(quantity);
		order.setPrice(price);
		
		return order;
	}
	
	public ExecutedOrder deleteExecution(Long item) {
		
		ExecutedOrder order = this.getExecution(item);
		
		this.executions.remove(order);
		
		return order;
	}
}
