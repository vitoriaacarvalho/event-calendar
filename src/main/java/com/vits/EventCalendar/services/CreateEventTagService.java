package com.vits.EventCalendar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vits.EventCalendar.dtos.CreateEventTagRequestDTO;
import com.vits.EventCalendar.helpers.GetLoggedInUser;
import com.vits.EventCalendar.models.EventTag;
import com.vits.EventCalendar.repositories.EventTagRepository;

@Service
public class CreateEventTagService {
	@Autowired
	private EventTagRepository repository;

	@Autowired
	private GetLoggedInUser getLoggedInUser;

	public ResponseEntity<String> createEventTag(CreateEventTagRequestDTO data) {
		String tagOwnerId = getLoggedInUser.getLoggedInUserObject().getId().toString();
		String tag = repository.findTagByNameAndOwnerId(data.tagName().toUpperCase(), tagOwnerId);
		if (tag == null) {
			EventTag newTag = new EventTag();
			newTag.setTagOwnerId(tagOwnerId);
			newTag.setTagName(data.tagName().toUpperCase());
			repository.save(newTag);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(String.format("You have already created this tag: '%s' .", data.tagName()));
		}
	}
}
