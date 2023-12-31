package com.example.ticket.dto;


import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BusDTO {

	private Long id;
	@ManyToOne
	private StationDTO station_id;

	private int places;

	private String govNumber;
}
