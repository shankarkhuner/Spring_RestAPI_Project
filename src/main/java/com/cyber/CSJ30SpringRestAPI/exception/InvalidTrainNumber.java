package com.cyber.CSJ30SpringRestAPI.exception;

public class InvalidTrainNumber extends Exception {

	public InvalidTrainNumber(String errorMsg)
	{
		super(errorMsg);
	}
}
