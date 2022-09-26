package com.darkstar.trading.trademanager.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darkstar.trading.trademanager.api.model.AssetPositionAddRequest;
import com.darkstar.trading.trademanager.api.model.AssetPositionExecution;
import com.darkstar.trading.trademanager.api.model.AssetPositionExecutionAddRequest;
import com.darkstar.trading.trademanager.api.model.AssetPositionExecutionUpdateRequest;
import com.darkstar.trading.trademanager.api.model.AssetPositionOrder;
import com.darkstar.trading.trademanager.api.model.AssetPositionParameters;
import com.darkstar.trading.trademanager.api.model.AssetPositionQuantitiesPnL;
import com.darkstar.trading.trademanager.api.model.AssetPositionRisk;
import com.darkstar.trading.trademanager.api.model.AssetPositionSummary;
import com.darkstar.trading.trademanager.db.AssetPositionRepository;
import com.darkstar.trading.trademanager.domain.AssetPosition;
import com.darkstar.trading.trademanager.domain.CalculatedOrder;
import com.darkstar.trading.trademanager.domain.ExecutedOrder;
import com.darkstar.trading.trademanager.domain.OperationType;
import com.darkstar.trading.trademanager.domain.PositionParameters;

@RestController
@RequestMapping("/asset-positions")
@CrossOrigin(origins="http://localhost:4200")
public class AssetPositionManagerController {

	private AssetPositionRepository repository;
	
	@Autowired
	public AssetPositionManagerController(AssetPositionRepository repository) {
		
		this.repository = repository;
	}
	
	@GetMapping
	public List<AssetPositionSummary> getAssetPositions() {

		List<AssetPositionSummary> positions = new ArrayList<AssetPositionSummary>();
		
		for (AssetPosition position: repository.findAll()) {
			
			AssetPositionSummary summary = new AssetPositionSummary(
					position.getId(),
					position.getAsset(),
					position.calculateAmountInvested(),
					position.calculateValue(),
					position.getBuyOrders(),
					position.calculateAveragePrice());
			
			positions.add(summary);
		};
		
		return positions;
	}
	
	// TODO manage errors
	@GetMapping("/{asset}/positionparameters")
	public AssetPositionParameters getPositionParameters(@PathVariable String asset) {
		
		AssetPosition position = repository.getAssetPositionByAsset(asset);
		
		if (position != null) {
	
			return new AssetPositionParameters(
					position.getParameters().getCapital(), 
					position.getParameters().getRisk(), 
					position.calculateAveragePrice(), 
					position.getParameters().getFeePercentage(), 
					position.calculateValue(), position.calculateBoughtQuantities());
		}
		
		return new AssetPositionParameters(0D, 0F, 0D, 0F, 0D, 0D);
	}
	
	// TODO manage order quantity via config and errors.
	@GetMapping("/{asset}/positionorders")
	public List<AssetPositionOrder> getPositionOrders(@PathVariable String asset) {
		
		List<AssetPositionOrder> orders = new ArrayList<AssetPositionOrder>();
		
		AssetPosition position = repository.getAssetPositionByAsset(asset);
		
		if (position != null) {
		
			for (CalculatedOrder cOrder: position.calculateOrders(6)) {
				
				orders.add(new AssetPositionOrder(cOrder.getTargetPrice(), cOrder.getIncrementedPrice(), cOrder.getTargetSize()));
			}
		}
		
		return orders;
	}
	
	// TODO manage errors
	@GetMapping("/{asset}/positionrisk")
	public AssetPositionRisk getPositionRisk(@PathVariable String asset) {
		
		AssetPosition position = repository.getAssetPositionByAsset(asset);
		
		if (position != null) {
			
			return new AssetPositionRisk(
					position.calculateAveragePrice(),
					100F,
					position.calculateMaxSizeInBTC(),
					position.calculateMaxSize());
		}
		
		return null;
	}
	
	// TODO manage errors
	@GetMapping("/{asset}/positionquantities")
	public AssetPositionQuantitiesPnL getPositionQuantitiesPnL(@PathVariable String asset) {
		
		AssetPosition position = repository.getAssetPositionByAsset(asset);
		
		return new AssetPositionQuantitiesPnL(
				position.calculateNetQuantities(), 
				position.calculateProfitPercentage().intValue(), 
				position.calculateNetBalance());
	}
	
	// TODO manager errors
	@GetMapping("/{asset}/positionbuyexecutions")
	public List<AssetPositionExecution> getPositionBuys(@PathVariable String asset) {
		
		List<AssetPositionExecution> buys = new ArrayList<AssetPositionExecution>();
		
		AssetPosition position = repository.getAssetPositionByAsset(asset);
		
		for (ExecutedOrder order: position.getExecutions()) {
			
			if (order.getOperation().equals(OperationType.Buy)) {
				
				buys.add(new AssetPositionExecution(
						order.getItem(),
						order.getOperation().toString(), 
						order.getQuantity(),
						order.getPrice(), 
						order.calculateAmount(), 
						order.calculateFee(position.getParameters().getFeePercentage()), 
						order.calculateBalance(position.getParameters().getFeePercentage())));	
			}
		}
				
		return buys;
	}

	//TODO complete functionality
	@GetMapping("/{asset}/positionsellexecutions")
	public List<AssetPositionExecution> getPositionSells(@PathVariable String asset) {
		
		List<AssetPositionExecution> sells = new ArrayList<AssetPositionExecution>();
		
		AssetPosition position = repository.getAssetPositionByAsset(asset);
		
		for (ExecutedOrder order: position.getExecutions()) {
			
			if (order.getOperation().equals(OperationType.Sell)) {
				
				sells.add(new AssetPositionExecution(
						order.getItem(),
						order.getOperation().toString(), 
						order.getQuantity(),
						order.getPrice(), 
						order.calculateAmount(), 
						order.calculateFee(position.getParameters().getFeePercentage()), 
						order.calculateBalance(position.getParameters().getFeePercentage())));	
			}
		}
				
		return sells;
	}

	// TODO creation code should be in a Spring Service
	@PostMapping
	public AssetPosition createPosition(@RequestBody AssetPositionAddRequest assetPositionRequest) {
		
		
		List<ExecutedOrder> executions = new ArrayList<ExecutedOrder>();
		ExecutedOrder order = new ExecutedOrder(
				1L,
				OperationType.Buy,
				assetPositionRequest.getQuantity(),
				assetPositionRequest.getPrice());
		executions.add(order);
		
		//TODO retrieve these parameters from Config values.
		PositionParameters parameters = new PositionParameters(
						2D, 
						0.025F, 
						0.25F);
		
		return repository.save(
				new AssetPosition(
						null, 
						assetPositionRequest.getAsset(),
						executions,
						parameters));
	}
	
	@PostMapping("/{asset}/executions")
	public AssetPosition createExecution(@PathVariable String asset, 
			@RequestBody AssetPositionExecutionAddRequest request) {
		
		AssetPosition currentPosition = repository.getAssetPositionByAsset(asset);
		
		currentPosition.addExecution(OperationType.valueOf(request.getOperation()),
				request.getQuantity(),
				request.getPrice());
		
		return repository.save(currentPosition);
	}
	
	@GetMapping("/{asset}/executions/{executionItem}")
	public AssetPositionExecution getExecution(
			@PathVariable String asset,
			@PathVariable Long executionItem) {
	
		AssetPosition currentPosition = repository.getAssetPositionByAsset(asset);
		
		// TODO Manage item not found exception.
		ExecutedOrder execution = currentPosition.getExecution(executionItem);
		
		// TODO executions should have a reference to owning position or at least its parameters upon creation.
		// TODO Also, the ExecutedOrder --> AssetPositionExecution translation should be in a Service.
		return new AssetPositionExecution(
				execution.getItem(),
				execution.getOperation().toString(),
				execution.getQuantity(),
				execution.getPrice(),
				execution.calculateAmount(),
				execution.calculateFee(currentPosition.getParameters().getFeePercentage()),
				execution.calculateBalance(currentPosition.getParameters().getFeePercentage()));
	}
	
	@PutMapping("/{asset}/executions/{executionItem}")
	public AssetPosition updateExecution(
			@PathVariable String asset,
			@PathVariable Long executionItem,
			@RequestBody AssetPositionExecutionUpdateRequest updateRequest) {
		
		AssetPosition currentPosition = repository.getAssetPositionByAsset(asset);
		
		currentPosition.updateExecution(executionItem, updateRequest.getQuantity(), updateRequest.getPrice());
		repository.save(currentPosition);
		
		return currentPosition;
	}

	@DeleteMapping("/{asset}/executions/{item}")
	public void deleteExecution(@PathVariable String asset, @PathVariable Long item) {
		
		AssetPosition currentPosition = repository.getAssetPositionByAsset(asset);
		
		currentPosition.deleteExecution(item);
		repository.save(currentPosition);
	}
	
	// TODO delete assets by Asset.
	@DeleteMapping("/{id}")
	public void deletePosition(@PathVariable String id) {
		
		repository.delete(id);
	}
}
