package com.vits.EventCalendar.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "event")
@Table(name = "event")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@NotNull
	private String title;

	@NotNull
	private String place;

	@Size(min = 10, max = 500, message = "Description length must be between 10 and 500 characters")
	private String description;

	@FutureOrPresent
	private LocalDateTime dateTime;

	// not sure:
	private ArrayList<User> attendingUsers;

	private Boolean emailNotificationSent;

	@URL(protocol = "https")
	private String spotifyPlaylistLink;

	@JsonIgnoreProperties("events")
	@ManyToMany
	@JoinTable(name = "tagged_events", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private Set<EventTag> tags = new HashSet<>();

	@JsonIgnoreProperties("createdEvents")
	@NotNull
	@ManyToOne
    @JoinColumn(name = "created_by_user_id", referencedColumnName = "id")
	private User eventOwner;
}
