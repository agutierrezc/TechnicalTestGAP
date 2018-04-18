package com.gap.piggyBank.service;

import com.gap.piggyBank.model.CoinDenomination;

public interface PiggyBankService {
	
	public void insertCoin(CoinDenomination coinDenomination);
	
	public Integer getNumberOfCoins(CoinDenomination coinDenomination);
	
	public Integer getNumberOfCoins();

}
