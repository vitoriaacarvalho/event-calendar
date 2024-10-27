package com.vits.EventCalendar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vits.EventCalendar.dtos.UpdateUserEmailRequestDTO;
import com.vits.EventCalendar.dtos.UpdateUserPasswordRequestDTO;
import com.vits.EventCalendar.dtos.UpdateUserUsernameRequestDTO;
import com.vits.EventCalendar.helpers.GetLoggedInUser;
import com.vits.EventCalendar.services.auth.UpdateUserService;

@RestController
@RequestMapping("auth/update-user")
public class UpdateUserController {
	@Autowired
	private UpdateUserService updateUserService;
	
	@Autowired 
	private LogoutController logout;
	
	@Autowired
	private GetLoggedInUser loggedInUser;
	
	@PutMapping("/password")
	public ResponseEntity<Void> updatePassword(@RequestBody UpdateUserPasswordRequestDTO updatePasswordRequest) {
		String encryptedPassword = new BCryptPasswordEncoder().encode(updatePasswordRequest.newPassword());	
		updateUserService.updatePassword(loggedInUser.getLoggedInUserObject(), encryptedPassword);
		return logout.logout();
	}
	
	@PutMapping("/username")
	public ResponseEntity<Void> updateUsername(@RequestBody UpdateUserUsernameRequestDTO updateUsernameRequest) {
		updateUserService.updateUsername(loggedInUser.getLoggedInUserObject(), updateUsernameRequest.newUsername());
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/email")
	public ResponseEntity<Void> updateEmail(@RequestBody UpdateUserEmailRequestDTO updateEmailRequest) {
		updateUserService.updateEmail(loggedInUser.getLoggedInUserObject(), updateEmailRequest.newEmail());
		return ResponseEntity.ok().build();
	}
}
