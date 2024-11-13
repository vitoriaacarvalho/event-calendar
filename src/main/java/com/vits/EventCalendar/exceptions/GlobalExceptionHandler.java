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
	public ResponseEntity<ErrorResponseModel> handleWrongRequestFormat(WrongRequestFormatException exception, HttpServletRequest request) {
		ErrorResponseModel error = ErrorResponseModel.builder()
            .timestamp(LocalDateTime.now())
            .status(HttpStatus.BAD_REQUEST.value())
            .error("The format of this request is wrong. Please try again.")
            .message(exception.getMessage()) //nao sei se vou deixar isso 
            .build();
        
        return ResponseEntity.badRequest().body(error);
    }
	
	
}
