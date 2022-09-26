package com.darkstar.trading.trademanager.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.darkstar.trading.trademanager.domain.AssetPosition;

public interface AssetPositionRepository extends MongoRepository<AssetPosition, String> {
	
	public AssetPosition getAssetPositionByAsset(String asset);
}
