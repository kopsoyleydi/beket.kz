package com.example.ticket.service;


import com.example.ticket.BodySample.CitySample;
import com.example.ticket.dto.CityDTO;
import com.example.ticket.mapper.CityMapper;
import com.example.ticket.model.ListOfCities;
import com.example.ticket.model.ListOfStation;
import com.example.ticket.repository.CityRepository;
import com.example.ticket.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {

	private final CityRepository cityRepository;

	private final StationRepository stationRepository;

	private final CityMapper cityMapper;

	public CityDTO addCity(CitySample citySample){
		ListOfCities cities = new ListOfCities();
		cities.setName(citySample.getName());
		ListOfStation station = new ListOfStation();
		station = stationRepository.findAllById(citySample.getStationId());
		cities.setStationId(station);
		cities.setShortName(citySample.getShortName());
		return cityMapper.toDto(cityRepository.save(cities));
	}
}
