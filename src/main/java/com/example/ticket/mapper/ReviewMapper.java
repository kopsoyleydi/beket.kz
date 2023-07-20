package com.example.ticket.mapper;



import com.example.ticket.dto.ReviewDTO;
import com.example.ticket.model.Review;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
	ReviewDTO toDto(Review review);

	Review toModel(ReviewDTO reviewDTO);

	List<ReviewDTO> toDtoList(List<Review> list);

	List<Review> toCommentList(List<ReviewDTO> list);
}
