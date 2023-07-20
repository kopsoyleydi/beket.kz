package com.example.ticket.service;



import com.example.ticket.BodySample.TicketBody;
import com.example.ticket.EmailTicketSender;
import com.example.ticket.dto.TicketDTO;
import com.example.ticket.impl.TicketsRepoImpl;
import com.example.ticket.mapper.TicketMapper;
import com.example.ticket.model.ListOfRoads;
import com.example.ticket.model.Tickets;
import com.example.ticket.model.User;
import com.example.ticket.repository.RoadsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketsService {

	private final TicketsRepoImpl ticketsRepo;
	private final UserService userService;
	private final TicketMapper mapper;
	private final EmailTicketSender sender;
	private final ListsForData lists;
	private final RoadsRepository roadsRepository;
	private final BookingSystem bookingSystem;
	private final TicketNumberGenerator ticketNumberGenerator;

	public TicketDTO addTicket(TicketBody ticketBody) {
		User user = (User) userService.loadUserByUsername(ticketBody.getUsername());
		if (user != null) {
			Tickets tickets1 = new Tickets();
			ListOfRoads roads = roadsRepository.findAllById(ticketBody.getId());
			if (bookingSystem.minusBalance(user, ticketBody.getPrice())) {
				int random = ticketNumberGenerator.generateTicketNumber();
				tickets1.setPrimeCodeTicket((long) random);
				tickets1.setUser(user);
				tickets1.setRoadId(roads);
				lists.minusPlace(ticketBody.getPlace());
				tickets1.setPlace(ticketBody.getPlace());
				sender.sendEmail(user.getEmail(), "Your ticket", tickets1);
				return mapper.toDto(ticketsRepo.addTicket(tickets1));
			}
		}
		return null;
	}

	public List<TicketDTO> getTickets() {
		return mapper.toDtoList(ticketsRepo.getAllTickets());
	}


	public TicketDTO getTicketByUserId(Long id) {
		return mapper.toDto(ticketsRepo.getTicketById(id));
	}

	public List<TicketDTO> getTicketByRoadId(Long id) {
		return mapper.toDtoList(ticketsRepo.getTicketByRoadId(id));
	}

	public List<TicketDTO> getAllTicketByUserId(Long id) {
		return mapper.toDtoList(ticketsRepo.getAllTicketByUserId(id));
	}


}
