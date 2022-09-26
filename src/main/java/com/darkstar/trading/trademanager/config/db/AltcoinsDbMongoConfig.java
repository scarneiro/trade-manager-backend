package com.darkstar.trading.trademanager.config.db;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages="com.darkstar.trading.trademanager.db")
public class AltcoinsDbMongoConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {

		return "AltcoinsDB";
	}
	
	@Override
	public Mongo mongo() throws Exception {
	
		return new MongoClient();
	}
}
