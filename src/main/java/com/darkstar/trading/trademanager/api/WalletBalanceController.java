package com.darkstar.trading.trademanager.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darkstar.trading.trademanager.db.WalletBalanceRepository;
import com.darkstar.trading.trademanager.domain.WalletBalance;

@RestController
@RequestMapping("/wallet-balances")
public class WalletBalanceController {

	private WalletBalanceRepository repository = null;
	
	@Autowired
	public WalletBalanceController(WalletBalanceRepository repository) {
		
		this.repository = repository;
	}
	
	@GetMapping
	@CrossOrigin(origins="http://localhost:4200")
	public List<WalletBalance> getWalletBalances() {

		List<WalletBalance> balances = repository.findAll();
				
		return balances;
	}
}
