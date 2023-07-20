package com.example.ticket.impl;


import com.example.ticket.model.Tickets;
import com.example.ticket.repo_services.TicketsRepoInterface;
import com.example.ticket.repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketsRepoImpl implements TicketsRepoInterface {

	@Autowired
	private TicketsRepository ticketsRepository;

	@Override
	public List<Tickets> getAllTickets() {
		return ticketsRepository.findAll();
	}

	@Override
	public Tickets getTicketById(Long id) {
		return ticketsRepository.findTicketsById(id);
	}

	@Override
	public Tickets addTicket(Tickets tickets) {
		return ticketsRepository.save(tickets);
	}


	public List<Tickets> getTicketByRoadId(Long id) {
		return ticketsRepository.findAllByRoadId(id);
	}

	@Override
	public List<Tickets> getAllTicketByUserId(Long id) {
		return ticketsRepository.findAllByUserId(id);
	}
}
