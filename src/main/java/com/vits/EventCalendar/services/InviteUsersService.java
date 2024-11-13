package com.vits.EventCalendar.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vits.EventCalendar.helpers.GetLoggedInUser;
import com.vits.EventCalendar.models.Event;
import com.vits.EventCalendar.repositories.EventRepository;
import com.vits.EventCalendar.repositories.UserRepository;

@Service
public class InviteUsersService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private SendEmailNotificationService mailer;

	@Autowired
	private GetLoggedInUser getLoggedInUser;

	public void inviteUsers(List<UUID> usersIDs, UUID eventId, String emailBody) {
		Event event = eventRepository.findById(eventId).get();
		String loggedInUsername = getLoggedInUser.getLoggedInUserObject().getLogin();

		String capitalizedUsername = loggedInUsername.substring(0, 1).toUpperCase() + loggedInUsername.substring(1);
		String subject = String.format("You've Been Invited to %s by %s", event.getTitle(), capitalizedUsername);
		for (UUID id : usersIDs) {
			String userEmail = userRepository.findEmailById(id);
			if (emailBody == null || emailBody.isEmpty()) {
				String username = userRepository.findNameById(id);
				emailBody = formatEmailBodyDefaultInvite(username, event, loggedInUsername);
			}
			mailer.sendEmail(userEmail, subject, emailBody);
		}
	}
	
	private String formatEmailBodyDefaultInvite(String username, Event event, String loggedInUsername) {
		String invitationDefaultEmailBody = String.format("Hi, %s,\r\n"
				+ "%s is thrilled to invite you to their event %s, a special occasion they've carefully planned!\r\n"
				+ "\r\n" 
				+ "📍 Where: %s\r\n"
				+ "🕒 When: %s\r\n"
				+ "\r\n"
				+ "This will be an incredible opportunity to enjoy a unique moment.\r\n"
				+ "\r\n"
				+ "Don't miss the chance to be part of this event. We'd love to see you there!\r\n"
				+ "\r\n",
				username, loggedInUsername, event.getTitle(), event.getPlace(), event.getDateTime());
		return invitationDefaultEmailBody;
	}
}
