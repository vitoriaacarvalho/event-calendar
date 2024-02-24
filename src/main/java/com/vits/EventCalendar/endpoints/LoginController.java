package com.vits.EventCalendar.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vits.EventCalendar.dtos.AuthenticationDTO;
import com.vits.EventCalendar.dtos.LoginResponseDTO;
import com.vits.EventCalendar.models.user.User;
import com.vits.EventCalendar.services.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/auth/login")
public class LoginController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired 
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		var token = tokenService.generateToken((User) auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
}
