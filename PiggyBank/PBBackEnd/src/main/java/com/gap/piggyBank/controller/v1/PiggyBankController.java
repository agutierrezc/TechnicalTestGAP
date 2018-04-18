package com.gap.piggyBank.controller.v1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gap.piggyBank.model.CoinDenomination;
import com.gap.piggyBank.service.PiggyBankService;
import com.gap.piggyBank.util.BusinessException;

@RestController
@RequestMapping("/v1")
public class PiggyBankController {

	@Autowired
	private PiggyBankService piggyBankService;

	@RequestMapping(value = "/coin/{denomination}", method = RequestMethod.POST)
	public ResponseEntity<String> insertCoin(@PathVariable(value = "denomination") String denomination)
			throws BusinessException {

		CoinDenomination.getCoinDenomination(denomination).map(Optional::of)
				.orElseThrow(() -> new BusinessException("Denomination coin is not valid"))
				.ifPresent(coinDenomination -> piggyBankService.insertCoin(coinDenomination));

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/coin/", method = RequestMethod.GET)
	public ResponseEntity<String> getNumberOfCoins() throws BusinessException {

		Integer numberOfCoins = piggyBankService.getNumberOfCoins();

		return new ResponseEntity<String>(Integer.toString(numberOfCoins), HttpStatus.OK);
	}

	@RequestMapping(value = "/coin/{denomination}", method = RequestMethod.GET)
	public ResponseEntity<String> getNumberOfCoins(@PathVariable(value = "denomination") String denomination)
			throws BusinessException {

		Integer numberOfCoins = CoinDenomination.getCoinDenomination(denomination).map(Optional::of)
				.orElseThrow(() -> new BusinessException("Denomination coin is not valid")).map(coinDenomination -> {
					return piggyBankService.getNumberOfCoins(coinDenomination);
				}).get();

		return new ResponseEntity<String>(Integer.toString(numberOfCoins), HttpStatus.OK);
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> exceptionHandler(BusinessException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_IMPLEMENTED);
	}

}
