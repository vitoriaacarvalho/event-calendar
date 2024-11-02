package com.vits.EventCalendar.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vits.EventCalendar.dtos.GetAllUsersResponseDTO;
import com.vits.EventCalendar.models.User;
import com.vits.EventCalendar.repositories.UserRepository;

@Service
public class GetAllUsersService {
	@Autowired
	private UserRepository repository;
	
	public List<GetAllUsersResponseDTO> getAllUsers() {
		List<User> users = repository.findAll();
		List<GetAllUsersResponseDTO> allUsers = new ArrayList<>();
		for (User user : users) {
			GetAllUsersResponseDTO dtoResponse = new GetAllUsersResponseDTO(user.getId(), user.getUsername(), user.getEmail());
			allUsers.add(dtoResponse);
		}
		return allUsers;
	}
}
