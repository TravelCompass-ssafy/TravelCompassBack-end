package com.ssafy.travelcompass.review.model.service;

import java.util.List;

import com.ssafy.travelcompass.review.model.dto.TripReviewDto;

public interface ReviewService {
	List<TripReviewDto> getReviewList(String searchType, String searchKeyword);
}
