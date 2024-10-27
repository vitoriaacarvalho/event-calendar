package com.vits.EventCalendar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vits.EventCalendar.models.Event;
import com.vits.EventCalendar.services.GetAllEventsService;

@RestController
@RequestMapping("event/get-all")
public class GetAllEvents {
	@Autowired
	private GetAllEventsService getAllEventsService;
	
	@GetMapping
	public ResponseEntity<List<Event>> getAllEvents(){
		List<Event> events = getAllEventsService.getAllEvents();
		return ResponseEntity.ok().body(events);
	}
}
