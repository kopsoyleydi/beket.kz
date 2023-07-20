package com.example.ticket.repo_services;


import com.example.ticket.model.User;

import java.util.List;

public interface UserRepoInterface {
	User getUserById(Long id);
	User addUser(User user);
	List<User> getAllUsers();

	User updateParam(User user);

	User getUserByEmail(String email);
}
