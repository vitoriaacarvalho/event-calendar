package com.vits.EventCalendar.exceptions;

import org.springframework.security.core.AuthenticationException;

public class ForbiddenException extends AuthenticationException {
	private static final long serialVersionUID = 1L;
	private static final String ERROR_MESSAGE = "You don't have permission to access this feature.";
			
	public ForbiddenException(String message) {
		super(message);
	}
	
	public ForbiddenException() {
		super(ERROR_MESSAGE);
	}
}
 