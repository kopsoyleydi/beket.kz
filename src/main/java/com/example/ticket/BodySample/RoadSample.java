package com.example.ticket.BodySample;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoadSample {
	private Long departure_id;

	private Long arrival_id;

	private String departure_time;

	private String arrival_time;

	private String departure_date;

	private String arrival_date;

	private Long bus_id;
}
