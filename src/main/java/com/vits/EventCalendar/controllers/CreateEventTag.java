package com.vits.EventCalendar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vits.EventCalendar.dtos.CreateEventTagRequestDTO;
import com.vits.EventCalendar.services.CreateEventTagService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("event/tags/create")
public class CreateEventTag {
	@Autowired
	private CreateEventTagService createEventTagService;
	
	@PostMapping
	public ResponseEntity<String> createEvent(@RequestBody @Valid CreateEventTagRequestDTO data) {
		return createEventTagService.createEventTag(data);
	}
}
