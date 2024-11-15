package com.vits.EventCalendar.exceptions;
import org.springframework.security.core.AuthenticationException;

public class InvalidTokenException extends AuthenticationException {

	private static final long serialVersionUID = 1L;
	private static final String ERROR_MESSAGE = "Invalid or expired authorization token. Log in and try again.";

	public InvalidTokenException() {
		super(ERROR_MESSAGE);
	}
	public InvalidTokenException(String msg) {
		super(msg);
	}

}
