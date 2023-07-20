package com.example.ticket.mapper;


import com.example.ticket.dto.RoadsDTO;
import com.example.ticket.dto.StationDTO;
import com.example.ticket.model.ListOfRoads;
import com.example.ticket.model.ListOfStation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StationMapper {
	StationDTO toDto(ListOfStation station);

	ListOfStation toModel(StationDTO stationDTO);

	List<StationDTO> toDtoList(List<ListOfStation> list);

	List<ListOfStation> toEventList(List<StationDTO> list);
}
