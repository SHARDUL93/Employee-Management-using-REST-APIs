package com.shardul.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.shardul.eventmanagement.entities.Venue;

public interface VenueRepository extends CrudRepository<Venue, Long> {

}
