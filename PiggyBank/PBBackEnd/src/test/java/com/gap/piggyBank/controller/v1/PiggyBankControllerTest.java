package com.gap.piggyBank.controller.v1;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import com.gap.piggyBank.service.PiggyBankService;
import com.gap.piggyBank.util.BusinessException;

public class PiggyBankControllerTest {

	@Mock
	private PiggyBankService piggyBankService;

	private PiggyBankController piggyBankController;

	@Before
	public void beforeMethod() {

		initMocks(this);
		piggyBankController = new PiggyBankController();
		ReflectionTestUtils.setField(piggyBankController, "piggyBankService", piggyBankService);
	}

	@Test
	public void insertCoinTest() throws BusinessException {

		ResponseEntity<String> response = piggyBankController.insertCoin("50");

		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test(expected = BusinessException.class)
	public void insertCoinErrorTest() throws BusinessException {

		piggyBankController.insertCoin("30");

	}

	@Test
	public void getNumberOfCoinsTest() throws BusinessException {

		Integer expectedNumber = new Integer(5);
		when(piggyBankService.getNumberOfCoins()).thenReturn(expectedNumber);

		ResponseEntity<String> response = piggyBankController.getNumberOfCoins();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(Integer.toString(expectedNumber), response.getBody());

	}

	@Test
	public void getNumberOfCoinsWithDenominationTest() throws BusinessException {

		Integer expectedNumber = new Integer(5);
		when(piggyBankService.getNumberOfCoins(any())).thenReturn(expectedNumber);

		ResponseEntity<String> response = piggyBankController.getNumberOfCoins("50");
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(Integer.toString(expectedNumber), response.getBody());
	}

	@Test(expected = BusinessException.class)
	public void getNumberOfCoinsWithDenominationErrorTest() throws BusinessException {

		Integer expectedNumber = new Integer(5);
		when(piggyBankService.getNumberOfCoins(any())).thenReturn(expectedNumber);

		piggyBankController.getNumberOfCoins("30");
	}

	@Test
	public void exceptionHandlerTest() {
		String messageExpected = "ExceptionExpected";
		ResponseEntity<String> response = piggyBankController.exceptionHandler(new BusinessException(messageExpected));
		assertEquals(HttpStatus.NOT_IMPLEMENTED, response.getStatusCode());
		assertEquals(messageExpected, response.getBody());
	}

}
