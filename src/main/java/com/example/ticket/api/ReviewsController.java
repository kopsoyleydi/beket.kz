package com.example.ticket.api;


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

	@GetMapping(value = "/getCommentByEventId/{id}")
	public List<ReviewDTO> getAllCommentsByRoadId(@PathVariable(name = "id") Long id){
		return reviewService.getAllCommentsByRoadId(id);
	}
}
