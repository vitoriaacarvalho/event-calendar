package com.vits.EventCalendar.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vits.EventCalendar.helpers.GetLoggedInUser;
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

	public void inviteUsers(List<UUID> usersIDs, UUID eventId) {
		String eventTitle = eventRepository.findTitleById(eventId);
		String loggedInUsername = getLoggedInUser.getLoggedInUserObject().getLogin();

		String capitalizedUsername = loggedInUsername.substring(0, 1).toUpperCase() + loggedInUsername.substring(1);
		String subject = String.format("You've Been Invited to %s by %s", eventTitle, capitalizedUsername);
		String emailBody = String.format("", eventTitle);

		for (UUID id : usersIDs) {
			String userEmail = userRepository.findEmailById(id);
			System.out.print(userEmail);
			mailer.sendEmail(userEmail, subject, emailBody);
		}
	}

}
