package com.shardul.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.shardul.eventmanagement.entities.Participant;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {

}
