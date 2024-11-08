package com.vits.EventCalendar.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vits.EventCalendar.dtos.RegisterDTO;
import com.vits.EventCalendar.models.User;
import com.vits.EventCalendar.repositories.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByLogin(username);
	}

	public ResponseEntity<String> saveUser(RegisterDTO data) {
		if (this.userRepository.findByLogin(data.login()) != null || this.userRepository.findByEmail(data.email()) != null ) {
			return ResponseEntity.badRequest().body("Username or email is already in use. Please choose another one and try again.");
		}
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		User newUser = new User(data.login(), encryptedPassword, data.email(), data.role());
		this.userRepository.save(newUser);
		return ResponseEntity.ok().build();
	}
}
