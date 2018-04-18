package com.gap.piggyBank.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.gap.piggyBank.model.CoinDenomination;

public class PiggyBankServiceInMemoryTest {

	private PiggyBankServiceInMemory piggyBankServiceInMemory;

	@Before
	public void beforeMethode() {
		piggyBankServiceInMemory = new PiggyBankServiceInMemory();
	}

	@Test
	public void testInsertCoin() {
		piggyBankServiceInMemory.insertCoin(CoinDenomination.FIFTY);
		piggyBankServiceInMemory.insertCoin(CoinDenomination.FIFTY);
		piggyBankServiceInMemory.insertCoin(CoinDenomination.FIVEHUNDRED);
		piggyBankServiceInMemory.insertCoin(CoinDenomination.ONETHOUSAND);
		piggyBankServiceInMemory.insertCoin(CoinDenomination.TWOHUNDRED);
		piggyBankServiceInMemory.insertCoin(CoinDenomination.ONETHOUSAND);

		assertEquals(new Integer(6), piggyBankServiceInMemory.getNumberOfCoins());
		assertEquals(new Integer(2), piggyBankServiceInMemory.getNumberOfCoins(CoinDenomination.FIFTY));
		assertEquals(new Integer(1), piggyBankServiceInMemory.getNumberOfCoins(CoinDenomination.FIVEHUNDRED));
		assertEquals(new Integer(2), piggyBankServiceInMemory.getNumberOfCoins(CoinDenomination.ONETHOUSAND));
		assertEquals(new Integer(1), piggyBankServiceInMemory.getNumberOfCoins(CoinDenomination.TWOHUNDRED));
	}

	@Test
	public void testGetZeroCoins() {

		assertEquals(new Integer(0), piggyBankServiceInMemory.getNumberOfCoins());
		assertEquals(new Integer(0), piggyBankServiceInMemory.getNumberOfCoins(CoinDenomination.FIFTY));
		assertEquals(new Integer(0), piggyBankServiceInMemory.getNumberOfCoins(CoinDenomination.FIVEHUNDRED));
		assertEquals(new Integer(0), piggyBankServiceInMemory.getNumberOfCoins(CoinDenomination.ONETHOUSAND));
		assertEquals(new Integer(0), piggyBankServiceInMemory.getNumberOfCoins(CoinDenomination.TWOHUNDRED));
	}

}
