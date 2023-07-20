package com.example.ticket.repository;

import com.example.ticket.model.ListOfCities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<ListOfCities,Long> {
	ListOfCities findAllById(Long id);
}
