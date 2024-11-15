package com.vits.EventCalendar.exceptions;

import org.springframework.security.authentication.BadCredentialsException;

public class AccessDeniedException extends BadCredentialsException{

	private static final long serialVersionUID = 1L;
	private static final String ERROR_MESSAGE = "Invalid username or password.";

	public AccessDeniedException() {
		super(ERROR_MESSAGE);
	}
	
	public AccessDeniedException(String msg) {
		super(msg);
	}

}
