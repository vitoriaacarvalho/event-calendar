package com.vits.EventCalendar.services;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vits.EventCalendar.dtos.CreateEventRequestDTO;
import com.vits.EventCalendar.helpers.GetLoggedInUser;
import com.vits.EventCalendar.models.Event;
import com.vits.EventCalendar.models.EventTag;
import com.vits.EventCalendar.repositories.EventRepository;

@Service
public class CreateEventService {

	@Autowired
	private EventRepository repository;

	@Autowired
	private GetLoggedInUser loggedInUser;

	@Autowired
	private GetEventTagByIdService getEventTag;

	public void createEvent(CreateEventRequestDTO data) {
		Event event = new Event();
		event.setTags(getEventTagsObjects(data.eventTagsId()));
		event.setSpotifyPlaylistLink(data.spotifyPlaylistLink());
		event.setDescription(data.description());
		event.setDateTime(data.date());
		event.setTitle(data.title());
		event.setPlace(data.place());
		event.setEventOwner(loggedInUser.getLoggedInUserObject());

		repository.save(event);
	}

	private Set<EventTag> getEventTagsObjects(Set<String> data) {
		Set<EventTag> tags = new HashSet<>();
		for (String tagId : data) {
			UUID uuid = UUID.fromString(tagId);
			EventTag tag = getEventTag.getEventTagById(uuid);
			tags.add(tag);
		}
		return tags;
	}

}
