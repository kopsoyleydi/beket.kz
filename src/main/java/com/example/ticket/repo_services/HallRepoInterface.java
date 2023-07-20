package com.example.ticket.repo_services;


import com.example.ticket.model.Hall;

import java.util.List;

public interface HallRepoInterface {

	List<Hall> getAllHalls();

	Hall addHall(Hall hall);

	Hall getHallById(Long id);
}
