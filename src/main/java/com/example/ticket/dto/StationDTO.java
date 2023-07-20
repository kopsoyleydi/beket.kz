package com.example.ticket.dto;


import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class StationDTO {

	private Long id;
	private String stationName;

	private String address;

	private String contact;
}
