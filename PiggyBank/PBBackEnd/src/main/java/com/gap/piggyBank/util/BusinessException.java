package com.gap.piggyBank.util;

public class BusinessException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public BusinessException(String message) {
		super(message);
	}
	
	public String toString() {
		return getMessage();
	}
}
