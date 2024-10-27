package com.vits.EventCalendar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vits.EventCalendar.models.Event;
import com.vits.EventCalendar.repositories.EventRepository;

@Service
public class GetAllEventsService {
	@Autowired 
	private EventRepository repository;
	
	public List<Event> getAllEvents() {
		List<Event> eventTagList =  repository.findAll();
		return eventTagList;
	}
}
