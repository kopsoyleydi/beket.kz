package com.example.ticket.repo_services;


import com.example.ticket.model.Event;

import java.util.List;

public interface EventRepoInterface {
	List<Event> getAllEvents();

	Event addEvent(Event event);

	Event getEventById(Long id);

	Event updateEvent(Event event);
}
