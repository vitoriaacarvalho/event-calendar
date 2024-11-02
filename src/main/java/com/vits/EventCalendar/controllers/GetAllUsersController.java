package com.vits.EventCalendar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vits.EventCalendar.dtos.GetAllUsersResponseDTO;
import com.vits.EventCalendar.services.GetAllUsersService;

@RestController
@RequestMapping("/users/get-all")
public class GetAllUsersController {

	@Autowired
	private GetAllUsersService getAllUsersService;

	@GetMapping
	public ResponseEntity<List<GetAllUsersResponseDTO>> getAllUsers() {
		List<GetAllUsersResponseDTO> users = getAllUsersService.getAllUsers();
		return ResponseEntity.ok().body(users);
	}
}
