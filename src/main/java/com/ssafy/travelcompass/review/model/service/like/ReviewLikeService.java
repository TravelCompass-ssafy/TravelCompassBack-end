package com.ssafy.travelcompass.review.model.service.like;

import com.ssafy.travelcompass.review.model.dto.like.ReviewLikeDto;

public interface ReviewLikeService {

	void toggleLike(ReviewLikeDto like) throws Exception;

	boolean isLiked(int tripReviewId, int userId) throws Exception;

}
