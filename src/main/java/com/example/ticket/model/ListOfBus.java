package com.example.ticket.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "buses")
@Getter
@Setter
public class ListOfBus extends BaseModel{

	@ManyToOne
	private ListOfStation station_id;

	@Column(name = "places")
	private int places;

	@Column(name = "gov_number")
	private String govNumber;


}
