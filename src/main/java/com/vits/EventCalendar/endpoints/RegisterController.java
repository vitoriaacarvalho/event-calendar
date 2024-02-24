package com.vits.EventCalendar.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vits.EventCalendar.dtos.RegisterDTO;
import com.vits.EventCalendar.models.User;
import com.vits.EventCalendar.repositories.UserRepository;
import com.vits.EventCalendar.services.AuthenticationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/auth/register")
public class RegisterController {
	
	@Autowired 
	private AuthenticationService authService;
	
	@PostMapping
	public ResponseEntity<String> register(@RequestBody @Valid RegisterDTO data) {
		return authService.saveUser(data);
	}
}
