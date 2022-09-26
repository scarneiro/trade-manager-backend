package com.darkstar.trading.trademanager.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.darkstar.trading.trademanager.testing.model.TickerResult;

public class BittrexApiTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		RestTemplate rest = new RestTemplate();
		TickerResult result = 
				rest.getForObject("https://api.bittrex.com/api/v1.1/public/getticker?market={market}", 
						TickerResult.class, 
						"BTC-ADA");
		
		Assert.assertNotNull("Resultado nulo.", result);
		Assert.assertEquals(Boolean.TRUE, result.getSuccess());
		Assert.assertEquals("", result.getMessage());
		Assert.assertNotNull("Ticker nulo.", result.getResult());
		Assert.assertNotEquals(0.0D, result.getResult().getAsk(), 0.0D);
		Assert.assertNotEquals(0.0D, result.getResult().getBid(), 0.0D);
		Assert.assertNotEquals(0.0D, result.getResult().getLast(), 0.0D);
	}

}
