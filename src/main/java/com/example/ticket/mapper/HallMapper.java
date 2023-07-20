package com.example.ticket.mapper;



import com.example.ticket.dto.HallDTO;
import com.example.ticket.model.Hall;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HallMapper {
	HallDTO toDto(Hall hall);

	Hall toModel(HallDTO hallDTO);

	List<HallDTO> toDtoList(List<Hall> list);

	List<Hall> toTicketList(List<HallDTO> list);
}
