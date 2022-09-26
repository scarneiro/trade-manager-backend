package com.darkstar.trading.trademanager.exchange.bittrex.task;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.darkstar.trading.trademanager.api.model.AssetPriceUpdate;
import com.darkstar.trading.trademanager.db.AssetPriceRepository;
import com.darkstar.trading.trademanager.domain.AssetPrice;
import com.darkstar.trading.trademanager.exchange.bittrex.domain.TickerResult;

@Component
public class CurrentPriceUpdateTask {

	private Logger logger = Logger.getLogger(CurrentPriceUpdateTask.class);
	private AssetPriceRepository repository;
	private SimpMessageSendingOperations messaging;
	
	@Autowired
	public CurrentPriceUpdateTask(
			AssetPriceRepository repository,
			SimpMessageSendingOperations messaging) {
		
		this.repository = repository;
		this.messaging = messaging;
	}
	
	@Scheduled(fixedRate=30000)
	public void updateCurrentPrice() {
		
		List<AssetPrice> subscribedPrices = repository.findAll();
		RestTemplate rest = new RestTemplate();
		
		logger.info("Updating prices for subscribed assets");
		
		for (AssetPrice assetPrice: subscribedPrices) {
		
			logger.debug("Getting price update for BTC-" + assetPrice.getAsset());
			
			TickerResult result = 
					rest.getForObject("https://api.bittrex.com/api/v1.1/public/getticker?market={market}", 
							TickerResult.class, 
							"BTC-" + assetPrice.getAsset());	

			logger.debug("Result from invocation: " + result.getSuccess());
			
			if (result.getSuccess()) {
				
				logger.debug("Last price: " + result.getResult().getLast());
				logger.debug("Bid price: " + result.getResult().getBid());
				logger.debug("Ask price: " + result.getResult().getAsk());
			
				logger.debug("Persisting update:");

				assetPrice.setAskPrice(result.getResult().getAsk());
				assetPrice.setBidPrice(result.getResult().getBid());
				assetPrice.setLastPrice(result.getResult().getLast());
				
				repository.save(assetPrice);
			}
		
			logger.debug("Price updated. Broadcasting result...");
			messaging.convertAndSend("/topic/asset-activity", new AssetPriceUpdate(assetPrice));
		}
		
		logger.info("Prices updated successfully.");
	}
}
