package com.vits.EventCalendar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vits.EventCalendar.models.Event;

public interface EventRepository extends JpaRepository<Event, String>{

}
