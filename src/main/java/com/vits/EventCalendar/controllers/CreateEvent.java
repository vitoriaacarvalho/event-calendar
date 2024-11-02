package com.vits.EventCalendar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.vits.EventCalendar.dtos.CreateEventRequestDTO;
import com.vits.EventCalendar.services.CreateEventService;

@RestController
@RequestMapping("event/create")
public class CreateEvent {

	@Autowired
	private CreateEventService createEventService;

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> createEvent(@RequestPart("data") String dataJson, @RequestPart("file") MultipartFile file) {
	    ObjectMapper objectMapper = new ObjectMapper();
	    CreateEventRequestDTO data;
		try {
			objectMapper.registerModule(new JavaTimeModule()); 
			data = objectMapper.readValue(dataJson, CreateEventRequestDTO.class);
			createEventService.createEvent(data, file);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().build();
	}
}
