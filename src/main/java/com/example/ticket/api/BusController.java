package com.example.ticket.api;

import com.example.ticket.BodySample.BusSample;
import com.example.ticket.dto.BusDTO;
import com.example.ticket.service.BusService;
import jakarta.persistence.PreRemove;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/buses")
public class BusController {

	private final BusService service;

	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/addBus")
	public BusDTO addBus(@RequestBody BusSample sample){
		return service.addBus(sample);
	}
}
