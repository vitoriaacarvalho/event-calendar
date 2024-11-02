package com.vits.EventCalendar.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	@Autowired 
	private UploadFileToS3Bucket uploadFileService;
	
	@Autowired
	private SendEmailNotificationService mailer;
	
	public void createEvent(CreateEventRequestDTO data, MultipartFile file) {
		Event event = new Event();
		event.setTags(getEventTagsObjects(data.eventTagsId()));
		event.setSpotifyPlaylistLink(data.spotifyPlaylistLink());
		event.setDescription(data.description());
		event.setDateTime(data.date());
		event.setTitle(data.title());
		event.setPlace(data.place());
		event.setEventOwner(loggedInUser.getLoggedInUserObject());
		
		repository.save(event);
		if (!file.isEmpty()) {
			uploadFileService.uploadFile(file);
		}
		//mock
		List<String> sendTo = new ArrayList<String>();
		sendTo.add("vitoriaprogramadora@gmail.com");
		//end mock
		//mailer.sendEmail(sendTo, "teste", "testando feature massa");
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
