package com.example.ticket.service;


import com.example.ticket.BodySample.FilterSample;
import com.example.ticket.BodySample.RoadSample;
import com.example.ticket.dto.RoadsDTO;
import com.example.ticket.mapper.BusMapper;
import com.example.ticket.mapper.RoadsMapper;
import com.example.ticket.model.ListOfBus;
import com.example.ticket.model.ListOfCities;
import com.example.ticket.model.ListOfRoads;
import com.example.ticket.model.ListOfStation;
import com.example.ticket.repository.BusRepository;
import com.example.ticket.repository.CityRepository;
import com.example.ticket.repository.RoadsRepository;
import com.example.ticket.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoadService {

	private final StationRepository stationRepository;

	private final BusRepository busRepository;

	private final BusMapper busMapper;

	private final CityRepository cityRepository;

	private final RoadsMapper roadsMapper;

	private final RoadsRepository roadsRepository;

	public RoadsDTO addRoad(RoadSample roadSample){
		ListOfRoads roads = new ListOfRoads();
		ListOfCities departure = new ListOfCities();
		departure = cityRepository.findAllById(roadSample.getDeparture_id());
		roads.setDeparture(departure);
		ListOfCities arrival = cityRepository.findAllById(roadSample.getArrival_id());
		roads.setArrival(arrival);
		roads.setDeparture_time(roadSample.getDeparture_time());
		roads.setArrival_time(roadSample.getArrival_time());
		roads.setDeparture_date(roadSample.getDeparture_date());
		ListOfBus bus = busRepository.findAllById(roadSample.getBus_id());
		roads.setBus_id(bus);
		return roadsMapper.toDto(roadsRepository.save(roads));
	}

	public List<RoadsDTO> getRoadsFyFilter(FilterSample filterSample){
		return roadsMapper.toDtoList(roadsRepository.getRoadByFilterParameter(filterSample.getDepartureCityName(),
				filterSample.getArrivalCityName(), filterSample.getDateRoad()));
	}
}
