package com.vits.EventCalendar.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vits.EventCalendar.helpers.GetLoggedInUser;
import com.vits.EventCalendar.repositories.UserRepository;

@Service
public class InviteUsersService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private SendEmailNotificationService mailer;
	
	@Autowired 
	private GetLoggedInUser getLoggedInUser;
	
	public void inviteUsers(List<UUID> usersIDs, String eventName) {
		String loggedInUsername = getLoggedInUser.getLoggedInUserObject().getLogin();
		String subject = String.format("You've Been Invited to %s", eventName);
		String emailBody = String.format("", null);
		
		for (UUID id : usersIDs) {
			String userEmail = repository.findEmailById(id);
			System.out.print(userEmail);
			mailer.sendEmail(userEmail, userEmail, userEmail);
		}
	}
	
}
