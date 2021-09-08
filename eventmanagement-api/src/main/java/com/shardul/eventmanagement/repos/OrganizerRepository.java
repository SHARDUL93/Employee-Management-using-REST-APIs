package com.shardul.eventmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shardul.eventmanagement.entities.Organizer;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {

}
