package com.vits.EventCalendar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vits.EventCalendar.models.EventTag;
import com.vits.EventCalendar.services.GetAllEventTagsService;

@RestController
@RequestMapping("event/tags/get-all")
public class GetAllEventTags {

	@Autowired 
	private GetAllEventTagsService getAllEventTagsService;
	
	@GetMapping
	public ResponseEntity<List<EventTag>> getAllEventTags() {
		List<EventTag> eventTags = getAllEventTagsService.getAllEventTags();
		return ResponseEntity.ok(eventTags);
	}
}
