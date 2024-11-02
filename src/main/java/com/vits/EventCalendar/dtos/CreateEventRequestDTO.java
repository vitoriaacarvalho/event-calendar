package com.vits.EventCalendar.dtos;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.validator.constraints.URL;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Size;

public record CreateEventRequestDTO(String title, String place, LocalDateTime date, @Nullable Set<String> eventTagsId,
		@Nullable @URL String spotifyPlaylistLink, @Nullable @Size(min = 10, max = 500) String description) {
}
