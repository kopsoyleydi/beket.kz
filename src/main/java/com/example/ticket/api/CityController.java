package com.example.ticket.api;


import com.example.ticket.BodySample.CitySample;
import com.example.ticket.dto.CityDTO;
import com.example.ticket.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/city")
@RequiredArgsConstructor
public class CityController {

	private final CityService cityService;

	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/addCity")
	public CityDTO addCity(@RequestBody CitySample citySample){
		return cityService.addCity(citySample);
	}
}
