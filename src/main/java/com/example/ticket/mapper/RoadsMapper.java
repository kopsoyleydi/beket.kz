package com.example.ticket.mapper;


import com.example.ticket.dto.RoadsDTO;
import com.example.ticket.model.ListOfRoads;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoadsMapper {
	RoadsDTO toDto(ListOfRoads roads);

	ListOfRoads toModel(RoadsDTO roadsDTO);

	List<RoadsDTO> toDtoList(List<ListOfRoads> list);

	List<ListOfRoads> toEventList(List<RoadsDTO> list);
}
