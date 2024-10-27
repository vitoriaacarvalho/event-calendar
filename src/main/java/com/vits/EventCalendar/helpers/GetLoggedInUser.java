package com.vits.EventCalendar.helpers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.vits.EventCalendar.models.User;
@Component
public class GetLoggedInUser {

	public User getLoggedInUserObject() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return (User) authentication.getPrincipal();
	}
	
}
