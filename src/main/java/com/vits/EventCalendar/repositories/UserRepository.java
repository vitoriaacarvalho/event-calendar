package com.vits.EventCalendar.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import com.vits.EventCalendar.models.User;

public interface UserRepository extends JpaRepository<User, UUID>{
	UserDetails findByLogin(String login);
	UserDetails findByEmail(String email);
	
	@Query("SELECT u.email FROM users u WHERE u.id = :id")
    String findEmailById(@Param("id") UUID id);
}
