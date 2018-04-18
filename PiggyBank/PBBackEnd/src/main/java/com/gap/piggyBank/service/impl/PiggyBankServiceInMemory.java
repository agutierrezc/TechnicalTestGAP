package com.gap.piggyBank.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gap.piggyBank.model.CoinDenomination;
import com.gap.piggyBank.service.PiggyBankService;

@Service
public class PiggyBankServiceInMemory implements PiggyBankService {

	private Map<CoinDenomination, Integer> insertedCoins;

	public PiggyBankServiceInMemory() {
		insertedCoins = new HashMap<>();
	}

	@Override
	public void insertCoin(CoinDenomination coinDenomination) {
		insertedCoins.merge(coinDenomination, 1, (oldValue, one) -> oldValue + one);
	}

	@Override
	public Integer getNumberOfCoins(CoinDenomination coinDenomination) {
		return insertedCoins.getOrDefault(coinDenomination, new Integer(0));
	}

	@Override
	public Integer getNumberOfCoins() {
		return insertedCoins.values().stream().mapToInt(value -> value).sum();
	}

}
