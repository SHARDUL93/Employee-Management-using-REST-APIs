package com.shardul.eventmanagement.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shardul.eventmanagement.controllers.exceptions.AlreadyCheckInException;
import com.shardul.eventmanagement.entities.Participant;
import com.shardul.eventmanagement.repos.ParticipantRepository;

@RepositoryRestController
@RequestMapping("/events")
public class CheckInController {

	@Autowired
	ParticipantRepository participantRepository;

	@PostMapping("/checkin/{id}")
	public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id,
			PersistentEntityResourceAssembler assembler) {

		Optional<Participant> findById = participantRepository.findById(id);
		if (findById.isPresent()) {
			Participant participant = findById.get();
			if (participant.getCheckedIn()) {
				throw new AlreadyCheckInException();
			} else {
				participant.setCheckedIn(true);
				participantRepository.save(participant);
			}
		}

		return ResponseEntity.ok(assembler.toFullResource(findById.get()));
	}

}
