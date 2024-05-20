package com.ssafy.travelcompass.review.model.service.comment;

import java.util.List;

import com.ssafy.travelcompass.review.model.dto.comment.ReviewCommentDto;

public interface ReviewCommentService {

	List<ReviewCommentDto> getCommentsByTripReviewId(int tripReviewId, int offset, int size) throws Exception;

}
