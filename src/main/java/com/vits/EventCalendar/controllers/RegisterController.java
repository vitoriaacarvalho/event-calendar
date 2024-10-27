package com.vits.EventCalendar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vits.EventCalendar.dtos.RegisterDTO;
import com.vits.EventCalendar.services.auth.AuthenticationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth/register")
public class RegisterController {
	
	@Autowired 
	private AuthenticationService authService;
	
	@PostMapping
	public ResponseEntity<String> register(@RequestBody @Valid RegisterDTO data) {
		return authService.saveUser(data);
	}
}
