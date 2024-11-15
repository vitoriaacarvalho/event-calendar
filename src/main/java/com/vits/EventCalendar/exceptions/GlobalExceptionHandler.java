package com.vits.EventCalendar.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(WrongRequestFormatException.class)
	public ResponseEntity<ErrorResponseModel> handleWrongRequestFormat(WrongRequestFormatException exception,
			HttpServletRequest request) {
		ErrorResponseModel error = ErrorResponseModel.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.BAD_REQUEST.value())
				.error("Bad request.")
				.message(exception.getMessage())
				.build();

		return ResponseEntity.badRequest().body(error);
	}

	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<ErrorResponseModel> handleForbidden(ForbiddenException exception,
			HttpServletRequest request) {
		ErrorResponseModel error = ErrorResponseModel.builder()
			    .timestamp(LocalDateTime.now())
				.status(HttpStatus.FORBIDDEN.value())
				.error("Forbidden.")
				.message(exception.getMessage()).build();
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
	}

	@ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<ErrorResponseModel> handleInvalidToken(InvalidTokenException exception,
			HttpServletRequest request) {
		ErrorResponseModel error = ErrorResponseModel.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.UNAUTHORIZED.value())
				.error("Unauthorized.")
				.message(exception.getMessage())
				.build();
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorResponseModel> handleAccessDenied(AccessDeniedException exception,
			HttpServletRequest request) {
		ErrorResponseModel error = ErrorResponseModel.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.FORBIDDEN.value())
				.error("Access denied.")
	            .message(exception.getMessage()) 
				.build();
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
	}
	
}
