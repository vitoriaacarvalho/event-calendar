package com.vits.EventCalendar.exceptions;

public class WrongRequestFormatException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public WrongRequestFormatException(String message) {
		super(message);
	}
}
