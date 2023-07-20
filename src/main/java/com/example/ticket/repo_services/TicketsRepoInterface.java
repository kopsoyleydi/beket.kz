package com.example.ticket.repo_services;



import com.example.ticket.model.Tickets;

import java.util.List;

public interface TicketsRepoInterface {
	List<Tickets> getAllTickets();

	Tickets getTicketById(Long id);

	Tickets addTicket(Tickets tickets);


	List<Tickets> getAllTicketByUserId(Long id);

}
