package com.example.ticket.service;



import com.example.ticket.BodySample.ReviewSample;
import com.example.ticket.dto.ReviewDTO;
import com.example.ticket.impl.EventRepoImpl;
import com.example.ticket.impl.ReviewRepoImpl;
import com.example.ticket.impl.UserRepoImpl;
import com.example.ticket.mapper.ReviewMapper;
import com.example.ticket.model.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

	private final ReviewMapper reviewMapper;

	private final ReviewRepoImpl commentRepo;

	private final UserRepoImpl userRepo;

	private final EventRepoImpl eventRepo;

	public List<ReviewDTO> getAllComments() {
		return reviewMapper.toDtoList(commentRepo.getAllComments());
	}

	public List<ReviewDTO> getCommentByUserId(Long id) {
		return reviewMapper.toDtoList(commentRepo.getCommentByUserId(id));
	}

	public ReviewDTO addReview(ReviewSample reviewSample){
		Review review = new Review();
		review.setUser(userRepo.getUserById(reviewSample.getUser_id()));
		review.setEvent(eventRepo.getEventById(reviewSample.getEvent_id()));
		review.setComment(reviewSample.getComment());
		return reviewMapper.toDto(commentRepo.addComment(review));
	}

	public List<ReviewDTO> getAllCommentsByRoadId(Long id){
		return reviewMapper.toDtoList(commentRepo.getAllCommentsByStationId(id));
	}
}
