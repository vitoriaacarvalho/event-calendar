package com.vits.EventCalendar.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vits.EventCalendar.models.EventTag;

public interface EventTagRepository extends JpaRepository<EventTag, UUID> {
	@Query(value = "SELECT tag_name FROM event_tag WHERE tag_name = ?1 AND tag_owner_id = ?2", nativeQuery = true)
	//maybe * instead of tag_name
	String findTagByNameAndOwnerId(String tagName, String ownerId);
}
