package com.vits.EventCalendar.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vits.EventCalendar.models.Event;

public interface EventRepository extends JpaRepository<Event, UUID>{
	@Query("SELECT e.title FROM event e WHERE e.id = :id")
	String findTitleById(@Param("id") UUID id);
}
