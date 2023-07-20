package com.example.ticket.repository;

import com.example.ticket.model.Hall;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface HallRepository extends JpaRepository<Hall, Long> {

	Hall findAllById(Long id);
}
