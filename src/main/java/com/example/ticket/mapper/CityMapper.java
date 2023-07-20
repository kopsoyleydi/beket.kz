package com.example.ticket.mapper;

import com.example.ticket.dto.CityDTO;
import com.example.ticket.model.ListOfCities;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
	CityDTO toDto(ListOfCities cities);

	ListOfCities toModel(CityDTO cityDTO);

	List<CityDTO> toDtoList(List<ListOfCities> list);

	List<ListOfCities> toEventList(List<CityDTO> list);
}
