package com.example.ticket.api;

import com.example.ticket.BodySample.FilterSample;
import com.example.ticket.BodySample.RoadSample;
import com.example.ticket.dto.RoadsDTO;
import com.example.ticket.service.RoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/roads")
@RestController
public class RoadController {

	private final RoadService roadService;

	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/addRoad")
	public RoadsDTO addRoad(@RequestBody RoadSample roadSample){
		return roadService.addRoad(roadSample);
	}

	@GetMapping(value = "/getRoadByFilter")
	public List<RoadsDTO> getRoadByFilter(@RequestParam(name = "departure") String departure,
	                                      @RequestParam(name = "arrival")String arrival,
	                                      @RequestParam(name = "date") String date){
		FilterSample filterSample = new FilterSample();
		filterSample.setDepartureCityName(departure);
		filterSample.setArrivalCityName(arrival);
		filterSample.setDateRoad(date);
	return roadService.getRoadsFyFilter(filterSample);
	}
}
