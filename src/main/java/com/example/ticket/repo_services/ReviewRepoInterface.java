package com.example.ticket.repo_services;


import com.example.ticket.model.Review;

import java.util.List;

public interface ReviewRepoInterface {
	public List<Review> getAllComments();

	public Review addComment(Review review);

	public List<Review> getCommentByUserId(Long id);

	public List<Review> getAllCommentsByStationId(Long id);
}
