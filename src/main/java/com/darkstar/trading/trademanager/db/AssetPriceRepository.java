package com.darkstar.trading.trademanager.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.darkstar.trading.trademanager.domain.AssetPrice;

public interface AssetPriceRepository extends MongoRepository<AssetPrice, String> {
	
	public AssetPrice getAssetPriceByAsset(String asset);
}
