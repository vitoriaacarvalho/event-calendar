package com.vits.EventCalendar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vits.EventCalendar.models.EventTag;
import com.vits.EventCalendar.repositories.EventTagRepository;

@Service
public class GetAllEventTagsService { 
	@Autowired
	private EventTagRepository repository;
	
	public List<EventTag> getAllEventTags() {
		List<EventTag> eventTagList =  repository.findAll();
		return eventTagList;
	}
}
