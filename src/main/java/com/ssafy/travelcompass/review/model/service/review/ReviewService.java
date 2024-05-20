package com.ssafy.travelcompass.review.model.service.review;

import java.util.List;

import com.ssafy.travelcompass.review.model.dto.review.TripReviewDto;

public interface ReviewService {

	void writeReview(TripReviewDto requestTripReview) throws Exception;
}
