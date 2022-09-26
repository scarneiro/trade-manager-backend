package com.darkstar.trading.trademanager.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.darkstar.trading.trademanager.domain.WalletBalance;

public interface WalletBalanceRepository extends MongoRepository<WalletBalance, String> { }
