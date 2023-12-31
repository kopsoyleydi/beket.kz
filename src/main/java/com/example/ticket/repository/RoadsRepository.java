package com.example.ticket.repository;

import com.example.ticket.model.ListOfRoads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoadsRepository extends JpaRepository<ListOfRoads,Long> {
	ListOfRoads findAllById(Long id);

	@Query("SELECT r FROM ListOfRoads r " +
			"WHERE r.departure.name = :departureCity " +
			"AND r.arrival.name = :arrivalCity " +
			"AND r.departure_date = :departureDate")
	List<ListOfRoads> getRoadByFilterParameter(@Param("departureCity") String departureCity,
	                                           @Param("arrivalCity") String arrivalCity,
	                                           @Param("departureDate") String departureDate);
}
