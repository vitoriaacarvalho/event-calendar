package com.vits.EventCalendar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vits.EventCalendar.dtos.InviteUsersRequestDTO;
import com.vits.EventCalendar.services.InviteUsersService;

@RestController 
@RequestMapping("/event/send-invites")
public class InviteUsersController {

	@Autowired
	private InviteUsersService inviteService;
	
	@PostMapping
	public ResponseEntity<String> inviteUsers(@RequestBody InviteUsersRequestDTO data) {
		inviteService.inviteUsers(data.invitedUsersIDs(), data.eventId());
		return ResponseEntity.ok().build();
	}
}
