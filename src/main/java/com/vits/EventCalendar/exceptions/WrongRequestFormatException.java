package com.vits.EventCalendar.exceptions;

public class WrongRequestFormatException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private static final String ERROR_MESSAGE = "The format of this request is wrong. Please try again.";

	public WrongRequestFormatException() {
		super(ERROR_MESSAGE);
	}
	public WrongRequestFormatException(String message) {
		super(message);
	}
}
