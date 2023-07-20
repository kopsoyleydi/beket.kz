package com.example.ticket.api;


import com.example.ticket.BodySample.StationSample;
import com.example.ticket.dto.StationDTO;
import com.example.ticket.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/station")
public class StationController {

	private final StationService stationService;

	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/addStation")
	public StationDTO addStation(@RequestBody StationSample sample){
		return stationService.addStation(sample);
	}
}
