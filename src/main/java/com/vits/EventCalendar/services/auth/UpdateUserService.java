package com.vits.EventCalendar.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vits.EventCalendar.models.User;
import com.vits.EventCalendar.repositories.UserRepository;

@Service
public class UpdateUserService {
	@Autowired
	private UserRepository repository;

	public ResponseEntity<Void> updateUsername(User currentUser, String newUsername) {
		currentUser.setLogin(newUsername);
        repository.save(currentUser);
        return ResponseEntity.ok().build();
    }

	public ResponseEntity<Void> updatePassword(User currentUser, String updatedPassword) {
		currentUser.setPassword(updatedPassword);
        repository.save(currentUser);
        return ResponseEntity.ok().build();
    }
	
	public ResponseEntity<Void> updateEmail(User currentUser, String updatedEmail) {
		currentUser.setEmail(updatedEmail);
        repository.save(currentUser);
        return ResponseEntity.ok().build();
    }
}
