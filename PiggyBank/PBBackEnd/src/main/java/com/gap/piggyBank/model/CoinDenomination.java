package com.gap.piggyBank.model;

import java.util.Optional;

public enum CoinDenomination {

	FIFTY("50"),
	ONEHUNDRED("100"),
	TWOHUNDRED("200"),
	FIVEHUNDRED("500"),
	ONETHOUSAND("1000");

	private String denomination;

	private CoinDenomination(String denomination) {
		this.denomination = denomination;
	}
	
	public String getDenomitaion() {
		return denomination;
	}
	
	public static Optional<CoinDenomination> getCoinDenomination(String denomination) {
		
		for (CoinDenomination coin : CoinDenomination.values()) {
			if (coin.getDenomitaion().equals(denomination)) {
				return Optional.of(coin);
			}
		}
		return Optional.empty();
	}
}
