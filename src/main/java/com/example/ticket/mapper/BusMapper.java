package com.example.ticket.mapper;

import com.example.ticket.dto.BusDTO;
import com.example.ticket.model.ListOfBus;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface BusMapper {
	BusDTO toDto(ListOfBus buses);

	ListOfBus toModel(BusDTO busDTO);

	List<BusDTO> toDtoList(List<ListOfBus> list);

	List<ListOfBus> toEventList(List<BusDTO> list);
}
