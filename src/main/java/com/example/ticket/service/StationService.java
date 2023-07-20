package com.example.ticket.service;

import com.example.ticket.BodySample.StationSample;
import com.example.ticket.dto.StationDTO;
import com.example.ticket.mapper.StationMapper;
import com.example.ticket.model.ListOfStation;
import com.example.ticket.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StationService {

	private final StationRepository stationRepository;

	private final StationMapper stationMapper;

	public StationDTO addStation(StationSample sample){
		ListOfStation station = new ListOfStation();
		station.setStationName(sample.getStationName());
		station.setAddress(sample.getAddress());
		station.setContact(sample.getContact());
		return stationMapper.toDto(stationRepository.save(station));
	}
}
