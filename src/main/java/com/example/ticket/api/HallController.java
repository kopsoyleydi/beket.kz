package com.example.ticket.api;


import com.example.ticket.dto.HallDTO;
import com.example.ticket.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HallController {

	private final HallService hallService;

	@GetMapping(value = "/getAllHalls")
	public List<HallDTO> getAllHalls() {
		return hallService.getAllHalls();
	}

	@PostMapping(value = "/addHall/{id}")
	public HallDTO addHall(@PathVariable(name = "id") Long id) {
		return hallService.getHallById(id);
	}
}
