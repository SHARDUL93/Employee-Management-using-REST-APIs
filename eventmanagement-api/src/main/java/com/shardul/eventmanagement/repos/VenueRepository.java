package com.shardul.eventmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shardul.eventmanagement.entities.Venue;

public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {

}
