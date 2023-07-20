package com.example.ticket.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cities")
@Getter
@Setter
public class ListOfCities extends BaseModel{

	@Column(name = "name")
	private String name;

	@Column(name = "shortName")
	private String shortName;

	@ManyToOne
	private ListOfStation stationId;


}
