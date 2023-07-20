package com.example.ticket.impl;


import com.example.ticket.model.Event;
import com.example.ticket.repo_services.EventRepoInterface;
import com.example.ticket.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EventRepoImpl implements EventRepoInterface {

	private final EventRepository eventRepository;

	@Override
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	@Override
	public Event addEvent(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public Event getEventById(Long id) {
		return eventRepository.findAllById(id);
	}

	@Override
	public Event updateEvent(Event event) {
		return eventRepository.save(event);
	}

}
