package com.example.ticket.api;


import com.example.ticket.BodySample.TicketBody;
import com.example.ticket.dto.TicketDTO;
import com.example.ticket.service.TicketsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TicketController {

	private final TicketsService ticketsService;


	@GetMapping(value = "/getAllTickets")
	public List<TicketDTO> getAllTickets() {
		return ticketsService.getTickets();
	}


	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/addTicket")
	public TicketDTO addTicket(@RequestBody TicketBody tickets) {
		return ticketsService.addTicket(tickets);
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/getTicketByUserId/{id}")
	public TicketDTO getTicketByUserId(@PathVariable(name = "id") Long id) {
		return ticketsService.getTicketByUserId(id);
	}

	@GetMapping(value = "/getAllTicketsByUserId/{id}")
	public List<TicketDTO> getAllTicketByUserId(@PathVariable(name = "id") Long id) {
		return ticketsService.getAllTicketByUserId(id);
	}

}
