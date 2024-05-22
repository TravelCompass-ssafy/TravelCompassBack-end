package com.ssafy.travelcompass.review.model.service.review;


import java.util.List;

import com.ssafy.travelcompass.review.model.dto.review.RequestWriteReview;
import com.ssafy.travelcompass.review.model.dto.review.TripReviewDto;

public interface ReviewService {

	void writeReview(RequestWriteReview requestWriteReview) throws Exception;

	List<TripReviewDto> getReviews(int offset, int size, String keyword, String category) throws Exception;

	List<TripReviewDto> getReviewsByTripDetailId(int tripDetailId) throws Exception;

	TripReviewDto getReviewById(int tripReviewId) throws Exception;

	void deleteReview(int userId, int tripReviewId) throws Exception;

	void updateReview(RequestWriteReview requestUpdateReview) throws Exception;

	List<TripReviewDto> getReviewsByUserId(int userId) throws Exception;
}
