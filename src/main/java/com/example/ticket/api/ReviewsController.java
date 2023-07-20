package com.example.ticket.api;



import com.example.ticket.BodySample.ReviewSample;
import com.example.ticket.dto.ReviewDTO;
import com.example.ticket.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReviewsController {

	private final ReviewService reviewService;

	@GetMapping(value = "/getAllComments")
	public List<ReviewDTO> getAllComments() {
		return reviewService.getAllComments();
	}

	@GetMapping(value = "/getAllCommentsByUserId/{id}")
	public List<ReviewDTO> getAllCommentByUserId(@PathVariable(name = "id") Long id) {
		return reviewService.getCommentByUserId(id);
	}

	@GetMapping(value = "/getCommentByEventId/{id}")
	public List<ReviewDTO> getAllCommentsByRoadId(@PathVariable(name = "id") Long id){
		return reviewService.getAllCommentsByRoadId(id);
	}

	@PostMapping(value = "/addReview")
	public ReviewDTO addReview(@RequestBody ReviewSample reviewSample){
		return reviewService.addReview(reviewSample);
	}
}
