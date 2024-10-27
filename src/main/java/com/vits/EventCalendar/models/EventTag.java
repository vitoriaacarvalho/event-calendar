package com.vits.EventCalendar.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "event_tag")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventTag {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@NotNull
	@Column(unique = true)
	private String tagName;

	private String tagOwnerId;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "tags")
    private Set<Event> events = new HashSet<>();

}
