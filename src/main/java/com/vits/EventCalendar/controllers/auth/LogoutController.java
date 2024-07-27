package com.vits.EventCalendar.controllers.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/get/auth/logout")
public class LogoutController {
	@GetMapping
	public ResponseEntity<Void> logout() {
	    SecurityContextHolder.getContext().setAuthentication(null);
	    return ResponseEntity.ok().build();
	}
}
