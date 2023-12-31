package com.example.ticket.repository;


import com.example.ticket.model.Tickets;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public interface TicketsRepository extends JpaRepository<Tickets, Long> {
	List<Tickets> findAll();

	Tickets findTicketsById(Long id);

	List<Tickets> findAllByUserId(Long id);

	List<Tickets> findAllByRoadId(Long id);
}
