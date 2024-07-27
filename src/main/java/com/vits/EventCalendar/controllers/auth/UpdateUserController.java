package com.vits.EventCalendar.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vits.EventCalendar.dtos.UpdateUserEmailRequestDTO;
import com.vits.EventCalendar.dtos.UpdateUserPasswordRequestDTO;
import com.vits.EventCalendar.dtos.UpdateUserUsernameRequestDTO;
import com.vits.EventCalendar.models.User;
import com.vits.EventCalendar.services.auth.UpdateUserService;

@RestController
@RequestMapping("api/put/auth/update-user")
public class UpdateUserController {
	@Autowired
	private UpdateUserService updateUserService;
	
	@Autowired 
	private LogoutController logout;
	
	private User getLoggedInUserObject() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return (User) authentication.getPrincipal();
	}
	
	@PutMapping("/password")
	public ResponseEntity<Void> updatePassword(@RequestBody UpdateUserPasswordRequestDTO updatePasswordRequest) {
		String encryptedPassword = new BCryptPasswordEncoder().encode(updatePasswordRequest.newPassword());	
		updateUserService.updatePassword(getLoggedInUserObject(), encryptedPassword);
		return logout.logout();
	}
	
	@PutMapping("/username")
	public ResponseEntity<Void> updateUsername(@RequestBody UpdateUserUsernameRequestDTO updateUsernameRequest) {
		updateUserService.updateUsername(getLoggedInUserObject(), updateUsernameRequest.newUsername());
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/email")
	public ResponseEntity<Void> updateEmail(@RequestBody UpdateUserEmailRequestDTO updateEmailRequest) {
		updateUserService.updateEmail(getLoggedInUserObject(), updateEmailRequest.newEmail());
		return ResponseEntity.ok().build();
	}
}
