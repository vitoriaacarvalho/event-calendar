package com.vits.EventCalendar.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vits.EventCalendar.models.EventTag;
import com.vits.EventCalendar.repositories.EventTagRepository;

@Service
public class GetEventTagByIdService {

	@Autowired
	private EventTagRepository repository;

	public EventTag getEventTagById(UUID id) {
		Optional<EventTag> eventTagOptional = repository.findById(id);
		EventTag eventTag = eventTagOptional.get();
		return eventTag;
	}
}
