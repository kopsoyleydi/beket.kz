package com.example.ticket.mapper;


import com.example.ticket.dto.EventDTO;
import com.example.ticket.model.Event;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
	EventDTO toDto(Event event);

	Event toModel(EventDTO eventDTO);

	List<EventDTO> toDtoList(List<Event> list);

	List<Event> toEventList(List<EventDTO> list);
}
