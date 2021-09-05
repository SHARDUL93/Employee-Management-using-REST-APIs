package com.shardul.eventmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.shardul.eventmanagement.entities.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
