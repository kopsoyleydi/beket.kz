package com.example.ticket.service;

import com.example.ticket.BodySample.BusSample;
import com.example.ticket.dto.BusDTO;
import com.example.ticket.mapper.BusMapper;
import com.example.ticket.model.ListOfBus;
import com.example.ticket.model.ListOfStation;
import com.example.ticket.repository.BusRepository;
import com.example.ticket.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusService {
	private final BusRepository busRepository;

	private final StationRepository stationRepository;

	private final BusMapper busMapper;

	public BusDTO addBus(BusSample sample){
		ListOfStation station = new ListOfStation();
		station = stationRepository.findAllById(sample.getStationId());
		ListOfBus bus = new ListOfBus();
		bus.setStation_id(station);
		bus.setPlaces(sample.getPlaces());
		bus.setGovNumber(sample.getGovNumber());
		return busMapper.toDto(busRepository.save(bus));
	}
}
