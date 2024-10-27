package com.vits.EventCalendar.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vits.EventCalendar.models.Event;

public interface EventRepository extends JpaRepository<Event, UUID>{

}
