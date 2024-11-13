package com.vits.EventCalendar.exceptions;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponseModel {
	private LocalDateTime timestamp;
	private Integer status;
	private String error;
	private String message;
}
