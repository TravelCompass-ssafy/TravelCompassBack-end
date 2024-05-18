package com.ssafy.travelcompass.review.model.mapper;

import java.util.List;

import com.ssafy.travelcompass.review.model.dto.ReviewCommentDto;
import com.ssafy.travelcompass.review.model.dto.ReviewImageFileDto;
import com.ssafy.travelcompass.review.model.dto.ReviewLikeDto;
import com.ssafy.travelcompass.review.model.dto.ReviewTagDto;
import com.ssafy.travelcompass.review.model.dto.TripReviewDto;

public interface ReviewMapper {
	List<TripReviewDto> getReviewList(String searchType, String searchKeyword);
	
	List<ReviewCommentDto> getReviewCommentList(int tripReviewId);
	List<ReviewImageFileDto> getReviewImageFilList(int tripReviewId);
	List<ReviewLikeDto> getReviewLikeList(int tripReviewId);
	List<ReviewTagDto> getReviewTagList(int tripReviewId);
}
