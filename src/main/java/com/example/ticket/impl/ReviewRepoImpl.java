package com.example.ticket.impl;

import com.example.ticket.model.Review;
import com.example.ticket.repo_services.ReviewRepoInterface;
import com.example.ticket.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReviewRepoImpl implements ReviewRepoInterface {

	private final ReviewRepository reviewRepository;

	@Override
	public List<Review> getAllComments() {
		return reviewRepository.findAll();
	}

	@Override
	public Review addComment(Review review) {
		return reviewRepository.save(review);
	}

	@Override
	public List<Review> getCommentByUserId(Long id) {
		return reviewRepository.findAllById(id);
	}

	@Override
	public List<Review> getAllCommentsByStationId(Long id) {
		return reviewRepository.findAllByStationId(id);
	}
}
