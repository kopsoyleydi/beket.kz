package com.example.ticket.repository;

import com.example.ticket.model.ListOfStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<ListOfStation,Long> {

	ListOfStation findAllById(Long id);
}
