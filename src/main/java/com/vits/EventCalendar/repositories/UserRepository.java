package com.vits.EventCalendar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.vits.EventCalendar.models.User;

public interface UserRepository extends JpaRepository<User, String>{
	UserDetails findByLogin(String login);
}
