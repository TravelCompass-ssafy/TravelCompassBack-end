package com.ssafy.travelcompass.review.model.service.review;


import com.ssafy.travelcompass.review.model.dto.review.RequestWriteReview;

public interface ReviewService {

	void writeReview(RequestWriteReview requestWriteReview) throws Exception;
}
