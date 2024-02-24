package com.vits.EventCalendar.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vits.EventCalendar.dtos.RegisterDTO;
import com.vits.EventCalendar.models.user.User;
import com.vits.EventCalendar.repositories.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/auth/register")
public class RegisterController {
	@Autowired 
	private UserRepository userRepository;
	
	@PostMapping
	public ResponseEntity<String> register(@RequestBody @Valid RegisterDTO data) {
		if(this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		User newUser = new User(data.login(), encryptedPassword, data.role());
		this.userRepository.save(newUser);
		return ResponseEntity.ok().build();
	}
	
	
}
