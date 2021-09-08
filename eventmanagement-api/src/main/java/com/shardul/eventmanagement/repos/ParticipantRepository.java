package com.shardul.eventmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shardul.eventmanagement.entities.Participant;

public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {

}
