package com.example.ticket.api;



import com.example.ticket.BodySample.EventSample;
import com.example.ticket.BodySample.EventStatus;
import com.example.ticket.dto.EventDTO;
import com.example.ticket.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/events")
@RestController
public class EventController {

	private final EventService eventService;

	@GetMapping(value = "/getAllEvents")
	public List<EventDTO> getAllEvents() {
		return eventService.getAllEvents();
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PostMapping(value = "/addEvent")
	public EventDTO addEvent(@RequestBody EventSample eventSample) {
		return eventService.addEvent(eventSample);
	}

	@GetMapping(value = "/getEvent/{id}")
	public EventDTO getEventById(@PathVariable(name = "id") Long id) {
		return eventService.getEventById(id);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PostMapping(value = "/updateEvent")
	public EventDTO updateEvent(@RequestBody EventSample eventSample) {
		return eventService.updateEvent(eventSample);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PostMapping(value = "/event-status-change")
	public EventDTO changeStatus(@RequestBody EventStatus eventStatus){
		return eventService.changeStatus(eventStatus);
	}
}
