package com.shardul.eventmanagement.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shardul.eventmanagement.entities.Event;
import com.shardul.eventmanagement.repos.EventRepository;

@RepositoryRestController
@RequestMapping("/events")
public class EventKickOffController {

	@Autowired
	private EventRepository eventRepository;

	@PostMapping("/start/{id}")
	public ResponseEntity start(@PathVariable Long id) {
		Optional<Event> findById = eventRepository.findById(id);
		if (findById.isPresent()) {
			Event event = findById.get();
			event.setStarted(true);
			eventRepository.save(event);
		}
		else
			throw new ResourceNotFoundException();

		return ResponseEntity.ok(findById.get().getName() + " has started");
	}

}
