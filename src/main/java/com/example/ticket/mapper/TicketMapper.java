package com.example.ticket.mapper;



import com.example.ticket.dto.TicketDTO;
import com.example.ticket.model.Tickets;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {

	TicketDTO toDto(Tickets tickets);

	Tickets toModel(TicketDTO ticketDTO);

	List<TicketDTO> toDtoList(List<Tickets> list);

	List<Tickets> toTicketList(List<TicketDTO> list);
}
