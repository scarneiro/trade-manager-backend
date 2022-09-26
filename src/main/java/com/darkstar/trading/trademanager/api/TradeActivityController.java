package com.darkstar.trading.trademanager.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.darkstar.trading.trademanager.db.AssetPriceRepository;
import com.darkstar.trading.trademanager.domain.AssetPrice;

@Controller
public class TradeActivityController {

	private AssetPriceRepository repository;
	
	@Autowired
	public TradeActivityController(AssetPriceRepository repository) {
		this.repository = repository;
	}
	
	@MessageMapping({"/activity-request"})
	@SendTo("/topic/activity-request")
	public String handleAssetActivityRequest(String asset) {
		
		ExampleMatcher matcher = ExampleMatcher
				.matching()
				.withStringMatcher(StringMatcher.EXACT)
				.withIgnoreCase();
		
		if (repository.exists(Example.of(new AssetPrice(asset), matcher))) {
			
			return "Asset subscription already exists for asset" + asset;
		}
		
		AssetPrice assetPrice = new AssetPrice(asset);
		assetPrice.setAskPrice(0.0D);
		assetPrice.setBidPrice(0.0D);
		assetPrice.setLastPrice(0.0D);
		
		repository.save(assetPrice);
		
		return "Activity feed enabled for asset: " + asset;
	}
}
