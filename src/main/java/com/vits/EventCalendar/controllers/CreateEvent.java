package com.vits.EventCalendar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vits.EventCalendar.dtos.CreateEventRequestDTO;
import com.vits.EventCalendar.services.CreateEventService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("event/create")
public class CreateEvent {
	
	@Autowired 
	private CreateEventService createEventService;
	
	@PostMapping
	public ResponseEntity<Void> createEvent(@RequestBody @Valid CreateEventRequestDTO data) {
		createEventService.createEvent(data);
		return ResponseEntity.ok().build();
	}
}
